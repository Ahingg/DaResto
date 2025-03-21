package state.customer_state;

import facade.GameFacade;
import model.Customer;
import state.CustomerState;
import threads.CustomerToleranceCounter;

public class OrderState implements CustomerState{
	
	public OrderState(Customer customer) {
		if(!customer.getMediator().customerOrder(customer)) {
			CustomerToleranceCounter counter = new CustomerToleranceCounter(2, customer);
			counter.start();

			Thread a = new Thread(() -> {
				try {
					do {
						if(GameFacade.end) break;
						if(GameFacade.paused) continue;
						if(customer.getMediator().customerOrder(customer)) {
							counter.interrupt();
							counter.stopCounting();
						}
						Thread.sleep(100);
					}while(customer.getState() instanceof OrderState);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			});
			a.setName("Thread kecil" + customer.getName());
			a.start();
		}

	}

	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "order";
	}

	@Override
	public void nextState(Customer state) {
		// TODO Auto-generated method stub
		
	}

}
