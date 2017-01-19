//Julian Amrine
//This program will play rock, paper, scissors with the user
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
public static String playerInput, computerChoice;
public static int playerWins, computerWins, rng, games;
public static Random rnGeezus;
public static Scanner input;
	public static void main(String[] args) {
		introduction();
	}
	private static void introduction() {
		playerWins = 0;
		computerWins = 0;
		games = 3;
		System.out.println("Welcome to the greatest game in history, Rock, Paper, Scissors");
		System.out.println("Games are best 2 out of 3. Good luck.");
		gameSetup();
	}
	
	private static void gameSetup() {
		computerChoice();
		input = new Scanner(System.in);
		for (int i = 1; i <= games; i++) 
		{
			System.out.println("Choose your weapon! (Enter rock, paper, or scissors)");
			playerInput = input.nextLine().toLowerCase();
			System.out.println("Game: " + i );
			System.out.println(playerInput + " vs " + computerChoice +"!");
			game();
		}	
		postGame();
	}
	private static void computerChoice() {
		rnGeezus = new Random();
		rng = rnGeezus.nextInt(3);
		if (rng == 0) //If the rng chooses 0, it rerolls
		{
			computerChoice = "scissors";
		} 
		else if(rng == 1) 
		{
			computerChoice = "rock";	
		}
		else if(rng == 2)
		{
			computerChoice = "paper";
		}
		
	}

	private static void game() {
		if (playerInput.equals("rock"))
		{
			if(computerChoice.equals("rock"))
			{
				System.out.println("Draw!");
				
			} 
			else if (computerChoice.equals("paper")) 
			{
				System.out.println("You've lost to the machine! The computer wins!");
				computerWins++;
				
			}
			else if (computerChoice.equals("scissors"))
			{
				System.out.println("You've won!");
				playerWins++;
				
			}
		}
		else if(playerInput.equals("paper"))
		{
			if(computerChoice.equals("rock"))
			{
				System.out.println("You've won!");
				playerWins++;
				
			} 
			else if (computerChoice.equals("paper")) 
			{
				System.out.println("Draw!");
				
			}
			else if (computerChoice.equals("scissors"))
			{
				System.out.println("You've lost to the machine! The computer wins!");
				computerWins++;
			}
		}
		else if	(playerInput.equals("scissors"))
		{
			if(computerChoice.equals("rock"))
			{
				System.out.println("You've lost to the machine! The computer wins!");
				computerWins++;
								
			} 
			else if (computerChoice.equals("paper")) 
			{
				System.out.println("You've won!");
				playerWins++;
				
			}
			else if (computerChoice.equals("scissors"))
			{
				System.out.println("Draw!");	
				
			}
		}
		else
		{
			System.out.println("Invalid input. The computer wins!");
			computerWins++;
		}
		
	}
	
	private static void postGame()
	{
		System.out.println("You've won " + playerWins + " times. The computer has won " + computerWins + " times.");
		if (playerWins > computerWins) 
		{
			System.out.println("You beat the computer! Congratulations!");
		} 
		else if (playerWins < computerWins)
		{
			System.out.println("The computer beat you! The day of the machines is nearly upon us!");
		}
		else if (playerWins == computerWins)
		{
			System.out.println("Its a draw! You'd better play again to break the tie!");
		}
		System.out.println("Would you like to play again?");
		playerInput = input.nextLine();
		if (playerInput.contains("yes")||playerInput.contains("yeah")||playerInput.contains("y"))
		{
			gameSetup();
		}
		else
		{
			System.out.println("Thank you for playing! Have a good day!");
			System.exit(0);
		}
	}
}


