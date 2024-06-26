package factory;

import mediator.Mediator;
import model.Waiter;

public class WaiterFactory {
	
	public static Waiter createWaiter(Mediator mediator) {
		return new Waiter(NameGenerator.generate(mediator), mediator);
	}
}
