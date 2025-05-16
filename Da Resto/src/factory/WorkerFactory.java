package factory;

import mediator.Mediator;
import model.Chef;
import model.Waiter;
import model.Worker;

public class WorkerFactory {

	public static Worker createWorker(Mediator mediator, String type) {
		if(type.equals("waiter")) {
			return new Waiter(NameGenerator.generate(mediator), mediator);
		}else {
			return new Chef(NameGenerator.generate(mediator), mediator);
		}
	};

}
