package state.customer_state;

import model.Customer;
import state.CustomerState;
import threads.CustomerToleranceCounter;

public class WaitDeliverState  implements CustomerState{
	
	public WaitDeliverState(Customer customer) {
		CustomerToleranceCounter counter = new CustomerToleranceCounter(4,customer);
		counter.start();
		
		new Thread(() -> {
			while(customer.getState() instanceof WaitDeliverState) {
				try {
					Thread.sleep(100);
					if(customer.getTolerance() <= 0) return;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			counter.stopCounting();
		}).start();;
	}

	@Override
	public String getPrintFormat() {
		return "wait food";
	}


	@Override
	public void nextState(Customer state) {

	}

}
