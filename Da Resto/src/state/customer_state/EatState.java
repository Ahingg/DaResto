package state.customer_state;

import facade.GameFacade;
import model.Chef;
import model.Customer;
import state.CustomerState;

public class EatState implements CustomerState{

	public EatState(Customer customer, Chef chef) {
		new Thread(() -> {
			try {
				Thread.sleep(6000);
				while(GameFacade.paused) {
					if(GameFacade.end) return;
				}
				customer.getMediator().customerLeave(customer, chef);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	@Override
	public String getPrintFormat() {
		return "eat";
	}

	@Override
	public void nextState(Customer state) {
		
	}

}
