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

public class Bottle extends Item {
	
	private boolean isEmpty, isBroken, canHeal = false;
	
	public Bottle() {
		
	}//end of no-arg constructor
	
	public Bottle(boolean isEmpty, boolean isBroken, boolean canHeal) {
		this.isEmpty = isEmpty;
		this.isBroken = isBroken;
		this.canHeal = canHeal;
	}//end of two-parameter constructor

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}//end of setEmpty method
	
	public void setBroken(boolean broken) {
		isBroken = broken;
	}//end of setBroken method
	
	public void setCanHeal(boolean heal) {
		canHeal = heal;
	}//end of setCanHeal method
	
	public boolean getEmpty() {
		return isEmpty;
	}//end of getEmpty method
	
	public boolean getBroken() {
		return isBroken;
	}//end of getBroken method
	
	public boolean getCanHeal() {
		return canHeal;
	}//end of getCanHeal method
	
}//end of Bottle class
