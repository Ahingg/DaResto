package threads;

import facade.GameFacade;
import mediator.Mediator;
import utils.Printer;

public class PrinterThread extends Thread{
	private Mediator mediator;
	public PrinterThread(Mediator mediator) {
		 this.mediator = mediator;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!GameFacade.end) {
			try {
				if(GameFacade.paused) continue;
				Printer.PrintGameStatus(mediator);
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
