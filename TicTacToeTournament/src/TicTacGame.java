//Julian Amrine
import java.io.*; //imports all relevant io/out packages 
import java.util.*; //imports all relevant util packages

public class TicTacGame {
	public static Random RNG = new Random();
	public static String[][] gameBoard = new String[3][3]; //array with length and width 3, only goes to index 2
	public static boolean playing = true; //game states
	public static boolean playerWin = false;
	public static boolean cWin = false;
	public static int pWins, X, Y, turns;
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(
				"Welcome to the Tic Tac Toe Tourney! Win as many games as you can in a row. Enter -1 to quit.");
		game();

	}

	private static void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = "_";
			}
		}
		// Resets all values to their default values
		playerWin = false;
		cWin = false;
		playing = true;
		turns = 0;
	}

	private static void printBoard() {
		//gameBoard array is a separate entity from the physical representation of the board
		//printBoard merely prints the static image with the updated array index values
		System.out.println(" |    0     |    1     |    2     |" + "\n__________________________________" + "\n0|    "
				+ gameBoard[0][0] + "     |    " + gameBoard[0][1] + "     |    " + gameBoard[0][2] + "     |   "
				+ "\n__________________________________" + "\n1|    " + gameBoard[1][0] + "     |    " + gameBoard[1][1]
				+ "     |    " + gameBoard[1][2] + "     |   " + "\n__________________________________" + "\n2|    "
				+ gameBoard[2][0] + "     |    " + gameBoard[2][1] + "     |    " + gameBoard[2][2] + "     |   "
				+ "\n__________________________________");

	}

	private static void game() {
		//sets up board
		initializeBoard();

		while (playing == true) {
			//displays initial board state
			printBoard();
			//player sets their coordinates
			playerTurn();
			//displays player's turn
			printBoard();
			//this check is really only here to check for a CAT condition
			checkForWin();
			if (playing == false) {
				break;
			}
			//computer takes turn, and computer's turn is displayed
			computerTurn();
			printBoard();
			//checks for a win condition
			checkForWin();
		}
		postGame();// the game is no longer being played and so the program shifts to the post game state
	}

	private static void computerTurn() {
		X = RNG.nextInt(3); //picks a number between 0 and 2 for the x and y coordinates 
		Y = RNG.nextInt(3);
		if (!gameBoard[Y][X].contains("_")) { //if a space is occupied the computer takes its turn again
			computerTurn();
		} else {
			gameBoard[Y][X] = "O";
			System.out.println("Computer's Turn");
			turns++; //counts turns to check for CAT condition
		}
	}

	private static void playerTurn() {
		System.out.println("Enter the coordinates to place an \"X\" Row then Column.");
		X = input.nextInt();
		Y = input.nextInt();
		if (X == -1 || Y == -1) { //if player quits the computer automatically wins
			cWin = true;
			playing = false;
		} else if (X > 2 || Y > 2) { //if x or y is greater than 2 this would cause an array out of bounds exception, so the player is then prompted to try again
			System.out.println("Invalid number. Pick a coordinate between 0 and 2.");
			playerTurn();
		} else if (!gameBoard[Y][X].contains("_")) { //if a space is occupied the user is prompted to take their turn again
			System.out.println("That space is taken. Please choose another");
			playerTurn();
		} else {
			gameBoard[Y][X] = "X"; 
			turns++;
		}
	}

	private static boolean checkForWin() {
		
		if ((gameBoard[0][0].contains("X") && gameBoard[0][1].contains("X") && gameBoard[0][2].contains("X")) //checks for the 8 different win states, 3 different 3 in a row conditions, 3 different 3 in a column conditions, 2 different 3 in a diagonal conditions.
				|| (gameBoard[1][0].contains("X") && gameBoard[1][1].contains("X") && gameBoard[1][2].contains("X"))
				|| (gameBoard[2][0].contains("X") && gameBoard[2][1].contains("X") && gameBoard[2][2].contains("X"))
				|| (gameBoard[0][0].contains("X") && gameBoard[1][0].contains("X") && gameBoard[2][0].contains("X"))
				|| (gameBoard[0][1].contains("X") && gameBoard[1][1].contains("X") && gameBoard[2][1].contains("X"))
				|| (gameBoard[0][2].contains("X") && gameBoard[1][2].contains("X") && gameBoard[2][2].contains("X"))
				|| (gameBoard[0][0].contains("X") && gameBoard[1][1].contains("X") && gameBoard[2][2].contains("X"))
				|| (gameBoard[0][2].contains("X") && gameBoard[1][1].contains("X") && gameBoard[2][0].contains("X"))) {
			pWins++; 
			playerWin = true;
			playing = false;

		} else if ((gameBoard[0][0].contains("O") && gameBoard[0][1].contains("O") && gameBoard[0][2].contains("O")) //checks for the 8 different win states, 3 different 3 in a row conditions, 3 different 3 in a column conditions, 2 different 3 in a diagonal conditions.
				|| (gameBoard[1][0].contains("O") && gameBoard[1][1].contains("O") && gameBoard[1][2].contains("O"))
				|| (gameBoard[2][0].contains("O") && gameBoard[2][1].contains("O") && gameBoard[2][2].contains("O"))
				|| (gameBoard[0][0].contains("O") && gameBoard[1][0].contains("O") && gameBoard[2][0].contains("O"))
				|| (gameBoard[0][1].contains("O") && gameBoard[1][1].contains("O") && gameBoard[2][1].contains("O"))
				|| (gameBoard[0][2].contains("O") && gameBoard[1][2].contains("O") && gameBoard[2][2].contains("O"))
				|| (gameBoard[0][0].contains("O") && gameBoard[1][1].contains("O") && gameBoard[2][2].contains("O"))
				|| (gameBoard[0][2].contains("O") && gameBoard[1][1].contains("O") && gameBoard[2][0].contains("O"))) {
			cWin = true;
			playing = false;
		} else if (turns == 9) {
			System.out.println("No more moves possible! The game is a draw"); //if no winning move has been made, but the turn count reaches 9 then 9 spaces have been occupied making it impossible to continue to play
			playing = false;
		}
		return playing; // returns boolean value playing
	}

	private static void postGame() {
		String name;
		if (playerWin == true) { //player has won, another game is set up
			System.out.println("Congratualtions! You've won " + pWins + " times!");
			System.out.println("The Computer demands a rematch");
			turns = 0;
			game();
		} else if (cWin == true) { //computer has won, player streak is appended to highscore.txt with user specified name
			System.out.println("You've lost, but you won " + pWins + " times!");
			System.out.println("Enter your name to record your score");
			input.nextLine();
			name = input.nextLine();
			printStreak(name, pWins);

			pWins = 0; //resets wins
			readStreaks("highscore.txt"); //reads all player streaks from highscore.txt
			System.out.println("Play again? Type yes or no");
			name = input.nextLine();
			if (name.toLowerCase().equals("yes")) {//starts a new game if player types yes
				game(); 
			} else {
				System.out.println("Goodbye!");
				System.exit(0);	//Program exits
			}
		} else { //in case of a draw the player wins count is not advanced and a new game is set up
			System.out.println("You've won " + pWins + " times!");
			System.out.println("The Computer demands a rematch");
			turns = 0;
			game();
		}
	}

	private static void printStreak(String aName, int aWins) { // takes in name and number of wins
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream("highscore.txt", true)); //Filewriter will write to true makes sure data is appended to the end of the file rather than overwriting the file
			fileWriter.println(aName + " " + aWins);//prints to file in format Name Wins
			fileWriter.close(); // closes filewriter
		} catch (Exception e) { 
			System.out.println("Exception" + e.getMessage()); //prints message if exception is thrown
		}
	}

	private static void readStreaks(String fileName) { //outputs file contents to consoles
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while (fileScanner.hasNextLine()) { //while there is a next line 
				String fileLine = fileScanner.nextLine(); //fileLine is assigned to that line of the text file 
				System.out.println(fileLine); //fileLine is printed
			}
			fileScanner.close();

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
}
