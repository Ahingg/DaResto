package state.customer_state;

import model.Customer;
import model.Waiter;
import state.CustomerState;

public class WaitFoodState  implements CustomerState{

	private Waiter waiter;
	public WaitFoodState(Waiter waiter) {
		this.waiter = waiter;
	}

	@Override
	public String getPrintFormat() {
		return "wait food<" + waiter.getName() + ">";
	}


	@Override
	public void nextState(Customer state) {
		
	}

}
