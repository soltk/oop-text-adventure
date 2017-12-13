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

	public Enemy() {
		this.lives = 3; // default lives attribute

	}// end of default constructor Enemy()

	public Enemy(int lives) {
		this.lives = lives;
	}

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4);
		return damage;
	}

	public boolean damage(int damageValue) { // method for damage
		boolean enemyDead = false;
		this.lives = this.lives - damageValue;

		if (this.lives <= 0) {
			enemyDead = true;
		}
		return enemyDead;
	}// end of damage method

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLives() {
		return this.lives;
	}

	public String toString() {
		String displayLives = "The enemy's current lives are: " + this.lives;
		return displayLives;
	}

}
