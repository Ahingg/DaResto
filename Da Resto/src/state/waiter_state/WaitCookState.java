package state.waiter_state;

import facade.GameFacade;
import model.Customer;
import model.Waiter;
import state.WaiterState;
import threads.CustomerToleranceCounter;

public class WaitCookState  implements WaiterState{
	public WaitCookState(Customer customer, Waiter waiter) {
		if(customer == null) return;
		if(!waiter.getMediator().waiterFindCook(customer, waiter)) {
			CustomerToleranceCounter counter = new CustomerToleranceCounter(4, customer);
			counter.start();
			
			Thread a = new Thread(() -> {
				try {
					do {
						if(customer == null || GameFacade.end) break;
						if(GameFacade.paused) continue;
						if(waiter.getMediator().waiterFindCook(customer, waiter)) {
							counter.stopCounting();
							counter.interrupt();
						}
						Thread.sleep(100);
					}while(waiter.getState() instanceof WaitCookState);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			});
			a.setName("Thread kecil nunggu chef" + waiter.getName());
			a.start();
		}
	}
	

	@Override
	public void reset(Waiter waiter) {
		waiter.setState(new IdleState());
	}

	@Override
	public String getPrintFormat() {
		return "wait cook";
	}


	@Override
	public void changeState(WaiterState state) {
		
	}

}
