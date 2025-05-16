package main;

import java.util.Scanner;

import game.PlayGame;
import model.HighScore;
import singleton.HighScoreSingleton;

public class Main {

	Scanner sc = new Scanner(System.in);
	Integer choice;
	public Main() {
		
		while(true) {
			mainMenu();
			System.out.print(">>");
			
			choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				new PlayGame();
				break;
			}
			else if(choice == 2) {
				HighScore h = HighScoreSingleton.getInstance();
				h.printHighScores();
				
				sc.nextLine();
			}
			else if(choice == 3) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
	
	private void mainMenu() {
		System.out.println("1. Play New Restaurant");
		System.out.println("2. High Score");
		System.out.println("3. Exit");
	}

}
