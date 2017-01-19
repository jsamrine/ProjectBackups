import java.util.Scanner;
import java.util.Random;

public class MineWalker {

	enum Spaces{Empty, Player, Mine, Goal};
	public static Random RNG = new Random();
	public static Scanner input = new Scanner(System.in);
	public static final int BOARD_SIZE = 10;
	public static Spaces[][] gameBoard = new Spaces[BOARD_SIZE][BOARD_SIZE];
	public static int mX, mY, pX, pY, gX, gY;
	public static boolean gameOver;
	public static String userInput;
	
	public static void main(String[] args) {
		game();
	}
	
	private static void game()
	{
		int numberOfMoves = 0;
		//Player Location;
		pX = 0;
		pY = 0;
		//Randomly determined goal location
		gX = RNG.nextInt(BOARD_SIZE);
		gY = RNG.nextInt(BOARD_SIZE);
		//initializes mine locations
		
		
		//initializes game board
		for(int y = 0; y<gameBoard.length; y++)
		{
			for(int x=0; x<gameBoard.length; x++)
			{
				gameBoard[x][y] = Spaces.Empty;
			}
		}
		
		//initializes player and cone locations
		gameBoard[pX][pY] = Spaces.Player;
		gameBoard[gX][gY] = Spaces.Goal;
		
		//initializes mine locations
		mineInitialization();
		//Starts the game, setting each space to its correct character.
		gameOver = false;	
		while(gameOver==false)
		{
			for (int y=0; y<gameBoard.length; y++)
			{
				for (int x=0; x<gameBoard.length; x++)
				{
					switch(gameBoard[x][y])
					{
					case Empty:
						System.out.print("__");
						break;
					case Player:
						System.out.print(":D");
						break;
					case Goal:
						System.out.print("C>");
						break;
					case Mine:
						System.out.print("__"); //used XX for bug testing
						break;
					default:
						System.out.print("??");
						break;
					}
				}
				System.out.println(" ");
			}
		
			System.out.println("Enter either -1,0,1 to move in the x or 9 to quit");
			//Movement in the X direction
			int dX = input.nextInt();
			//Or quit
			if(dX == 9)
			{
				System.out.println("Game over");
				break;
			}
		
			System.out.println("Enter either -1,0,1 to move in the y");
			
			//Movement in the y direction
			int dY = input.nextInt();
		
			//Checks to see if the movement is valid
			if(dX <-1 || dX>1)
			{
				System.out.println("Invalid input X");
				dX = 0;
			}
			if(dY <-1 || dY>1)
			{
				System.out.println("Invalid input Y");
				dY = 0;
			}
		
			//Sets the previous player position to empty
			gameBoard[pX][pY] = Spaces.Empty;
			
			//Moves the player
			pX+=dX;
			pY+=dY;

			//If player moves out of bounds, corrects for that.
			if(pX < 0)
			{
				pX = 0;
			}
			else if(pX>BOARD_SIZE-1)
			{
				pX = BOARD_SIZE-1;
			}
			if(pY < 0)
			{
				pY = 0;
			}
			else if(pY> BOARD_SIZE-1)
			{
				pY = BOARD_SIZE-1;
			}

		
			//Loss condition
			if(gameBoard[pX][pY]==Spaces.Mine)
			{
				System.out.println("You stepped on a mine and died! Get good!");
				System.out.println("You died in " +numberOfMoves+" moves!");
				gameOver=true;
				gameOver();
			}
			
			//Win condition
			if(gameBoard[pX][pY]==Spaces.Goal)
			{
				System.out.println("You win! The secret location was at "+gX+", "+gY);
				System.out.println("It took "+numberOfMoves+" moves to win!");
				gameOver = true;
				gameOver();
			}
			//Sets the player in the new position
			gameBoard[pX][pY] = Spaces.Player;
			numberOfMoves++;
		}
	}
	
	//Sets 10 mines at random places throughout the board, without replacing the player, goal, or other mines
	private static void mineInitialization(){
		for (int m = 0; m < BOARD_SIZE; m++)
		{
			mX = RNG.nextInt(BOARD_SIZE);
			mY = RNG.nextInt(BOARD_SIZE);
			if(gameBoard[mX][mY].equals(Spaces.Empty))
			{
				gameBoard[mX][mY] = Spaces.Mine;
			}
			else
			{
				m--;
			}
		}
	}
	
	//Prompts player to play again
	private static void gameOver() {
		System.out.println("Would you like to play again?");
		input.nextLine();
		userInput = input.nextLine();
		if(userInput.contains("yes")||userInput.equals("y"))
		{
			game();
		}
		else
		{
			System.out.println("Stay golden.");
			System.exit(0);
		}
	}

}
