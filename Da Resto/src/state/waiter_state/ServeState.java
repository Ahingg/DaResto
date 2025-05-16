package state.waiter_state;

import facade.GameFacade;
import model.Chef;
import model.Customer;
import model.Waiter;
import state.WaiterState;
import state.customer_state.EatState;

public class ServeState  implements WaiterState{
	Customer customer;
	public ServeState(Customer customer, Chef chef, Waiter waiter) {
		if(customer == null) {
			waiter.resetState();
			chef.resetState();
			return;
		}
		this.customer = customer;
		new Thread(() -> {
			try {

				Thread.sleep(1000);
				while(GameFacade.paused) {
					if(GameFacade.end) return;
				}
				customer.setState(new EatState(customer, chef));
				waiter.resetState();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();;
	}
	
	@Override
	public void reset(Waiter waiter) {
		
	}

	@Override
	public String getPrintFormat() {
		return "serving<"+ customer.getName() +">";
	}

	@Override
	public void changeState(WaiterState state) {
		
	}

}
