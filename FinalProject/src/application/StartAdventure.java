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

public class StartAdventure {
/*
A StartAdventure class which will have the following
i. Contains the code used to create a new game object
ii. Creates the game �environment� whether it is rooms, campuses,
etc. and fills those environments. If for example, you have the
user answer questions, the questions should be generated by
this class
iii. Displays relevant information to the user, such as �you are here�
indicator
iv. Handles commands from the user (including those that cause
exceptions)
 * */
	
	private final int LOBBY = 1;
	private final int BAR = 2;
	private final int KITCHEN = 3;
	private final int HALLWAY = 4;
	private final int BEDROOM = 5;
	private final int BATHROOM = 6;
	private final int OUTSIDE = 7;
	
	private boolean flashlight;
	private boolean bottle;
	private boolean pipe;
	private boolean keyCar;
	private boolean keyHall;
		
	private int roomNum;
	
	public StartAdventure() {
		roomNum = 0;		
	}
	
	public StartAdventure(int roomNum) {
		this.roomNum = roomNum;	
	}
	
	public void setRoomNumber(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public int getRoomNumber() {
		return this.roomNum;
	}
	
	public String getRoomDescription(boolean flashlight){
		String description = "";
		
		if(roomNum == LOBBY) {
			
			if(flashlight == true) {
			description = "You wake up in the mansion lobby..."
					+ "\nYou can see a glittering key to the north and a hallway to the west. What do you want to do?";
			} else if(flashlight == false){description = "You wake up in the mansion lobby..."
					+ "\nIt's pitch dark, but you can see a light coming from the east. What do you want to do?";
			}
			
		} else if(roomNum == BAR) {
			description = "You are in the bar...";
			
		} else if(roomNum == KITCHEN) {
			description = "You are in the kitchen...";
			
		} else if(roomNum == HALLWAY) {
			description = "You are in the hallway...";
			
		} else if(roomNum == BEDROOM) {
			description = "You are in the master bedroom...";
			
		} else if(roomNum == BATHROOM) {
			description = "You are in the bathroom...";
			
		} else if(roomNum == OUTSIDE) {
			description = "You are outside...";
			
		}
		
		
		return description;
	}
	
	public boolean[] action(String command, boolean[] inventory) {
		//for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;
		
		if(roomNum == LOBBY) {
			
			if(command.equals("go north")) {
			
				if(flashlight == true) {
				
					System.out.println("You picked up a key!"); //perhaps these items can be instanced variables?
					newInv[0] = true;
				} else if(flashlight == false) {
					
					System.out.println("You can't see anything.");
				}
			}
			
			if(command.equals("go east")) {
				
				this.roomNum = 2;
				System.out.println("You walk east towards the light.");
				
			}
			
			if(command.equals("go south")) {
				
				System.out.println("The entrance door is locked. You can't leave, but how did you get here?");
			}
			
			if(command.equals("go west")) {
				
				if(flashlight == true) {
					
					if(keyHall == true) {
							
						System.out.println("You successfully unlocked the hallway door! You proceed.");
						this.roomNum = 4;
						
						
					} else {
				
					System.out.println("The door to the hallway is locked. You need a key.");
					
					}
					
				} else if(flashlight == false){
					
					System.out.println("You can't see that far.");
					
				}
				
			if(command.equals("drink")) {
				
				if(bottle == false) {
					
					System.out.println("Calm down, you party animal. You don't have anything to drink.");
					
				} else {
					
					System.out.println("That was a bad idea.");
					//Make player lose health somehow!!!
					
				}
				
			}
				
			}
			
		} else if(roomNum == BAR) {
			
			//if() {
				//etc...
			//}
			
			
		} else if(roomNum == KITCHEN) {
			
			
		} else if(roomNum == HALLWAY) {
			
			
		} else if(roomNum == BEDROOM) {
			
			
		} else if(roomNum == BATHROOM) {
			
			
		} else if(roomNum == OUTSIDE) {
			
			
		}
		
		
		
		return newInv;
		
	} //end of action() method
	
	public String getCommandList() {
		return "List of Commands:"
				+ "\ngo north"
				+ "\ngo east"
				+ "\ngo west"
				+ "\ngo south"
				+ "\ndrink"
				+ "\nheal"
				+ "\nattack";
	}
	
	
	
	
	
}//end of StartAdventure class
