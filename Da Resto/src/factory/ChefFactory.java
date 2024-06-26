package factory;

import mediator.Mediator;
import model.Chef;

public class ChefFactory {
	public static Chef createChef(Mediator mediator) {
		return new Chef(NameGenerator.generate(mediator), mediator);
	}
}
