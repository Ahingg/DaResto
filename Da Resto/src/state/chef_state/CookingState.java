package state.chef_state;

import model.Chef;
import model.Customer;
import state.ChefState;

public class CookingState implements ChefState{
	private Customer customer;
	public CookingState(Chef chef, Customer customer) {
		if(customer != null) {
			this.customer = customer;
			new Thread(() -> {
				try {
					Thread.sleep(6000 - chef.getSkill()*1000);
					chef.setState(new DoneState(customer, chef));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		else {
			chef.resetState();
		}
	}
	
	@Override
	public String getPrintFormat() {
		return "cook<" + customer.getName() + ">";
	}



}
