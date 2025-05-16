package state.customer_state;

import model.Chef;
import model.Customer;
import state.CustomerState;

public class WaitCookState  implements CustomerState{
	private Chef chef;
	public WaitCookState(Chef chef) {
		this.chef = chef;
	}
	@Override
	public String getPrintFormat() {
		return "wait food<" + chef.getName() +">";
	}


	@Override
	public void nextState(Customer state) {
		
	}

}
