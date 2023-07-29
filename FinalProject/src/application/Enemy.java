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

public class Enemy {

	/*
	 * The Enemy class has all the relevant information the game collects
	 * from the enemy including lives and death
	 */
	
	/*Instance variables*/
	private int lives; 
	private boolean death;

	public Enemy() {
		this.lives = 3; // default lives attribute
		this.death = false;

	}// end of default constructor Enemy()

	public Enemy(int lives, boolean death) {
		this.lives = lives;
		this.death = death;
	}//end of constructor Enemy(int lives, boolean death)

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4); //set damage to a randomized integer between 0 and 3
		return damage;
	}//end of attack()

	public int damage(int damage) { 
		this.lives = this.lives - damage; //decrease lives with damage

		if (this.lives <= 0) {
			this.death = true; //death set to true
		}//end of if statement (if lives is equal to or less than 0)
		
		return damage;
	}// end of damage(int damage)

	public void setLives(int lives) {
		this.lives = lives;
	}//end of setLives(int lives)

	public int getLives() {
		return this.lives;
	}//end of getLives()
	
	public void setDeath(boolean death) {
		this.death = death;
	}//end of setDeath(boolean death)

	public boolean getDeath() {
		return this.death;
	}//end of getDeath()

	/*Overide method*/
	public String toString() {
		String displayLives = "The enemy's current lives are: " + this.lives + "!"; //outputs number of lives
		return displayLives;
	}//end of toString()

}//end of Enemy class
