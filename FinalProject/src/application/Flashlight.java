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

public class Flashlight {
	
	private boolean status;
	
	public Flashlight() {
		this.status = false;
		
	}//end of no-arg constructor
	
	public Flashlight(boolean status) {
		this.status = false;
	}
	
	public void setStatus(boolean status) {
		this.status = false;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public String getStatusName() {
		String s = "";
		
		if(this.status == true) {
			s = "Your flashlight is on.";
		} else if(this.status == false) {
			s = "Your flashlight is off.";	
		}
		
		return s;
	}
	
}//end of Flashlight class
