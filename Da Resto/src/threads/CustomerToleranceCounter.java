package threads;

import facade.GameFacade;
import model.Customer;

public class CustomerToleranceCounter extends Thread{
	private int interval;
	private Customer customer;
	private boolean stopped;
	
	public CustomerToleranceCounter(int interval, Customer customer) {
		this.interval = interval;
		this.customer = customer;
		this.stopped = false;
		this.setName("Thread a");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startCounting();
	}
	
	
	private void startCounting() {
			try {
				while(customer.getTolerance() > 0 && !GameFacade.end && !stopped) {
					if(GameFacade.paused) continue;
					Thread.sleep(interval*1000);
					System.out.println();
					customer.decreaseTolerance();
				}
				if(customer.getTolerance() <= 0) customer.rageLeave();
			} catch (InterruptedException e) {
				stopped = true;
			}
		
	}
	
	public void stopCounting() { stopped = true; }
}
