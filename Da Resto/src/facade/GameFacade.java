package facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import factory.ChefFactory;
import factory.CustomerGenerator;
import factory.WaiterFactory;
import mediator.Mediator;
import model.HighScore;
import model.Restaurant;
import singleton.RestaurantSingleton;
import threads.EnterListener;
import threads.MainThread;
import threads.PrinterThread;
import utils.Printer;

public class GameFacade {
	public static volatile boolean paused = false;
	public static volatile boolean end = false;
	private Mediator mediator;
	Restaurant restaurant;
	Scanner sc = new Scanner(System.in);
	public void initGame() {
		restaurant = RestaurantSingleton.getInstance();
		System.out.print("Insert Your Restaurant Name[3-15] : ");
		String name = sc.nextLine();
		
		restaurant.setName(name);
		
		
		mediator = new Mediator(restaurant);
		mediator.addWaiter();
		mediator.addWaiter();
		mediator.addChef();
		mediator.addChef();
		
		
		MainThread mainThread = new MainThread(mediator);
		CustomerGenerator customerThreadGenerator = new CustomerGenerator(mediator);
		
		mainThread.addObserver(customerThreadGenerator);
		mainThread.start();
		
		EnterListener el = new EnterListener(this);
		el.setName("EnterListenerThread");
		el.start();
		PrinterThread pt = new PrinterThread(mediator);
		pt.setName("PrinterThread");
		pt.start();
		

	}
	
	public void PauseMenu() {
		while(true) {
			Printer.printPauseMainMenu(restaurant);
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				paused = false;
				break;
			}
			else if (choice == 2) {
				upgradeMenu();
			}
			else if (choice == 3) {
				closeBusiness();
				break;
			}
		}

	}
	
	private void upgradeMenu() {
		while(true) {
			Printer.printUpgradeMainMenu(mediator);
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				mediator.upgradeSeat();
			}
			else if (choice == 2) {
				hireEmployeeMenu();
			}
			else if (choice == 3) {
				upgradeWaiterSpeed();
			}
			else if (choice == 4) {
				upgradeChef();
			}
			else if (choice == 5) {
				return;
			}
		}
	}
	
	private void hireEmployeeMenu() {
		while(true) {
			Printer.printHireEmployeeMenu(mediator);
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				if(restaurant.getGold() < mediator.getAddWaiterCost()) {
					System.out.println("Insufficient Gold");
					return;
				}
				restaurant.reduceGold(mediator.getAddWaiterCost());
				mediator.addWaiter();
			}
			else if (choice == 2) {
				if(restaurant.getGold() < mediator.getAddChefCost()) {
					System.out.println("Insufficient Gold");
					return;
				}
				restaurant.reduceGold(mediator.getAddChefCost());
				mediator.addChef();
			}
			else if (choice == 3) {
				return;
			}

		}
	}
	
	private void upgradeWaiterSpeed() {
		while(true) {
			Printer.printWaiterTable(mediator);
			int index = sc.nextInt();
			sc.nextLine();
			
			if(index < 0 || index > mediator.getWaiterCount()) continue;
			if(index == 0) return;
			mediator.upgradeWaiterSpeed(index-1);
		}
	}
	
	private void upgradeChef() {
		while(true) {
			Printer.printWaiterTable(mediator);
			int index = sc.nextInt();
			sc.nextLine();
			
			if(index < 0 || index > mediator.getWaiterCount()) continue;
			if(index == 0) return;
			
			String choice = sc.nextLine();
			if(choice.equals("skill")) mediator.upgradeChefSkill(index-1);
			else if(choice.equals("speed")) mediator.upgradeChefSpeed(index-1);
		}
	}
	
	private void closeBusiness() {
        HighScore highScore = new HighScore();
        int restaurantScore = restaurant.getGold();  // Assuming the restaurant's score is its gold
        highScore.addHighScore(restaurant.getName(), restaurantScore);
        
        // Print top 10 high scores
        System.out.println("Top 10 High Scores:");
        ArrayList<HighScore.ScoreEntry> topScores = highScore.getTopScores();
        for (int i = 0; i < topScores.size(); i++) {
            HighScore.ScoreEntry entry = topScores.get(i);
            String highlight = entry.getName().equals(restaurant.getName()) ? " <<<< " : "";
            System.out.println((i + 1) + ". " + entry.getName() + ": " + entry.getScore() + highlight);
        }

        // Wait for the user to press Enter to exit
        System.out.println("Press Enter to exit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        endGame();
	}
	
	public static void pauseGame() { paused = true; }
	
	public static void resumeGame() { paused = false; }
	
	public static void endGame() { end = true; }
}
