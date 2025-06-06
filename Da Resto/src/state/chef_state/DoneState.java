package state.chef_state;

import model.Chef;
import model.Customer;
import state.State;

public class DoneState implements State{
	public Customer customer;
	
	public DoneState(Customer customer, Chef chef) {
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
	public String getPrintFormat() {
		return "done<"+ customer.getName() +">";
	}
	
	
}
