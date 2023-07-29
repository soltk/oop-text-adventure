/*
 * Written by:
 * 
 * Iris of Lys
 * Jack Davitt
 * Shazia Mansuri
 * Simran Nanwani
 * Huda Yousef
 * 
 */

package application;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class PlayGame {

	public static void main(String[] args) {

		/*
		 * The PlayGame class has the main method that is
		 * used to start the game. A prompt will appear when the game is over
		 * asking if the user would like to play again. This class interacts with
		 * the other classes in the project, and this class will start the game.
		 */
		
		System.out.println("Welcome to...");
		System.out.println("          .--.  .-. .-.   .---. ,-. .---.  .-. .-. \r\n"
				+ "|\\    /| / /\\ \\ |  \\| |  ( .-._)|(|/ .-. ) |  \\| | \r\n"
				+ "|(\\  / |/ /__\\ \\|   | | (_) \\   (_)| | |(_)|   | | \r\n"
				+ "(_)\\/  ||  __  || |\\  | _  \\ \\  | || | | | | |\\  | \r\n"
				+ "| \\  / || |  |)|| | |)|( `-'  ) | |\\ `-' / | | |)| \r\n"
				+ "| |\\/| ||_|  (_)/(  (_) `----'  `-' )---'  /(  (_) \r\n"
				+ "'-'  '-'       (__)                (_)    (__)     ");
		System.out.println(" ,---.     .---.   ,--,    .--.  ,---.  ,---.   \r\n"
				+ " | .-'    ( .-._).' .')   / /\\ \\ | .-.\\ | .-'   \r\n"
				+ " | `-.   (_) \\   |  |(_) / /__\\ \\| |-' )| `-.   \r\n"
				+ " | .-'   _  \\ \\  \\  \\    |  __  || |--' | .-'   \r\n"
				+ " |  `--.( `-'  )  \\  `-. | |  |)|| |    |  `--. \r\n"
				+ " /( __.' `----'    \\____\\|_|  (_)/(     /( __.' \r\n"
				+ "(__)                            (__)   (__)     ");

		Scanner sc = new Scanner(System.in); //new instance of Scanner is created
		String input = "";
		do {
			System.out.print("\nType Y for a New Game or N to Exit: ");
			input = sc.next();
		} while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")); //end of do while loop to check if valid input is entered

		if (input.equalsIgnoreCase("n")) {
			System.out.println("Exiting...");
			System.exit(0);
		} //end of if statement to check if the input was to exit the game.
		System.out.println("New Game Selected!");
		StartAdventure game = new StartAdventure(); //new instance of StartAdventure called game

		Player player = new Player(); //creation of new Player instance called player
		System.out.print("Player name: ");
		String name = sc.next();
		player.setName(name); //name of player is set
		

		// 1 player game
		do {
			System.out.println("\nNEW GAME STARTED");
			String command = "";
			int roomNum = 1;
			game.setRoomNumber(roomNum); //first room is set when new game starts
			boolean flashlight = false;
			boolean bottle = false;
			boolean pipe = false;
			boolean keyCar = false;
			boolean keyHall = false;
			boolean[] inventory = { flashlight, bottle, pipe, keyCar, keyHall }; //array of booleans is created for item inventory
			player.setInventory(inventory); //inventory is set in player
			Enemy enemy1 = new Enemy(); //creation of first Enemy instance
			Enemy enemy2 = new Enemy(); //creation of second Enemy instance

			do {
				if (game.getRoomNumber() == 1) {
					System.out.println(game.getRoomDescription(player.getInventory(), null)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.lobbyRoom(command, player.getInventory(), player); //lobbyRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 1); //end of do while that determines if command prompt is looped while the player is still in room 1
				}//end of if statement that determines if player is in room 1

				if (game.getRoomNumber() == 2) {
					System.out.println(game.getRoomDescription(player.getInventory(), null)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.barRoom(command, player.getInventory(), player); //barRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 2);//end of do while that determines if command prompt is looped while the player is still in room 2
				}//end of if statement that determines if player is in room 2

				if (game.getRoomNumber() == 3) {
					System.out.println(game.getRoomDescription(player.getInventory(), enemy1)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.kitchenRoom(command, player.getInventory(), player, enemy1); //kitchenRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 3);//end of do while that determines if command prompt is looped while the player is still in room 3
				}//end of if statement that determines if player is in room 3

				if (game.getRoomNumber() == 4) {
					System.out.println(game.getRoomDescription(player.getInventory(), null)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.bedRoom(command, player.getInventory(), player); //bedRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 4);//end of do while that determines if command prompt is looped while the player is still in room 4
				}//end of if statement that determines if player is in room 4

				if (game.getRoomNumber() == 5) {
					System.out.println(game.getRoomDescription(player.getInventory(), null)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.bathRoom(command, player.getInventory(), player); //bathRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 5);//end of do while that determines if command prompt is looped while the player is still in room 5
				}//end of if statement that determines if player is in room 5

				if (game.getRoomNumber() == 6) {
					System.out.println(game.getRoomDescription(player.getInventory(), enemy2)); //getRoomDescription is called with current inventory and current enemy
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						command = sc.nextLine();
						inventory = game.outsideRoom(command, player.getInventory(), player, enemy2); //outsideRoom is called to deal with command, output is put in inventory
						player.setInventory(inventory); //new inventory is set in player
					} while (game.getRoomNumber() == 6);//end of do while that determines if command prompt is looped while the player is still in room 6
				}//end of if statement that determines if player is in room 6

			} while (game.getRoomNumber() != 0); //end of do while loop that determines if player is still in rooms/game

				do {
					System.out.print("Game Over. Type Y to Play Again or N to Exit: ");
					input = sc.next();
				} while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));//end of do while that determines if input is valid

				if (input.equalsIgnoreCase("n")) {
					System.out.println("Exiting...");
					System.out.println("Game Exited!");
					System.exit(0); //program exit
				}//end of if statement that exits the game if the input was n
			
		} while (input.equalsIgnoreCase("y")); //end of do while loop that handles new game looping
		
		System.out.println("Exiting...");
		System.out.println("Game Exited!");
		System.exit(0); //program exit

	}// end of main method
	
}// end of PlayGame class
