package factory;

import mediator.Mediator;
import model.Customer;
import state.customer_state.OrderState;

public class CustomerFactory {
	public static Customer CreateCustomer(Mediator mediator) {
		Customer customer = new Customer(NameGenerator.generate(mediator), mediator);
		customer.setState(new OrderState(customer));
		
		return customer;
	}
}
