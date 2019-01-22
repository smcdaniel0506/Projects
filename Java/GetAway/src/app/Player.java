package app;

import java.util.Random;

public class Player {

	private Random rand = new Random();
	private int health = rand.nextInt(25 + rand.nextInt(10)) + 25;
	private int speed = 3 * rand.nextInt(6) + 3;

	//damage
	public void takeHit(int hit) {
		health -= hit;
	}

	// correcting speed value
	public void adminSpeed(int adminCorrect) {
		this.speed += adminCorrect;
	}

	// correcting health value
	public void adminHealth(int adminCorrect) {
		this.health += adminCorrect;
	}

	public int showHealth() {
		return health;
	}

	public int showSpeed() {
		return speed;
	}

	// display player health and speed
	public void statCheck() {
		System.out.println("Your stats: ");
		System.out.println("Health - " + health);
		System.out.println("Speed - " + speed);
	}

}
