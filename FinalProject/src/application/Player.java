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

public class Player {

/*
A Player class which will
i. Have all the relevant information you collect from the player such
as location, name, etc.*/

//instance variables
private String name;
private int health;


public Player() {
	this.name = "";
	this.health = 0;
	
}

public Player(String name, int health) {
	this.name = name;
	this.health = health;
}

//Name methods
public void setName(String name) {
	this.name = name;
	
}

public String getName() {
	return this.name;
}

//Health methods
public void setHealth(int health) {
	this.health = health;
}

public int getHealth() {
	return this.health;
}

public boolean damage(int damageValue){ //method for damage
	boolean gameOver=false;
	this.health = this.health - damageValue;

	if (this.health <= 0) {
		gameOver=true;
		}
	
	return gameOver;
} //end of damage method

public void heal(){ //method for healing
	this.health++;
} //end of heal method

public String toString(){
	String displayHealth = "The current health of the character is: " + this.health;
	return displayHealth;
}



	
}//end of Player class
