package app;

import java.util.Random;
import java.util.Scanner;

public class GetAway {
	static String choice;
	static int enemyDist = 400, traveledSteps = 0, day = 0, goalDist = 800;
	static boolean alive = true, caught = false, goal = false;
	static Player runner = new Player();
	static Random rand = new Random();
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		playerBalance();
		gameLoop();
		scnr.close();

	}

	//////////////////////////////////////////////////////////////////////////
	/// Balancing the random character's speed according to health.
	//////////////////////////////////////////////////////////////////////////
	public static void playerBalance() {

		// Larger initial health pools decrease speed, smaller one increase
		if (runner.showHealth() > 40) {
			runner.adminSpeed(-8);
		} else if (runner.showHealth() < 30) {
			runner.adminSpeed(10);
		}
		if (runner.showSpeed() < 8) {
			runner.adminSpeed(8);
		}
		runner.statCheck();
	}

	//////////////////////////////////////////////////////////////////////////
	/// The main loop
	//////////////////////////////////////////////////////////////////////////
	public static void gameLoop() {
		System.out.println("\r\r\r\r    ----Welcome to Get Away ALPHA!----\r\rThe goal is to get away! Go for the end!\r\r");
		
		while (alive && !caught && !goal) {
			cycle();
			choiceCheck();
			
			if (choice.equals("4")) {
				System.out.println("\rSee ya.");
				break;
			}
			
			gameEndCheck();

		}
	}

	//////////////////////////////////////////////////////////////////////////
	/// Check for game-ending conditions
	//////////////////////////////////////////////////////////////////////////
	public static void gameEndCheck() {
		if (enemyDist <= 0) {
			enemyDist = 0;
			System.out.println("You were caught!\r---Game Over---");
			caught = true;
		}
		if (runner.showHealth() <= 0) {
			runner.adminHealth(-runner.showHealth());
			System.out.println("You died of exhaustion!\r---Game Over---");
			alive = false;
		}
		if (goalDist <= 0) {
			goalDist = 0;
			System.out.println("-------You've made it!!!-------");
			goal = true;
		}
	}

	//////////////////////////////////////////////////////////////////////////
	/// Checks the player's choice
	//////////////////////////////////////////////////////////////////////////
	public static void choiceCheck() {
		switch (choice) {
		case "1":
			traveledSteps = rand.nextInt(25);
			enemyDist += traveledSteps;
			runner.takeHit(rand.nextInt(7) + 1);
			goalDist -= traveledSteps + runner.showSpeed();
			System.out.println(goalDist + " miles away from the end!\r\r");
			enemyDist -= rand.nextInt(30);
			day++;
			break;
		case "2":
			runner.adminHealth(rand.nextInt(20 + 15));
			enemyDist -= rand.nextInt(50);
			System.out.println(
					"Slept and gained some health (Health caps at 120)!\rBut the enemy is closing the gap!\r\r");
			day++;
			break;
		case "3":
			runner.statCheck();
			System.out.println("\r\r");
			break;
		default:
			System.out.println("\rERROR - - - Please make a valid selection.\r");
			break;

		}
		if (runner.showHealth() > 120) {
			runner.adminHealth(-runner.showHealth());
			runner.adminHealth(120);

		}

	}

	//////////////////////////////////////////////////////////////////////////
	/// Starts a cycle if the player has not won and is not dead or caught
	//////////////////////////////////////////////////////////////////////////
	public static void cycle() {
		System.out.println("Day: " + day + "\rThe enemy is " + enemyDist
				+ " miles away.\rWhat would you like to do?\r\r1 - Keep moving.\r2 - Sleep.\r3 - Check your stats.\r4 - EXIT.");
		choice = scnr.next();
	}

}
