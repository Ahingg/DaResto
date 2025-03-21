package factory;

import mediator.Mediator;
import observer.Observer;

public class CustomerGenerator implements Observer{
	private Mediator mediator;
	
	public CustomerGenerator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void generateCustomer() {
		// TODO Auto-generated method stub
		mediator.addCustomer(CustomerFactory.CreateCustomer(mediator));
	}
}
