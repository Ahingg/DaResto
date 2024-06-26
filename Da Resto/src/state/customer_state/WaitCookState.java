package state.customer_state;

import model.Chef;
import model.Customer;
import state.CustomerState;

public class WaitCookState  implements CustomerState{
	private Chef chef;
	public WaitCookState(Chef chef) {
		// TODO Auto-generated constructor stub
		this.chef = chef;
	}
	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "wait food<" + chef.getName() +">";
	}


	@Override
	public void nextState(Customer state) {
		// TODO Auto-generated method stub
		
	}

}
