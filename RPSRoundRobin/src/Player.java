//Julian Amrine
public class Player {
	private String name;
	private int wins, losses, ties;
	
	//default constructor
	public Player(){
		this.name = "No Name";
		this.losses = 0;
		this.wins = 0;
		this.ties = 0;
	}
	// parameterized constructor, only the name is used since each player will start with 0 wins, losses, and ties
	public Player(String aName){
		this.name = aName;
		this.losses = 0;
		this.wins = 0;
		this.ties = 0;
	}

	//generic accessors and mutators
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies() {
		this.ties++;
	}
	
	public void setWins() {
		this.wins++;
	}

	public void setLosses() {
		this.losses++;
	}
	//prints string of player info all on one line
	public String toString()
	{
		String info = "Name " + this.getName() + " Wins " + this.getWins() + " Ties " + this.getTies()
		+ " Losses " + this.getLosses();
		return info; 
	}
}
