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
		} while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));
		
		if(input.equalsIgnoreCase("n")) {
			System.exit(0);
		}
		System.out.println("New Game Selected!");
		StartAdventure game = new StartAdventure();
		
		Player player1 = new Player();
		System.out.print("Player 1 name: ");
		String name = sc.next();
		player1.setName(name);
		player1.setHealth(10);
		
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
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.lobbyRoom(command, player1.getInventory());
					player1.setInventory(inventory); 
				} while(game.getRoomNumber() == 1);
			}
			
			if(game.getRoomNumber() == 2) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.barRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 2);
			}
			
			if(game.getRoomNumber() == 3) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.kitchenRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 3);
			}
			
			if(game.getRoomNumber() == 4) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.hallwayRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 4);
			}
			
			if(game.getRoomNumber() == 5) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.bedRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 5);
			}
			
			if(game.getRoomNumber() == 6) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.bathRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 6);
			}
			
			if(game.getRoomNumber() == 7) {
				System.out.println(game.getRoomDescription(player1.getInventory()[0]));
				System.out.print("Type 'help' for a list of commands.\n");
				do {
					command = sc.nextLine();
					inventory = game.outsideRoom(command, player1.getInventory());
					player1.setInventory(inventory);					
				} while(game.getRoomNumber() == 7);
			}
			
			end = true;
		} while(end != true);
			
			System.out.print("Game Over. Would you like to play again? ");
			command = sc.nextLine();
			
		} while(command.equalsIgnoreCase("y"));
		
		
		
		
		
	}//end of main method

}//end of PlayGame class
