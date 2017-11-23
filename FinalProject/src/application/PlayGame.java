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
		System.out.print("Enter any character to begin or 'x' to quit the game: ");
		String input = sc.nextLine();
		if(input.equals("x")){
			System.exit(0); //end game if input is x
		}
		input = "";
		
		//Game is started
		StartAdventure game = new StartAdventure();
		
		//Do while loop determines number of players
		int numPlayers;
		
		do {
		System.out.println("Type 1 for single player or 2 for two-person multiplayer.");
		numPlayers = sc.nextInt();
		} while(numPlayers != 1 && numPlayers != 2);
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		//Number of players selected
		if(numPlayers == 1) {
			System.out.println("What is your name, player 1?");
			String name = sc.next();
			player1.setName(name);
			
		} else if (numPlayers == 2) {
			System.out.println("What is your name, player 1?");
			String name = sc.next();
			player1.setName(name);
			System.out.println("What is your name, player 2?");
			name = sc.next();
			player2.setName(name);
		}
		
		String continueGame = "";
		boolean gameEnd = false;
		
		String item;
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("go north");
		commands.add("go east");
		commands.add("go south");
		commands.add("go west");
	      
		int roomNum = 0;
		
		//game loop calling PlayGame and Player class methods
		
		if(numPlayers == 1) {
			
		do {
			roomNum = 1;
			game.setRoomNumber(roomNum);
			Flashlight f = new Flashlight(false);
			boolean flashlight = f.getStatus();
			
			System.out.println(game.getRoomDescription(flashlight));
			String action = sc.next();
			
			for(String command: commands){
				if(action.equals(command)){
					game.action(command, flashlight, );
				}
			}
			
			if(action.equals("go north") || action.equals("go east") || action.equals("go south") || action.equals("go west")) {
				
			} else {
				game.getCommandList();
			}
			
			
			
			
			
			
			
			
			gameEnd = true;
			if(gameEnd == true) {
			System.out.println("Game End, " + player1.getName() + ". Do you want to play again? Yes or No?");
			continueGame = sc.next();
			}	
			
		} while(continueGame.equals("yes") || continueGame.equals("Yes"));
		
		System.exit(0);
		
		}
		
		
		
		
		
		
		
	}//end of main method

}//end of PlayGame class
