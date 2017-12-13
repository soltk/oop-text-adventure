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

public class Enemy {

	private int lives; // property of Enemy
	private boolean death;

	public Enemy() {
		this.lives = 3; // default lives attribute
		this.death = false;

	}// end of default constructor Enemy()

	public Enemy(int lives, boolean death) {
		this.lives = lives;
		this.death = death;
	}

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4);
		return damage;
	}

	public int damage(int damage) { // method for damage
		this.lives = this.lives - damage;

		if (this.lives <= 0) {
			this.death = true;
		}
		return damage;
	}// end of damage method

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLives() {
		return this.lives;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
	}

	public boolean getDeath() {
		return this.death;
	}

	public String toString() {
		String displayLives = "The enemy's current lives are: " + this.lives + "!";
		return displayLives;
	}

}
