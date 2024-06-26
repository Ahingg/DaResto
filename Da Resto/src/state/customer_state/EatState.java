package state.customer_state;

import facade.GameFacade;
import model.Chef;
import model.Customer;
import state.CustomerState;

public class EatState implements CustomerState{

	public EatState(Customer customer, Chef chef) {
		// TODO Auto-generated constructor stub
		new Thread(() -> {
			try {
				Thread.sleep(6000);
				while(GameFacade.paused) {
					if(GameFacade.end) return;
				}
				customer.getMediator().customerLeave(customer, chef);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "eat";
	}

	@Override
	public void nextState(Customer state) {
		// TODO Auto-generated method stub
		
	}

}
