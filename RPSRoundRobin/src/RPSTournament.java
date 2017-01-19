//Julian Amrine
/*
 * The following program does a double round robin tournament of RPS between a number of computer controlled players
 * The number of players can be modified by changing the value of ENTRANTS to the desired number of players
 */
import java.util.Random;

public class RPSTournament {
	//RNG used to make computer choices
	private static Random RNG = new Random();
	//String will store computer choices
	private static String Computer1, Computer2;
	//temporarily stores player data from different positions within the linked list
	private static Player Player1, Player2;
	//modify the number of entrants to however many you want
	public static final int ENTRANTS = 10;
	public static void main(String[] args) {
		System.out.println("Welcome to the RPS round robin tournament. Place your bets and lets get playing!");
		//creates generic circular linked list of type player 
		CircularLinkedList<Player> list = new CircularLinkedList<Player>();
		
		
		
		for (int i = 0; i < ENTRANTS; i++) {
			//creates # of players equal to number of entrants, each with name i, and inserts these players to the end of the last node entered
			String name = Integer.toString(i);
			Player newPlayer = new Player(name);
			list.insert(newPlayer);
		}
		//List is at last player added, so go to next will bring the list back to the first player entered on list
		list.goToNext();
		
		for (int i = 0; i < ENTRANTS; i++) //for loop runs number of games for each player in the list
		{
			//player1 makes a shallow copy of the player in the currently active node
			Player1 = list.getInfoAtCurrent();
			//list cycles to next node
			list.goToNext();
			// computer grabs info from the node next in the list
			Player2 = list.getInfoAtCurrent(); 

			while (Player1 != Player2) // checks for same node.
			{
				//calls method computer choice where the winner/loser is decided
				computerChoice();
				// list iternates to next node
				list.goToNext();
				// computer 2 makes shallow copy(?) of player at the current node
				Player2 = list.getInfoAtCurrent();
				//when the loop runs again, Player 1 is still the same, and Player 2 becomes the next node in the list
			}
			//Once Player1 is the same as Player2, the list has cycled completely, and the list is currently at the node that player1 is a shallow copy of, so the loop is broken
			//The list then goes to the next node, which is then set to player1, and so forth
			list.goToNext();
			
		}
		System.out.println("The tournament is over, the results are posted below");
		//Starting from the top, each player's information is displayed in a list
		list.showList();
		// The total number of wins, losses, and ties for each player will be
		// the number of entrants*2 - 2
	}
	//its Rock Paper scissors yo
	//method makes computer choices and determines winner
	private static void computerChoice() {
		// computers each pick a number between 0-2 corresponding to
		// rock, paper, scissors
		int rng = RNG.nextInt(3);
		if (rng == 0) {
			Computer1 = "rock";
		} else if (rng == 1) {
			Computer1 = "paper";
		} else if (rng == 2) {
			Computer1 = "scissors";
		}

		rng = RNG.nextInt(3);
		if (rng == 0) {
			Computer2 = "rock";
		} else if (rng == 1) {
			Computer2 = "paper";
		} else if (rng == 2) {
			Computer2 = "scissors";
		}

		// Print results
		System.out.println(Player1.getName() + " chooses " + Computer1);
		System.out.println(Player2.getName() + " chooses " + Computer2);

		// check for win conditions
		if (Computer1.equals("rock")) {
			if (Computer2.equals("rock")) {
				System.out.println("Tie");
				Player1.setTies();// non parameterized setTies mutator simply
									// takes the relevant score and adds 1
				Player2.setTies(); //p1 and p2 ties++

			} else if (Computer2.equals("paper")) {
				System.out.println(Player2.getName() + " was won!");
				Player2.setWins();// p2 wins++
				Player1.setLosses(); //p1 losses++
			} else if (Computer2.equals("scissors")) {
				System.out.println(Player1.getName() + " was won!");
				Player1.setWins();// p1 wins++
				Player2.setLosses(); //p2 losses++
			}
		} else if (Computer1.equals("paper")) {
			if (Computer2.equals("rock")) {
				System.out.println(Player1.getName() + " was won!");
				Player1.setWins();// p1 wins
				Player2.setLosses();

			} else if (Computer2.equals("paper")) {
				System.out.println("Draw!");
				Player1.setTies();
				Player2.setTies();

			} else if (Computer2.equals("scissors")) {
				System.out.println(Player2.getName() + " was won!");
				Player2.setWins();// p2 wins
				Player1.setLosses();// computerWins++;
			}
		} else if (Computer1.equals("scissors")) {
			if (Computer2.equals("rock")) {
				System.out.println(Player2.getName() + " was won!");
				Player2.setWins();// p2 wins, wins++
				Player1.setLosses();// p1 losses++;

			} else if (Computer2.equals("paper")) {
				System.out.println(Player1.getName() + " was won!");
				Player1.setWins();// p1 wins
				Player2.setLosses();// player1Wins++;

			} else if (Computer2.equals("scissors")) {
				System.out.println("Draw!");
				Player1.setTies();
				Player2.setTies();
			}
		}
	}
}
