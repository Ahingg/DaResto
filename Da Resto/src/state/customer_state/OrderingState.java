package state.customer_state;

import model.Customer;
import model.Waiter;
import state.CustomerState;

public class OrderingState  implements CustomerState{

	Waiter waiter;
	public OrderingState(Waiter waiter) {
		this.waiter = waiter;

	}
	
	@Override
	public String getPrintFormat() {
		return "order<" + waiter.getName() + ">";
	}

	@Override
	public void nextState(Customer state) {
		// TODO Auto-generated method stub
		state.setState(new WaitDeliverState(state));
	}
	


}
