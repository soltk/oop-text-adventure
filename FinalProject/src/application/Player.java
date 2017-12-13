/*
 * Written by:
 * 
 * Liz Berberena
 * Jack Davitt
 * Shazia Mansuri
 * Simran Nanwani
 * Huda Yousef
 * 
 */

package application;

import java.util.Random;

public class Player {

	/*
	 * A Player class which will i. Have all the relevant information you collect
	 * from the player such as location, name, etc.
	 */

	// instance variables
	private String name;
	private int health;
	private boolean death;
	private boolean[] inventory;

	public Player() {
		this.name = "";
		this.health = 3;
		this.death = false;
		this.inventory = new boolean[] { false, false, false, false, false };
	}

	public Player(String name, int health, boolean death, boolean[] inventory) {
		this.name = name;
		this.health = health;
		this.death = death;
		this.inventory = inventory;
	}

	// Name methods
	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return this.name;
	}

	// Health methods
	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return this.health;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
	}

	public boolean getDeath() {
		return this.death;
	}

	public void setInventory(boolean[] inventory) {
		this.inventory = inventory;
	}

	public boolean[] getInventory() {
		return this.inventory;
	}

	public int damage(int damage) { // method for damage
		this.health = this.health - damage;

		if (this.health <= 0) {
			this.death = true;
		}

		return damage;
	} // end of damage method

	public void heal() { // method for healing

		if (this.health < 3) {
			this.health++;
		} else {
			System.out.println("You are at full health.");
		}
	} // end of heal method

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4);
		return damage;
	}

	public String toString() {
		String displayHealth = this.name + ", your current health is: " + this.health + "/3.";
		return displayHealth;
	}

}// end of Player class
