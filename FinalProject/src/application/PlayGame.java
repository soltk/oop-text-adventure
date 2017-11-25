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

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class PlayGame {

	public static void main(String[] args) {
		
/*
 * The PlayGame class which will have the following
i. Your main method that is used to start the game MUST be in this
class. Do not write all your game code within this main method.
ii. A prompt will appear when the game is over asking if the user
would like to play again
iii. This class interacts with the other classes in your project
iv. This class will start your game*/
		
		
		System.out.println("          .--.  .-. .-.   .---. ,-. .---.  .-. .-. \r\n" + 
				"|\\    /| / /\\ \\ |  \\| |  ( .-._)|(|/ .-. ) |  \\| | \r\n" + 
				"|(\\  / |/ /__\\ \\|   | | (_) \\   (_)| | |(_)|   | | \r\n" + 
				"(_)\\/  ||  __  || |\\  | _  \\ \\  | || | | | | |\\  | \r\n" + 
				"| \\  / || |  |)|| | |)|( `-'  ) | |\\ `-' / | | |)| \r\n" + 
				"| |\\/| ||_|  (_)/(  (_) `----'  `-' )---'  /(  (_) \r\n" + 
				"'-'  '-'       (__)                (_)    (__)     ");
		System.out.println(" ,---.     .---.   ,--,    .--.  ,---.  ,---.   \r\n" + 
				" | .-'    ( .-._).' .')   / /\\ \\ | .-.\\ | .-'   \r\n" + 
				" | `-.   (_) \\   |  |(_) / /__\\ \\| |-' )| `-.   \r\n" + 
				" | .-'   _  \\ \\  \\  \\    |  __  || |--' | .-'   \r\n" + 
				" |  `--.( `-'  )  \\  `-. | |  |)|| |    |  `--. \r\n" + 
				" /( __.' `----'    \\____\\|_|  (_)/(     /( __.' \r\n" + 
				"(__)                            (__)   (__)     ");
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		do {
		System.out.print("Type Y for a New Game or N to Exit: ");
		input = sc.next();
		} while(!input.equals("Y") && !input.equals("y") && !input.equals("N") && !input.equals("n"));
		
		if(input.equals("N") || input.equals("n")) {
			System.exit(0);
		}
		System.out.println("New Game Selected!");
		StartAdventure game = new StartAdventure();
		
		do {
		System.out.print("Type 1 for Player or 2 for 2 Players: ");
		input = sc.next();
		} while(!input.equals("1") && !input.equals("2"));
		
		Player player1 = new Player();
		System.out.print("Player 1 name: ");
		String name = sc.next();
		player1.setName(name);
		player1.setHealth(10);
		
		if(input.equals("2")) {
			Player player2 = new Player();
			System.out.print("Player 2 name: ");
			name = sc.next();
			player2.setName(name);
			player2.setHealth(10);
		}
		
		int roomNum;
		String command = "";
		boolean end = false;
		
		//1 player game
		do {
			roomNum = 1;
			game.setRoomNumber(roomNum);
			boolean flashlight = false;
			boolean bottle = false;
			boolean pipe = false;
			boolean keyCar = false;
			boolean keyHall = false;
			boolean[] inventory = {flashlight, bottle, pipe, keyCar, keyHall};
			player1.setInventory(inventory);			
			
		do	{
			if(game.getRoomNumber() == 1) {
				do {
					System.out.println(game.getRoomDescription(player1.getInventory()[0]));
					System.out.println("Type 'help' for a list of commands.");
					command = sc.next();
					inventory = game.action(command, player1.getInventory());
					player1.setInventory(inventory);
				} while(game.getRoomNumber() == 1);
			}
			
			if(game.getRoomNumber() == 2) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				do {
					System.out.println("Type 'help' for a list of commands.");
					command = sc.next();
					inventory = game.action(command, player1.getInventory());
					player1.setInventory(inventory);
				} while(game.getRoomNumber() == 2);
			}
			
			if(game.getRoomNumber() == 3) {
				
			}
			
			if(game.getRoomNumber() == 4) {
				
			}
			
			if(game.getRoomNumber() == 5) {
				
			}
			
			if(game.getRoomNumber() == 6) {
				
			}
			
			if(game.getRoomNumber() == 7) {
				
			}
			
			end = true;
		} while(end != true);
			
			System.out.print("Game Over. Would you like to play again? ");
			command = sc.next();
			
		} while(command.equals("Y") || command.equals("y"));
		
		
		
		
		
	}//end of main method

}//end of PlayGame class
