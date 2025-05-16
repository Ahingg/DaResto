package threads;

import java.util.Scanner;

import facade.GameFacade;

public class EnterListener extends Thread{
	GameFacade gameFacade;
	Scanner sc = new Scanner(System.in);
	public EnterListener(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}
	
	@Override
	public void run() {
		while(!GameFacade.end) {
			if(!GameFacade.paused) {
				String a = sc.nextLine();
				if(a.isEmpty()){
					GameFacade.paused = true;
					gameFacade.PauseMenu();
				}
			}
		}
	}
}
