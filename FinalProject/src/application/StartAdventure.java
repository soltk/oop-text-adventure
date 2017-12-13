/*
 * Written by:
 * 
 * Liz Berberena
 * Jack Davitt
 * Shazia Mansuri
 * Simran Nanwani
 * Huda Yousef
 * 
 *This single-player game is called Mansion Escape and is structured as a text adventure that incorporates various topics we have learned in OOP. The objective of the game is to escape a haunted mansion by moving from room to room in search of the next open door and any useful items that may help the player escape or fight off the monsters that may lurk within. The player begins in the lobby, moves through the bar, the kitchen, the hallway, the master bedroom, and the bathroom until they reach  outside. Through each room, the user is presented with a puzzle or task, and the various rooms may be locked or closed, so the user must take the textual clues to discover where they can go next. At the conclusion of the game, the user must defeat the final enemy to make it to their car, which can only be accessed if the player had picked up their car keys in one of the previous rooms. There are different endings depending on player actions, so it is essentially a “Choose your own adventure” game. The game serves as a mix between storytelling and problem solving although it lacks an actual UI or graphics, so it will hopefully entertain players who are highly imaginative and love reading and logic puzzles!
 */

package application;

public class StartAdventure {
	/*
	 * A StartAdventure class which will have the following i. Contains the code
	 * used to create a new game object ii. Creates the game “environment” whether
	 * it is rooms, campuses, etc. and fills those environments. If for example, you
	 * have the user answer questions, the questions should be generated by this
	 * class iii. Displays relevant information to the user, such as “you are here”
	 * indicator iv. Handles commands from the user (including those that cause
	 * exceptions)
	 **/

	private final int LOBBY = 1;
	private final int BAR = 2;
	private final int KITCHEN = 3;
	private final int BEDROOM = 4;
	private final int BATHROOM = 5;
	private final int OUTSIDE = 6;

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

	public String getRoomDescription(boolean[] inventory, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall

		String description = "";

		if (this.roomNum == LOBBY) { //first room = lobby

			if (inventory[0] == true) {

				if (inventory[3] == true) {

					description = "You are back in the mansion lobby..." + "\nYou already picked up the car keys here.";
				} else {
					description = "You are back in the mansion lobby..."
							+ "\nYou can see a glittering key lying on the corner table to the north of you, "
							+ "\nand locate a dark hallway to the west. You are not sure where it leads. "
							+ "\nWhat would you like to do?";
				}
			} else {
				description = "You are inside the lobby of a haunted mansion. You’re not sure how you got here, "
						+ "\nbut the door behind you is dead bolted shut. There is no turning back now..."
						+ "\nIt's pitch dark, but you can see a faint light coming from the east of where you're standing. "
						+ "\nWhat do you want to do?";
			}

		} else if (this.roomNum == BAR) {//second room = bar

			if (inventory[0] == true) {
				description = "You are back at the bar. You already picked up the flashlight and bottle that were on the counter.";

			} else {
				description = "You are in the bar."
						+ "\nAs you scan the room, you can see a flashlight on the counter next to a bottle of liquor. "
						+ "\nYou’re feeling thirsty, and the flashlight can also come in handy"
						+ "\nto navigate the dark." + "\nWhat would you like to do?";
			}

		} else if (this.roomNum == KITCHEN) { //third room = kitchen 

			if (inventory[4] == true) {
				description = "You are back in the kitchen..."
						+ "\nThe stench of putrid raw meat fills your nostrils and you struggle to hold back"
						+ "\nvomit while in here."
						+ "\nThe corpse of the monster you thought you killed has mysteriously disappeared,"
						+ "\nand you already collected the key you wanted.";
			} else if (enemy.getDeath() == true) {

				description = "You are back in the kitchen..."
						+ "\nThe stench of putrid raw meat fills your nostrils and you struggle to hold back"
						+ "\nvomit while in here."
						+ "\nThe corpse of the monster you thought you killed has mysteriously disappeared,"
						+ "\nand you can see a glittering key behind where the corpse lay.";

			} else {
				description = "You are in the kitchen..."
						+ "\nThe stench of putrid raw meat fills your nostrils and you struggle to hold back"
						+ "\nvomit while in here."
						+ "\nA hideous-looking creature from across the room is eyeing you dangerously,"
						+ "\nchunk of meat in its paws." + "\nBehind it, you can see a glittering key.";
			}

		} else if (this.roomNum == BEDROOM) { //fourth room = bedroom
			description = "You are in the master bedroom... " + "\nThere is a question on the door to the bathroom."
					+ "\nThe question must be answered correctly for you to get into the bathroom."
					+ "\nThe question on the door reads 'What color is a ghost? Be alert. (this totally isn't foreshadowing btw)'"
					+ "\nW-what? What an unsettling statement. At least, it's an easy question.";

		} else if (this.roomNum == BATHROOM) { //fifth room = bathroom

			if (inventory[2] == true) {
				description = "You are in the bathroom..." + "\nThe window to the outside is in front of you,"
						+ "\nand it looks like it could be opened easily." + "\nYou already picked up the pipe here."
						+ "\nWhat do you want to do?";
			} else {
				description = "You are in the bathroom." + "\nThe window to the outside is in front of you."
						+ "\nand it looks like it could be opened easily."
						+ "\nThere is a leaky faucet pipe under the sink to your right." + "\nWhat do you want to do?";
			}

		} else if (this.roomNum == OUTSIDE && enemy.getDeath() == false) { ////sixth room = outside
			description = "You jumped out the bathroom window, fear numbing the pain of the fall."
					+ "\nYou are outside the mansion at last, but there's a shadowy figure blocking you from moving forward"
					+ "\nto the car you can see in the distance." + "\nWhat would you like to do?";
		}

		return description;
	}

	public boolean[] lobbyRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north"))
			System.out.println("There's nothing in that direction.");

		else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east towards the light.");
			this.roomNum = 2;

		} else if (command.equalsIgnoreCase("go south"))
			System.out.println("The entrance door is locked. You can't leave, but how did you get here?");

		else if (command.equalsIgnoreCase("go west")) {
			if (newInv[0] == true) {
				if (newInv[4] == true) {
					System.out.println("You successfully unlocked the door to the hallway! You proceed west."
							+ "\nThe long dark passageway scares you into grabbing the nearest unlocked door to your right"
							+ "\nwhich leads to the master bedroom.");
					this.roomNum = 4;

				} else
					System.out.println("The door to the hallway is locked. You need a key.");

			} else if (newInv[0] == false)
				System.out.println("It's too dark to see that far.");
		}

		else if (command.equalsIgnoreCase("take") && newInv[0] == false)
			System.out.println("You feel around for the key but cannot find it in the dark.");

		else if (command.equalsIgnoreCase("take") && newInv[0] == true && newInv[3])
			System.out.println("There is nothing to take.");

		else if (command.equalsIgnoreCase("take") && newInv[0] == true && newInv[3] == false) {
			System.out.println("You take the key.");
			newInv[3] = true;

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == false)
				System.out.println("Calm down, you party animal. You don't have anything to drink.");

			else {
				System.out.println("You drink all of the liquor in the bottle and now feel inebriated. "
						+ "\nYou lose 1 health point!"); // health is updated
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

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
			}

		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else
			System.out.println("Please enter only commands from the command list.");

		return newInv;

	} // end of action() method

	public boolean[] barRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north"))
			System.out.println("There's nothing in that direction.");

		else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east into the kitchen.");
			this.roomNum = 3;

		} else if (command.equalsIgnoreCase("go south"))
			System.out.println("There's nothing in that direction.");

		else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the lobby.");
			this.roomNum = 1;

		} else if (command.equalsIgnoreCase("take") && newInv[0] == true && newInv[1] == true)
			System.out.println("There is nothing to take.");

		else if (command.equalsIgnoreCase("take") && newInv[0] == true && newInv[1] == false)
			System.out.println("There is nothing to take.");

		else if (command.equalsIgnoreCase("take") && newInv[0] == false && newInv[1] == false) {
			System.out.println("You pick up the flashlight and the bottle of liquor.");
			newInv[0] = true;
			newInv[1] = true;

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED

			} else {
				System.out.println("Calm down, party animal. You don't have anything to drink.");

			}
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.print("Your health is already full.");
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and apply alcohol on it. "
						+ "\nYou then wrap the cloth around your wound. " + "\nYou heal yourself by 1 point!");
				player.heal();
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

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
			}
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else
			System.out.println("Please enter only commands from the command list.");

		return newInv;
	}

	public boolean[] kitchenRoom(String command, boolean[] inventory, Player player, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north"))
			System.out.println("There is nowhere for you to go.");

		else if (command.equalsIgnoreCase("go east"))

			if (enemy.getLives() != 0 && newInv[1] == false) {
				System.out.println("You foolishly approach the beast without a weapon!" + "\nIt tries to maul you to death.");
				int pDamage = player.damage(enemy.attack());
				if (player.getDeath() == true) {
					System.out.println("You were killed! " + "\nBAD END");
					this.roomNum = 0;
				} else {
					System.out.println("There was a slim chance you would survive, but you did!" + "You received +"
							+ pDamage + " damage!");
					enemy.setDeath(true);
					System.out.println("The enemy was slain!");
				}
			} else if (enemy.getLives() != 0 && newInv[1] == true) {
				System.out.println("The ferocious monster is blocking your path.");
			} else {
				System.out.println("There is nowhere for you to go.");
			}

		else if (command.equalsIgnoreCase("go south"))
			System.out.println("There is nowhere for you to go.");

		else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the bar.");
			this.roomNum = 2;

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else
				System.out.println("Calm down, party animal. You don't have anything to drink.");

			// KITCHEN ROOM'S KEY PICKUP FUNCTIONALITY WILL
			// NOT WORK IF ENEMY FUNCTIONALITY IS NOT IMPLEMENTED
		} else if (command.equalsIgnoreCase("take") && newInv[4] == false && enemy.getDeath() == true) {
			System.out.println("You step around your defeated enemy and pick up the key.");
			newInv[4] = true;

		} else if (command.equalsIgnoreCase("take") && newInv[4] == false && enemy.getDeath() == false)
			System.out.println("You see a key on the floor behind your enemy. " + "\nThe enemy will not let you pass!");

		else if (command.equalsIgnoreCase("take") && newInv[4] == true)
			System.out.println("There is nothing to take.");

		else if (command.equalsIgnoreCase("attack")) {

			if (newInv[1] == true) {
				System.out.println(
						"You attack the enemy with the bottle, and it shatters!" + "\nThe beast has been slain!");
				enemy.setDeath(true);
				newInv[1] = false;
			} else {
				System.out.println("Attack with what?");
			}

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.print("Your health is already full.");
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and apply alcohol on it. "
						+ "\nYou then wrap the cloth around your wound. " + "\nYou heal yourself by 1 point!");
				player.heal();
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

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
			}
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else
			System.out.println("Please enter only commands from the command list.");

		return newInv;
	}

	public boolean[] bedRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north")) {
			System.out.println("You must answer the question first to enter the bathroom." + "\nWhat color is a ghost?");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk back into the hallway and to the lobby because it gives you the creeps.");
			this.roomNum = 1;

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED

			} else {
				System.out.println("Calm down, party animal. You don't have anything to drink.");

			}
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.print("Your health is already full.");
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and apply alcohol on it. "
						+ "\nYou then wrap the cloth around your wound. " + "\nYou heal yourself by 1 point!");
				player.heal();
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

		} else if (command.equalsIgnoreCase("white")) {

			System.out.println("You hear a click, and the door opens." + "\nYou pass through to the bathroom.");
			this.roomNum = 5;

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
			}
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else
			System.out.println("Incorrect answer and invalid command.");

		return newInv;
	}

	public boolean[] bathRoom(String command, boolean[] inventory, Player player) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false) {
				System.out.println("You raise the window and climb outside.");
				this.roomNum = 6;
			} else {
				System.out.println("You smash the window open, thinking it would be cool like in the movies, "
						+ "but you get a few cuts on your hand. It's not a big deal, though"
						+ "\nand climb out of the mansion.");
				this.roomNum = 6;
			}

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("You walk back into the master bedroom.");
			this.roomNum = 4;

		} else if (command.equalsIgnoreCase("go west"))
			System.out.println("There is nowhere for you to go.");

		else if (command.equalsIgnoreCase("take") && newInv[2] == true)
			System.out.println("There is nothing to take");

		else if (command.equalsIgnoreCase("take") && newInv[2] == false) {
			System.out.println("You pick up the pipe.");
			newInv[2] = true;

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED

			} else
				System.out.println("Calm down, party animal. You don't have anything to drink.");

		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.print("Your health is already full.");
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and apply alcohol on it. "
						+ "\nYou then wrap the cloth around your wound. " + "\nYou heal yourself by 1 point!");
				player.heal();
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

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
			}
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else
			System.out.println("Please enter only commands from the command list.");

		return newInv;
	}

	public boolean[] outsideRoom(String command, boolean[] inventory, Player player, Enemy enemy) {
		// for inventory positions, 0 = flashlight, 1 = bottle, 2 = pipe, 3 = keyCar, 4
		// = keyHall
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false && enemy.getDeath() == false) {
				System.out.println("Without any weapon, you foolishly charge at the shadow.");
				int pDamage = player.damage(enemy.attack());
				if (player.getDeath() == true) {
					System.out.println("You were killed!" + "\nBAD END");
					this.roomNum = 0;
				} else {
					System.out.println("There was a slim chance you would survive, but you did!" + "\nYou received +"
							+ pDamage + " damage!");
					int eDamage = enemy.damage(player.attack());
					if (enemy.getDeath() == true) {
						System.out.println("The enemy was slain!");
					} else {
						System.out.println("This enemy is tougher. It received only +" + eDamage + " damage!");
						System.out.println(enemy);
					}
				}
			} else if (newInv[2] == true && enemy.getDeath() == false) {
				System.out.println("The shadow is blocking your path to your car.");

			} else if (enemy.getDeath() == true) {
				System.out.println(
						"The shadow disappears into thin air and you are left standing in front of" + "\na white car.");

				if (newInv[3] == true) {
					System.out.println(
							"Thankfully you got the keys while you were still inside the mansion and were able to"
									+ "\nturn on the ignition and drive away somewhere far from that mansion."
									+ "\nGOOD END");
					this.roomNum = 0;
				} else {
					System.out.println("Although you are finally outside the mansion, you are in the middle of nowhere,"
							+ "\nand you have no keys to drive the car!" + "\nBAD END");
					this.roomNum = 0;
				}
			}

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("Jagged glass prevents you from climbing back into the window.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the liquor in the bottle and find yourself inebriated. "
						+ "\nYou lost 1 health!");
				player.damage(1);
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED

			} else {
				System.out.println("Calm down, party animal. You don't have anything to drink.");
			}

		} else if (command.equalsIgnoreCase("attack")) {

			if (newInv[2] == true) {
				System.out.println("You run at the shadowy figure and strike it with the metal pipe!");
				int eDamage = enemy.damage(player.attack());
				if (enemy.getDeath() == true) {
					System.out.println("You successfully defeated the shadow!");
				} else {
					System.out.println("This enemy is tougher. It received only +" + eDamage + " damage!");
					System.out.println(enemy);
					System.out.println("It strikes you back!");
					int pDamage = player.damage(enemy.attack());
					if (player.getDeath() == true) {
						System.out.println("You were killed!" + "\nBAD END");
						this.roomNum = 0;
					} else {
						System.out.println("You were knocked back and received +" + pDamage + " damage!");
					}
				}

			} else {
				System.out.println("Attack with what?");
			}

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.print("Your health is already full.");
			} else if (newInv[1] == true) {
				System.out.println("You rip off a piece of cloth from your shirt and apply alcohol on it. "
						+ "\nYou then wrap the cloth around your wound. " + "\nYou heal yourself by 1 point!");
				player.heal();
				newInv[1] = false; //THE BOTTLE IS REMOVED FROM THE PLAYER'S INVENTORY AND CAN NO LONGER BE USED
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\ngo north" + "\ngo east" + "\ngo west" + "\ngo south" + "\ntake"
					+ "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health" + "\nhelp");

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
			}
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else if(command.equalsIgnoreCase("skip")) {
			//secret command to skip boss fight
			System.out.println("The shadow disappeared before you had to fight it.");
			enemy.setDeath(true);
			
		} else {
			System.out.println("Please enter only commands from the command list.");
		}

		return newInv;
	}

}// end of StartAdventure class
