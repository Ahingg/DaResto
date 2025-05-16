package state.waiter_state;

import facade.GameFacade;
import model.Chef;
import model.Customer;
import model.Waiter;
import state.WaiterState;
import state.chef_state.CookingState;
import state.chef_state.DoneState;

public class BringOrderState implements WaiterState{
	private Chef chef;

	public BringOrderState(Chef chef, Customer customer, Waiter waiter) {
		this.chef = chef;
		
		if (customer != null) {
			new Thread(() -> {
				try {
					Thread.sleep(1000);
					while(GameFacade.paused) {
						if(GameFacade.end) return;
					}
					if((chef.getState() instanceof state.chef_state.IdleState)) {
						chef.setState(new CookingState(chef, customer));
						waiter.setState(new IdleState());
					}
						
					else if((chef.getState() instanceof DoneState)) {
						DoneState d = (DoneState) chef.getState();
						waiter.setState(new ServeState(d.customer, chef, waiter));
						chef.setState(new CookingState(chef, customer));
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();;
		}
		else {
			chef.resetState();
			waiter.resetState();
		}

	}
	
	
	
	@Override
	public void reset(Waiter waiter) {
	}

	@Override
	public String getPrintFormat() {
		return "bring order<" + chef.getName() + ">";
	}

	@Override
	public void changeState(WaiterState state) {
		
	}
	

}
