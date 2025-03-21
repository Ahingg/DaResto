package state.chef_state;

import model.Chef;
import model.Customer;
import state.ChefState;

public class DoneState implements ChefState{
	public Customer customer;
	
	public DoneState(Customer customer, Chef chef) {
		// TODO Auto-generated constructor stub
		if(customer != null) {
			this.customer = customer;
			if(!chef.getMediator().cookDoneFindIdleWaiter(customer, chef)) {
				new Thread(() -> {
					try {
						do {
							Thread.sleep(100);
							if(chef.getMediator().cookDoneFindIdleWaiter(customer, chef)) break;
						}while(chef.getState() instanceof DoneState);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();;
			}
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
		return "done<"+ customer.getName() +">";
	}
	
	
}
