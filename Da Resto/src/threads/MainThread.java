package threads;

import java.util.ArrayList;
import java.util.Random;

import facade.GameFacade;
import factory.CustomerGenerator;
import mediator.Mediator;
import observer.Broadcaster;
import observer.Observer;

public class MainThread extends Thread implements Broadcaster{
	private Mediator mediator;
	private ArrayList<Observer> observers;
	Random r = new Random();
	public MainThread(Mediator mediator) {
		this.mediator = mediator;
		observers = new ArrayList<>();
	}
	
	@Override
	public void run() {
		while(!GameFacade.end) {
			if(GameFacade.paused || mediator.restaurantIsFull()) continue;
			try {
				int n = r.nextInt(4);
				if(n == 1)  notifyObserver(); 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			
		}	
	}
	@Override
	public void addObserver(CustomerGenerator t) {
		observers.add(t);
	}
	@Override
	public void removeObserver(CustomerGenerator t) {
		observers.remove(t);
	}
	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.generateCustomer();
		}
	}
}
