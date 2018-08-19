/*
 * Written by:
 * 
 * @ByLiz on Github
 * Jack Davitt
 * Shazia Mansuri
 * Simran Nanwani
 * Huda Yousef
 * 
 *This single-player game is called Mansion Escape and is structured as a text adventure 
 *that incorporates various topics we have learned in OOP. The objective of the game is 
 *to escape a haunted mansion by moving from room to room in search of the next open door 
 *and any useful items that may help the player escape or fight off the monsters that may 
 *lurk within. The player begins in the lobby, moves through the bar, the kitchen, the 
 *hallway, the master bedroom, and the bathroom until they reach  outside. Through each 
 *room, the user is presented with a puzzle or task, and the various rooms may be locked 
 *or closed, so the user must take the textual clues to discover where they can go next. 
 *At the conclusion of the game, the user must defeat the final enemy to make it to their 
 *car, which can only be accessed if the player had picked up their car keys in one of the 
 *previous rooms. There are different endings depending on player actions, so it is 
 *essentially a Choose your own adventure game. The game serves as a mix between 
 *story-telling and problem solving although it lacks an actual UI or graphics, so it will 
 *hopefully entertain players who are highly imaginative and love reading and logic puzzles!
 */

package application;

public class StartAdventure {
	/*
	 * The StartAdventure class contains the code used to create a new game object,
	 * creates the game rooms and environments, displays relevant information to the 
	 * user such as list of available commands and the descriptions of things as they
	 * unfold in the game, and handles commands from the user (including those that cause
	 * exceptions).
	 **/

	/*constant variables*/
	private final int LOBBY = 1;
	private final int BAR = 2;
	private final int KITCHEN = 3;
	private final int BEDROOM = 4;
	private final int BATHROOM = 5;
	private final int OUTSIDE = 6;

	/*instanced variable*/
	private int roomNum;

	/*Constructors*/
	public StartAdventure() {
		roomNum = 0;
	} //end of StartAdventure()

	public StartAdventure(int roomNum) {
		this.roomNum = roomNum;
	} //end of StartAdventure(int roomNum)

	public void setRoomNumber(int roomNum) {
		this.roomNum = roomNum;
	} //end of setRoomNumber(int roomNum)

	public int getRoomNumber() {
		return this.roomNum;
	} //end of getRoomNumber()


	public String getRoomDescription(boolean[] inventory, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall

		String description = ""; //String to be returned is initialized

		if (this.roomNum == LOBBY) { // first room = lobby

			if (inventory[0] == true) {

				if (inventory[3] == true) {
					description = "You are back in the mansion lobby..." + "\nYou already picked up the car keys here.";
			
				} else {
					description = "You are back in the mansion lobby..."
							+ "\nYou can see a glittering key lying on the corner"
							+ "\ntable to the north of you, and locate a dark"
							+ "\nhallway to the west. You are not sure where it leads. "
							+ "\nWhat would you like to do?";
				}//end of if else statement (if the player got the car keys from the lobby)
			} else {
				description = "You are inside the lobby of a haunted mansion... "
						+ "\nYou're not sure how you got here, but the door"
						+ "\nbehind you is bolted shut. There is no turning back now."
						+ "\nIt's pitch dark, but you can see a faint light coming "
						+ "\nfrom the east of where you're standing. What do you want" + "\nto do?";
			}//end of if else statement (if the user is in the lobby with a flashlight or not)

		} else if (this.roomNum == BAR) {// second room = bar

			if (inventory[0] == true) {
				description = "You are back at the bar... "
						+ "\nYou already picked up the flashlight and bottle that were " + "\non the counter.";

			} else {
				description = "You are in the bar." + "\nAs you scan the room, you can see a flashlight on the "
						+ "\ncounter next to a bottle of liquor. You're feeling thirsty, "
						+ "\nand the flashlight can also come in handy to navigate the "
						+ "\ndark. What would you like to do?";
			}//end of if else statement (if the user got the flashlight and bottle or not in the bar)

		} else if (this.roomNum == KITCHEN) { // third room = kitchen

			if (inventory[4] == true) {
				description = "You are back in the kitchen..."
						+ "\nThe stench of putrid raw meat fills your nostrils and "
						+ "\nyou struggle to hold back vomit while in here. The"
						+ "\ncorpse of the monster you killed is laying there"
						+ "\nmotionless. You already collected" + "\nthe key you wanted.";
				
			} else if (enemy.getDeath() == true) {
				description = "You are back in the kitchen..."
						+ "\nThe stench of putrid raw meat fills your nostrils and"
						+ "\nyou struggle to hold back vomit while in here. The"
						+ "\ncorpse of the monster you killed is laying there"
						+ "\nmotionless. You can see a glittering key behind"
						+ "\nit.";

			} else {
				description = "You are in the kitchen..." + "\nThe stench of putrid raw meat fills your nostrils and"
						+ "\nyou struggle to hold back vomit while in here. A"
						+ "\nhideous-looking creature from across the room is"
						+ "\neyeing you dangerously, chunk of meat in its paws."
						+ "\nBehind it, you can see a glittering key.";
			} //end of if else statements (if the key was taken in the kitchen, if the monster is dead, or neither)

		} else if (this.roomNum == BEDROOM) { // fourth room = bedroom
			description = "You are in the master bedroom... " + "\nThere is a question on the door to the bathroom."
					+ "\nThe question must be answered correctly for you to "
					+ "\nget into the bathroom. The question on the door reads"
					+ "\n'What color is a ghost? Be alert. (this totally isn't "
					+ "\nforeshadowing btw)' W-what? What an unsettling statement."
					+ "\nAt least, it's an easy question.";

		} else if (this.roomNum == BATHROOM) { // fifth room = bathroom

			if (inventory[2] == true) {
				description = "You are in the bathroom..." + "\nThe window to the outside is in front of you,"
						+ "\nand it looks like it could be opened easily."
						+ "\nYou already picked up the pipe here. What do" + "\nyou want to do?";
			} else {
				description = "You are in the bathroom..." + "\nThe window to the outside is in front of you."
						+ "\nand it looks like it could be opened easily."
						+ "\nThere is a leaky faucet pipe under the sink to " + "\nyour left. What do you want to do?";
			}//end of if else statement (if the pipe was taken from the bathroom)

		} else if (this.roomNum == OUTSIDE && enemy.getDeath() == false) { // sixth room = outside
			description = "You jumped out the bathroom window, fear numbing the pain"
					+ "\nof the fall. You are outside the mansion at last,"
					+ "\nbut there's a shadowy figure blocking you from moving"
					+ "\nforward to the car you can see in the distance." + "\nWhat would you like to do?";
		}//end of long if else if chain to determine the appropriate descriptions of the current room according to the room number and interactions

		return description;
	} //end of getRoomDescription(boolean[] inventory, Enemy enemy)

	
	public boolean[] lobbyRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory; //new inventory is made

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east towards the light.");
			this.roomNum = 2; //current room changed to bar

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("The entrance door is locked. You can't leave, but how" + "\ndid you get here?");

		} else if (command.equalsIgnoreCase("go west")) {
			if (newInv[0] == true) {
				if (newInv[4] == true) {
					System.out.println("You successfully unlocked the door to the hallway! You proceed west."
							+ "\nThe long dark passageway scares you into grabbing the nearest"
							+ "\nunlocked door to your right which leads to the master" + "\nbedroom.");
					this.roomNum = 4; //current room changed to bedroom

				} else {
					System.out.println("The door to the hallway is locked. You need a key.");
				}//end of if else statement (if the player has the hallway keys or not in the lobby when going west)

			} else if (newInv[0] == false) {
				System.out.println("It's too dark to see that far.");
			}//end of if else if statement (if player has flashlight in lobby or not when going west)

		} else if (command.equalsIgnoreCase("take") ) {
			
			if(newInv[0] == false) {
				System.out.println("You feel around for the key but cannot find it" + "\nin the dark.");
				
			} else if(newInv[0] == true && newInv[3] == true) {
				System.out.println("There is nothing to take.");
				
			} else {
				System.out.println("You take the keys.");
				newInv[3] = true; //car keys acquired
			} //end of if else statements (if the player does not have a flashlight, if the player does have a flashlight and the car keys, or if the player has a flashlight but no car keys)

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == false) {
				System.out.println("Calm down, you party animal. You don't have anything to" + "\ndrink.");

			} else {
				System.out.println("You drink all of the liquor in the bottle and"
						+ "\nnow feel inebriated. You lose 1 health point!");
				player.damage(1); //health increased
				newInv[1] = false; //bottle removed
			}//end of if else statement (if player has bottle or not when using drink command)

		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if the player's health is at maximum, if the player has a bottle, or if neither)

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements to print items in inventory if in possession

		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player); //calls toString method of player which displays current health

		} else {
			System.out.println("Please enter only commands from the command list.");
		}//end of long chain of if else statements to determine changes to the state of the game objects while in the lobby

		return newInv; //new inventory is returned

	} //end of lobbyRoom(String command, boolean[] inventory, Player player)

	
	public boolean[] barRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east into the kitchen.");
			this.roomNum = 3; //current room changed to kitchen

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the lobby.");
			this.roomNum = 1; //current room changed to lobby

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[0] == true && newInv[1] == true) {
				System.out.println("There is nothing to take.");
				
			} else if(newInv[0] == true && newInv[1] == false) {
				System.out.println("There is nothing to take.");
				
			} else {
				System.out.println("You pick up the flashlight and the bottle of liquor.");
				newInv[0] = true; //flashlight acquired
				newInv[1] = true; //bottle acquired
			}//end of if else statements (if player has the flashlight and bottle, if the player has the flashlight but not bottle, or if neither when using take command)

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1); //health decreased
				newInv[1] = false; //bottle removed

			} else {
				System.out.println("Calm down, party animal. You don't have anything to" + "\ndrink.");

			}//end of if else statement (if the player has a bottle or not when using the drink command)
			
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if the player's health is at maximum, if the player has a bottle, or if neither)

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements that print out items in inventory if in possession
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else {
			System.out.println("Please enter only commands from the command list.");
		}//end of long chain of if else statements to determine changes to the state of the game objects while in the bar

		return newInv; //returns new inventory
	}//end of barRoom(String command, boolean[] inventory, Player player)

	
	public boolean[] kitchenRoom(String command, boolean[] inventory, Player player, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, enemy)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go east")) {

			if (enemy.getDeath() == false && newInv[1] == false) {
				System.out.println(
						"You foolishly approach the beast without a weapon! It tries to" + "\nmaul you to death.");
				int pDamage = player.damage(enemy.attack()); //enemy attacks player and deals between 0 and 3 damage

				if (player.getDeath() == true) {
					System.out.println("You were killed! " + "\nBAD ENDING D:");
					System.out.println("<-.(`-')  (`-')  _ _(`-')    \r\n" + 
							" __( OO)  (OO ).-/( (OO ).-> \r\n" + 
							"'-'---.\\  / ,---.  \\    .'_  \r\n" + 
							"| .-. (/  | \\ /`.\\ '`'-..__) \r\n" + 
							"| '-' `.) '-'|_.' ||  |  ' | \r\n" + 
							"| /`'.  |(|  .-.  ||  |  / : \r\n" + 
							"| '--'  / |  | |  ||  '-'  / \r\n" + 
							"`------'  `--' `--'`------'  ");
					System.out.println(" (`-')  _<-. (`-')_  _(`-')     _     <-. (`-')_            \r\n" + 
							" ( OO).-/   \\( OO) )( (OO ).-> (_)       \\( OO) )    .->    \r\n" + 
							"(,------.,--./ ,--/  \\    .'_  ,-(`-'),--./ ,--/  ,---(`-') \r\n" + 
							" |  .---'|   \\ |  |  '`'-..__) | ( OO)|   \\ |  | '  .-(OO ) \r\n" + 
							"(|  '--. |  . '|  |) |  |  ' | |  |  )|  . '|  |)|  | .-, \\ \r\n" + 
							" |  .--' |  |\\    |  |  |  / :(|  |_/ |  |\\    | |  | '.(_/ \r\n" + 
							" |  `---.|  | \\   |  |  '-'  / |  |'->|  | \\   | |  '-'  |  \r\n" + 
							" `------'`--'  `--'  `------'  `--'   `--'  `--'  `-----'   ");
					System.out.println(" _(`-')       \r\n" + 
							"( (OO ).->    \r\n" + 
							" \\    .'_ ,-. \r\n" + 
							" '`'-..__)'-' \r\n" + 
							" |  |  ' |,-. \r\n" + 
							" |  |  / :'-' \r\n" + 
							" |  '-'  /    \r\n" + 
							" `------'     ");
					this.roomNum = 0; //current room changed to 0 to represent end game, this breaks out of the if statements in PlayGame

				} else {
					System.out.println("There was a slim chance you would survive, but you did!" + "\nYou received "
							+ pDamage + " damage!");
					enemy.setDeath(true); //this enemy is killed with one hit
					System.out.println("The enemy was slain!");

				}//end of if else statement (if player dies or if player survives)
				
			} else if (enemy.getDeath() == false && newInv[1] == true) {
				System.out.println("The ferocious monster is blocking your path.");

			} else {
				System.out.println("There is nowhere for you to go.");
			}//end of if else statements (if the enemy isn't dead and the player has no weapon, if the enemy isn't dead and the player does have a weapon, or if neither)

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the bar.");
			this.roomNum = 2; //current room changed to bar

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and"
						+ "\nfind yourself inebriated. You lost 1 health!");
				player.damage(1);
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("Calm down, party animal. You don't have anything to"
						+ "\ndrink.");
			} //end of if else statement (if player has bottle or not when using drink command)

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[4] == false && enemy.getDeath() == true) {
				System.out.println("You step around your defeated enemy and pick up the" + "\nkey.");
				newInv[4] = true; //hallway keys acquired
				
			} else if(newInv[4] == false && enemy.getDeath() == false) {
				System.out.println("You see a key on the floor behind your enemy. The" + "\nenemy will not let you pass!");
				
			} else {
				System.out.println("There is nothing to take.");
			}//end of if else statements (if player has hallway keys and enemy is dead, if player does not have hallways keys and enemy is alive, or neither)

		} else if (command.equalsIgnoreCase("attack")) {

			if (newInv[1] == true) {
				System.out.println(
						"You attack the enemy with the bottle, and it shatters!" + "\nThe beast has been slain!");
				enemy.setDeath(true);//enemy is killed with one hit
				newInv[1] = false; //bottle removed
			} else {
				System.out.println("Attack with what?");
			}//end of if else statement (if player has bottle or not when using attack command)

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");

			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed

			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if player health is maximum, if player has bottle, or if neither when using heal command)

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements which print out the items in inventory if in possession
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else {
			System.out.println("Please enter only commands from the command list.");
		}//end of long chain of if else statements to determine changes to the state of the game objects while in the kitchen

		return newInv;
	} //end of kitchenRoom(String command, boolean[] inventory, Player player, Enemy enemy) 

	
	public boolean[] bedRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("You must answer the question first to enter the bathroom." + "\nWhat color is a ghost?");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk back into the hallway and to the lobby" + "\nbecause it gives you the creeps.");
			this.roomNum = 1; //current room changed to lobby

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and"
						+ "\nfind yourself inebriated. You lost 1 health!");
				player.damage(1); //health decreased
				newInv[1] = false; //bottle removed

			} else {
				System.out.println("Calm down, party animal. You don't have anything to" + "\ndrink.");
			}//end of if else statement (if player has bottle or not when using drink command)
			
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if player has maximum health, if player has bottle, or if neither when using heal command)

		} else if (command.equalsIgnoreCase("take")) {
			System.out.println("There is nothing to take.");

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("white")) { //correct response to question in bedroom

			System.out.println("You hear a click, and the door opens. You pass through to the bathroom.");
			this.roomNum = 5; //current room is changed to bathroom

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements that print out items in inventory if in possession
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player); //calls toString method in player that prints their current health

		} else {
			System.out.println("Incorrect answer and invalid command.");
		}//end of long chain of if else statements to determine changes to the state of the game objects while in bedroom

		return newInv;
	} //end of bedRoom(String command, boolean[] inventory, Player player)

	
	public boolean[] bathRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false) {
				System.out.println("You raise the window and climb outside.");
				this.roomNum = 6; //current room changed to outside
				
			} else {
				System.out.println("You smash the window open, thinking it would be cool"
						+ "\nlike in the movies, but you get a few cuts on your"
						+ "\nhand. It's not a big deal, though and you climb out" + "\nof the mansion.");
				this.roomNum = 6; //current room changed to outside
			}//end of if else statements (if player has pipe or not)

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("You walk back into the master bedroom.");
			this.roomNum = 4; //current room changed to bedroom

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[2] == true) {
				System.out.println("There is nothing to take");
				
			} else {
				System.out.println("You pick up the pipe.");
				newInv[2] = true; //pipe acquired
			}//end of if else statement (if player has pipe or not when using take command)

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and"
						+ "\nfind yourself inebriated. You lost 1 health!");
				player.damage(1); //health decreased
				newInv[1] = false; //bottle removed

			} else {
				System.out.println("Calm down, party animal. You don't have anything to" + "\ndrink.");
			}//end of if else statement (if player has bottle or not when using drink command)

		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");

			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if player has maximum health, if player has bottle, or if neither when using heal command)

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements that print out items in inventory if in possession
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);//calls toString method in Player that prints out current health

		} else {
			System.out.println("Please enter only commands from the command list.");
		} //end of long chain of if else statements to determine changes to the state of the game objects while in bathroom

		return newInv; //returns new inventory
	} //end of bathRoom(String command, boolean[] inventory, Player player)

	
	public boolean[] outsideRoom(String command, boolean[] inventory, Player player, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4 = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, enemy)); //getRoomDescription is called in the current room

		} else if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false && enemy.getDeath() == false) {
				System.out.println("Without any weapon, you foolishly charge at the shadow.");
				int pDamage = player.damage(enemy.attack()); //enemy attacks player dealing between 0 and 3 damage
				
				if (player.getDeath() == true) {
					System.out.println("You were killed!" + "\nBAD ENDING D:");
					System.out.println("<-.(`-')  (`-')  _ _(`-')    \r\n" + 
							" __( OO)  (OO ).-/( (OO ).-> \r\n" + 
							"'-'---.\\  / ,---.  \\    .'_  \r\n" + 
							"| .-. (/  | \\ /`.\\ '`'-..__) \r\n" + 
							"| '-' `.) '-'|_.' ||  |  ' | \r\n" + 
							"| /`'.  |(|  .-.  ||  |  / : \r\n" + 
							"| '--'  / |  | |  ||  '-'  / \r\n" + 
							"`------'  `--' `--'`------'  ");
					System.out.println(" (`-')  _<-. (`-')_  _(`-')     _     <-. (`-')_            \r\n" + 
							" ( OO).-/   \\( OO) )( (OO ).-> (_)       \\( OO) )    .->    \r\n" + 
							"(,------.,--./ ,--/  \\    .'_  ,-(`-'),--./ ,--/  ,---(`-') \r\n" + 
							" |  .---'|   \\ |  |  '`'-..__) | ( OO)|   \\ |  | '  .-(OO ) \r\n" + 
							"(|  '--. |  . '|  |) |  |  ' | |  |  )|  . '|  |)|  | .-, \\ \r\n" + 
							" |  .--' |  |\\    |  |  |  / :(|  |_/ |  |\\    | |  | '.(_/ \r\n" + 
							" |  `---.|  | \\   |  |  '-'  / |  |'->|  | \\   | |  '-'  |  \r\n" + 
							" `------'`--'  `--'  `------'  `--'   `--'  `--'  `-----'   ");
					System.out.println(" _(`-')       \r\n" + 
							"( (OO ).->    \r\n" + 
							" \\    .'_ ,-. \r\n" + 
							" '`'-..__)'-' \r\n" + 
							" |  |  ' |,-. \r\n" + 
							" |  |  / :'-' \r\n" + 
							" |  '-'  /    \r\n" + 
							" `------'     ");
					this.roomNum = 0; //changes current room to 0, prompting an end game

				} else {
					System.out.println("There was a slim chance you would survive, but you did!" + "\nYou received "
							+ pDamage + " damage!");
					int eDamage = enemy.damage(player.attack()); //player attacks enemy dealing between 0 and 3 damage
					
					if (enemy.getDeath() == true) {
						System.out.println("The enemy was slain!");
					} else {
						System.out.println("This enemy is tougher. It received only " + eDamage + " damage!");
						System.out.println(enemy); //calls toString method in Enemy and prints current health of the enemy
					}//end of if else statement (if enemy dies or not)
				} //end of if else statement (if player dies or not)
			} else if (newInv[2] == true && enemy.getDeath() == false) {
				System.out.println("The shadow is blocking your path to your car.");

			} else if (enemy.getDeath() == true) {
				System.out.println("The shadow disappears into thin air and you are left" + "\nstanding in front of a white car.");

				if (newInv[3] == true) {
					System.out.println("Thankfully you got the keys while you were still inside"
							+ "\nthe mansion and were able to turn on the ignition"
							+ "\nand drive away somewhere far from that mansion. " + "\nGOOD ENDING :D");
					System.out.println("  _______     ______      ______    ________   \r\n" + 
							" /\" _   \"|   /    \" \\    /    \" \\  |\"      \"\\  \r\n" + 
							"(: ( \\___)  // ____  \\  // ____  \\ (.  ___  :) \r\n" + 
							" \\/ \\      /  /    ) :)/  /    ) :)|: \\   ) || \r\n" + 
							" //  \\ ___(: (____/ //(: (____/ // (| (___\\ || \r\n" + 
							"(:   _(  _|\\        /  \\        /  |:       :) \r\n" + 
							" \\_______)  \\\"_____/    \\\"_____/   (________/  \r\n" + 
							"                                               ");
					System.out.println("  _______  _____  ___   ________   __    _____  ___    _______   \r\n" + 
							" /\"     \"|(\\\"   \\|\"  \\ |\"      \"\\ |\" \\  (\\\"   \\|\"  \\  /\" _   \"|  \r\n" + 
							"(: ______)|.\\\\   \\    |(.  ___  :)||  | |.\\\\   \\    |(: ( \\___)  \r\n" + 
							" \\/    |  |: \\.   \\\\  ||: \\   ) |||:  | |: \\.   \\\\  | \\/ \\       \r\n" + 
							" // ___)_ |.  \\    \\. |(| (___\\ |||.  | |.  \\    \\. | //  \\ ___  \r\n" + 
							"(:      \"||    \\    \\ ||:       :)/\\  |\\|    \\    \\ |(:   _(  _| \r\n" + 
							" \\_______) \\___|\\____\\)(________/(__\\_|_)\\___|\\____\\) \\_______)  \r\n" + 
							"                                                                 ");
					System.out.println("  ____  ________   \r\n" + 
							" ))_ \")|\"      \"\\  \r\n" + 
							"(____( (.  ___  :) \r\n" + 
							" _____ |: \\   ) || \r\n" + 
							" ))_ \")(| (___\\ || \r\n" + 
							"(____( |:       :) \r\n" + 
							"       (________/  \r\n" + 
							"                   ");
					this.roomNum = 0; //current room is changed to 0 and prompts end game

				} else {
					System.out.println("Although you are finally outside the mansion, you have no"
							+ "\nkeys to drive the car, and you're in the middle" + "\nof nowhere!"
							+ "\nBAD ENDING D:");
					System.out.println("<-.(`-')  (`-')  _ _(`-')    \r\n" + 
							" __( OO)  (OO ).-/( (OO ).-> \r\n" + 
							"'-'---.\\  / ,---.  \\    .'_  \r\n" + 
							"| .-. (/  | \\ /`.\\ '`'-..__) \r\n" + 
							"| '-' `.) '-'|_.' ||  |  ' | \r\n" + 
							"| /`'.  |(|  .-.  ||  |  / : \r\n" + 
							"| '--'  / |  | |  ||  '-'  / \r\n" + 
							"`------'  `--' `--'`------'  ");
					System.out.println(" (`-')  _<-. (`-')_  _(`-')     _     <-. (`-')_            \r\n" + 
							" ( OO).-/   \\( OO) )( (OO ).-> (_)       \\( OO) )    .->    \r\n" + 
							"(,------.,--./ ,--/  \\    .'_  ,-(`-'),--./ ,--/  ,---(`-') \r\n" + 
							" |  .---'|   \\ |  |  '`'-..__) | ( OO)|   \\ |  | '  .-(OO ) \r\n" + 
							"(|  '--. |  . '|  |) |  |  ' | |  |  )|  . '|  |)|  | .-, \\ \r\n" + 
							" |  .--' |  |\\    |  |  |  / :(|  |_/ |  |\\    | |  | '.(_/ \r\n" + 
							" |  `---.|  | \\   |  |  '-'  / |  |'->|  | \\   | |  '-'  |  \r\n" + 
							" `------'`--'  `--'  `------'  `--'   `--'  `--'  `-----'   ");
					System.out.println(" _(`-')       \r\n" + 
							"( (OO ).->    \r\n" + 
							" \\    .'_ ,-. \r\n" + 
							" '`'-..__)'-' \r\n" + 
							" |  |  ' |,-. \r\n" + 
							" |  |  / :'-' \r\n" + 
							" |  '-'  /    \r\n" + 
							" `------'     ");
					this.roomNum = 0; //current room is changed to 0 and prompts end game
				} //end of if else statements (if the player has the car keys or not)
			}//end of if else statements (if the player does not have the pipe and the enemy is alive, if the player does have the pipe and the enemy is alive, or if the enemy is dead)

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("Jagged glass prevents you from climbing back into the window.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and"
						+ "\nfind yourself inebriated. You lost 1 health!");
				player.damage(1); //health decreased
				newInv[1] = false; //bottle removed

			} else {
				System.out.println("Calm down, party animal. You don't have anything to" + "\ndrink.");
			}//end of if else statement (if player has bottle or not when using drink command)

		} else if (command.equalsIgnoreCase("attack")) {

			if (newInv[2] == true) {
				System.out.println("You run at the shadowy figure and strike it with" + "\nthe metal pipe!");
				int eDamage = enemy.damage(player.attack()); //player attacks enemy and deals between 0 and 3 damage
				
				if (enemy.getDeath() == true) {
					System.out.println("You successfully defeated the shadow!");
				} else {
					System.out.println("This enemy is tougher. It received only " + eDamage + " damage!");
					System.out.println(enemy); //calls toString method in Enemy and prints current health of enemy
					System.out.println("It strikes you back!");
					int pDamage = player.damage(enemy.attack()); //enemy attacks player and deals between 0 and 3 damage
					
					if (player.getDeath() == true) {
						System.out.println("You were killed!" + "\nBAD ENDING D:");
						System.out.println("<-.(`-')  (`-')  _ _(`-')    \r\n" + 
								" __( OO)  (OO ).-/( (OO ).-> \r\n" + 
								"'-'---.\\  / ,---.  \\    .'_  \r\n" + 
								"| .-. (/  | \\ /`.\\ '`'-..__) \r\n" + 
								"| '-' `.) '-'|_.' ||  |  ' | \r\n" + 
								"| /`'.  |(|  .-.  ||  |  / : \r\n" + 
								"| '--'  / |  | |  ||  '-'  / \r\n" + 
								"`------'  `--' `--'`------'  ");
						System.out.println(" (`-')  _<-. (`-')_  _(`-')     _     <-. (`-')_            \r\n" + 
								" ( OO).-/   \\( OO) )( (OO ).-> (_)       \\( OO) )    .->    \r\n" + 
								"(,------.,--./ ,--/  \\    .'_  ,-(`-'),--./ ,--/  ,---(`-') \r\n" + 
								" |  .---'|   \\ |  |  '`'-..__) | ( OO)|   \\ |  | '  .-(OO ) \r\n" + 
								"(|  '--. |  . '|  |) |  |  ' | |  |  )|  . '|  |)|  | .-, \\ \r\n" + 
								" |  .--' |  |\\    |  |  |  / :(|  |_/ |  |\\    | |  | '.(_/ \r\n" + 
								" |  `---.|  | \\   |  |  '-'  / |  |'->|  | \\   | |  '-'  |  \r\n" + 
								" `------'`--'  `--'  `------'  `--'   `--'  `--'  `-----'   ");
						System.out.println(" _(`-')       \r\n" + 
								"( (OO ).->    \r\n" + 
								" \\    .'_ ,-. \r\n" + 
								" '`'-..__)'-' \r\n" + 
								" |  |  ' |,-. \r\n" + 
								" |  |  / :'-' \r\n" + 
								" |  '-'  /    \r\n" + 
								" `------'     ");
						this.roomNum = 0; //current room is changed to 0 and prompts end game

					} else {
						System.out.println("You were knocked back and received " + pDamage + " damage!");
					}//end of if else statement (if the player died or not)
				}//end of if else statement (if the enemy is dead or not)

			} else {
				System.out.println("Attack with what?");
			}//end of if else statement (if player has the pipe or not when using the attack command)

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and"
						+ "\napply alcohol on it. You then wrap the cloth around"
						+ "\nyour wound. You heal yourself by 1 point!");
				player.heal(); //health increased
				newInv[1] = false; //bottle removed
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}//end of if else statements (if player's health is at maximum, if player has bottle, or if neither when using heal command)

		} else if (command.equalsIgnoreCase("take")) {
			System.out.println("There is nothing to take.");

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("Flashlight");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}//end of if statements that print items in inventory if in possession
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);//calls toString method in Player that prints the player's current health

		} else if (command.equalsIgnoreCase("skip")) { //secret command to skip boss fight
			System.out.println("The shadow disappeared before you had to fight it.");
			enemy.setDeath(true); //enemy dies

		} else {
			System.out.println("Please enter only commands from the command list.");
		}//end of long chain of if else statements to determine changes to the state of the game objects while outside

		return newInv; //returns new inventory
	} //end of outsideRoom(String command, boolean[] inventory, Player player, Enemy enemy)

}// end of StartAdventure class
