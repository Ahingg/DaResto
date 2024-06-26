package game;

import java.util.Scanner;

import facade.GameFacade;
import mediator.Mediator;


public class PlayGame {
	Scanner sc = new Scanner(System.in);
	private boolean onPause = false;
	private boolean gameEnd = false;
	private Mediator mediator;
	public PlayGame() {
		greet();
	}
	
	private void greet() {
		GameFacade facade = new GameFacade();
		facade.initGame();
	}
	public boolean getPauseState() { return onPause; }
	
	public boolean getEndState() { return gameEnd; }
	
	public Mediator getMediator() { return mediator; }
}


