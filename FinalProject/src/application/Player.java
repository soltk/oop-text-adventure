/*
 * Written by:
 * 
 * Iris of Lys
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
	 * The Player class has all the relevant information the game collects
	 * from the player including name, inventory, health, and death
	 */

	/*instance variables*/
	private String name;
	private int health;
	private boolean death;
	private boolean[] inventory;

	public Player() {
		this.name = "";
		this.health = 3;
		this.death = false;
		this.inventory = new boolean[] { false, false, false, false, false };
	}//end of no-arg constructor Player()

	public Player(String name, int health, boolean death, boolean[] inventory) {
		this.name = name;
		this.health = health;
		this.death = death;
		this.inventory = inventory;
	}//end of constructor Player(String name, int health, boolean death, boolean[] inventory)

	public void setName(String name) {
		this.name = name;
	}//end of setName(String name)

	public String getName() {
		return this.name;
	}//end of getName()

	public void setHealth(int health) {
		this.health = health;
	}//end of setHealth(int health)

	public int getHealth() {
		return this.health;
	}//end of getHealth()
	
	public void setDeath(boolean death) {
		this.death = death;
	}//end of setDeath(boolean death)

	public boolean getDeath() {
		return this.death;
	}//end of getDeath()

	public void setInventory(boolean[] inventory) {
		this.inventory = inventory;
	}//end of setInventory(boolean[] inventory)

	public boolean[] getInventory() {
		return this.inventory;
	}//end of getInventory()

	public int damage(int damage) { 
		this.health = this.health - damage; //decrease health with damage

		if (this.health <= 0) {
			this.death = true; //death set to true
		}//end of if statement (if health is equal to or less than 0)

		return damage;
	} // end of damage(int damage)

	public void heal() {

		if (this.health < 3) {
			this.health++; //health is increased by 1
		} else {
			System.out.println("You are at full health.");
		}//end of if else statement (if health is less than 3 or not)
	} //end of heal()

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4); //set damage to a randomized integer between 0 and 3
		return damage;
	}//end of attack()

	/*Overide method*/
	public String toString() {
		String displayHealth = this.name + ", your current health is: " + this.health + "/3.";
		return displayHealth;
	}//end of toString()

}// end of Player class
