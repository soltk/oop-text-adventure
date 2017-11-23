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

public class Enemy extends StartAdventure{

	public Enemy(){
		
	} // end of Enemy()
	
	public int attack(){
		Random rand = new Random();
		int damage = rand.nextInt(4);
		return damage;
	}
	
}
