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

public Player() {
	this.name = "";
	
}

public Player(String name) {
	this.name = name;
}

public void setName(String name) {
	this.name = name;
	
}

public String getName() {
	return this.name;
	
}

	
}//end of Player class
