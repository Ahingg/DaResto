package state.waiter_state;

import facade.GameFacade;
import model.Customer;
import model.Waiter;
import state.WaiterState;
import state.customer_state.WaitDeliverState;

public class TakeOrderState implements WaiterState{

	private Customer customer;

	public TakeOrderState(Customer customer, Waiter waiter) {
		// baru tau bisa gini :v
		if(customer == null) return;
		this.customer = customer;
		new Thread(() -> {
			try {
				Thread.sleep(6000 - waiter.getSpeed()*1000);
				while(GameFacade.paused) {
					if(GameFacade.end) return;
				}
				waiter.setState(new state.waiter_state.WaitCookState(customer, waiter));
				customer.setState(new WaitDeliverState(customer));
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
		}).start();
		
	}
	
	public String getPrintFormat() {
		return "take order<"+ customer.getName() +">";
	}

	@Override
	public void reset(Waiter waiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeState(WaiterState state) {
		// TODO Auto-generated method stub
		
	}

}
