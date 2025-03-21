package state.chef_state;

import model.Chef;
import model.Customer;
import state.ChefState;

public class CookingState implements ChefState{
	private Customer customer;
	public CookingState(Chef chef, Customer customer) {
		// TODO Auto-generated constructor stub
		if(customer != null) {
			this.customer = customer;
			new Thread(() -> {
				try {
					Thread.sleep(6000 - chef.getSkill()*1000);
					chef.setState(new DoneState(customer, chef));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
		else {
			chef.resetState();
		}
	}


	@Override
	public void reset(Chef chef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "cook<" + customer.getName() + ">";
	}

}
