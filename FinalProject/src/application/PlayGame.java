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
		
		//Number of players selected
		if(numPlayers == 1) {
			Player player1 = new Player();
			System.out.println("What is your name, player 1?");
			input = sc.nextLine();
			player1.setName(input);
		} else if (numPlayers == 2) {
			Player player1 = new Player();
			System.out.println("What is your name, player 1?");
			input = sc.nextLine();
			player1.setName(input);
			Player player2 = new Player();
			System.out.println("What is your name, player 2?");
			input = sc.nextLine();
			player2.setName(input);
		}
		
		String continueGame;
		
		//game loop calling PlayGame and Player class methods
		do {
			
			
			
			
			
			
			
			continueGame = JOptionPane.showInputDialog("Game End. Do you want to play again? Yes or No?", null);
			
		} while(continueGame.equals("yes") || continueGame.equals("Yes"));
		
		
		
		
		
	}//end of main method

}//end of PlayGame class
