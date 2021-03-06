import java.util.Scanner;
import java.io.*;
//Julian Amrine
//Note: Used a lot of JJ's code to help with writing this program
public class MovieDB {
	private static final int DATABASE_SIZE = 10000;
	private static final String DELIM = "\t";
	private Scanner input = new Scanner(System.in);
	private Movie[] Movies;
	private String name, rating, director, userInput;
	private int year, gross;
	private boolean swap; 
	
	public MovieDB() 
	{
		Movies = new Movie[DATABASE_SIZE];
	}

	public void createList() //creates a new list with user specified file name
	{
		System.out.println("Please enter a name for your database");
		String DBName = input.nextLine()+".txt";
		
		for(int i = 0; i < DATABASE_SIZE; i++)
		{
			addMovie();
			System.out.println("Would you like to add another movie?");
			userInput=input.nextLine();
			if(userInput.contains("no")||userInput.contains("n"))
			{
				break;
			}
		}
		printToFile(DBName);
	}
	
	public void editList() 
	{
		System.out.println("Enter the name of the desired database");
		String DBName = input.nextLine();
		readFromFile(DBName+".txt");
		//printDBList();
		boolean running =true; 
		while(running==true)
		{
		System.out.println("Enter 1 to add a movie, 2 to delete a movie, 3 to sort by title, \n4 to sort by year, 5 to sort by rating, 6 to sort by director, \n7 to sort by Box Office Gross, or 0 to exit");
		userInput=input.nextLine();
		switch(userInput)
		{
		case ("1"): 
			addMovie();
			break;
		case ("2"):
			reMovie();
			break;
		case ("3"):
			sortByTitle();
			break;
		case ("4"):
			sortByYear();
			break;
		case ("5"):
			sortByRating();
			break;
		case ("6"):
			sortByDirector();
			break;
		case ("7"):
			sortByGross();
			break;
		case("0"):
			System.exit(0);	
		
		default: 
			System.out.println("Hmm this shouldn't have happened. Try restarting the program!");
			break;
		}
		
		printToFile(DBName+".txt");
		}
	}

	// methods
	// equals method
	
	public void addMovie()
	{
		
		System.out.println("Enter the name of the movie");
		name = input.nextLine();
		System.out.println("Enter the year the movie was released ");
		year = input.nextInt();
		System.out.println("Enter a rating for the movie out of 5 stars");
		input.nextLine();
		rating = input.nextLine();
		System.out.println("Enter the name of the movie's director");
		director = input.nextLine();
		System.out.println("Enter the total box office gross for the movie");
		gross=input.nextInt();
		input.nextLine();
		for(int i=0; i<Movies.length;i++)
		{
			if(Movies[i]==null) //searches for empty array index
			{
				Movies[i] = new Movie(name, year, rating, director, gross);
				break;
			}
		}
	}
	
	public void addMovie(String aName, int aYear, String aRating, String aDirector, int aGross)
	{
		for(int i=0; i<Movies.length;i++)
		{
			if(Movies[i]==null)
			{
				Movies[i] = new Movie(aName, aYear, aRating, aDirector, aGross);
				break;
			}
		}
		
	}
	
	//all sorting methods use bubble sort
	public void reMovie() 
	{
		System.out.println("Enter the name of the movie you'd like to remove.");
		userInput = input.nextLine();
		
		int removeIndex = -1;//Set this to an index that cannot exist for a check later
		for(int i=0;i<Movies.length;i++)//Find the movie by name
		{
			if(Movies[i].getName().equalsIgnoreCase(userInput))
			{
				removeIndex = i;
				break;
			}
		}
		if(removeIndex == -1)//The movie was never found
		{
			System.out.println("The movie was not found");
		}
		else//Movie was found so shift everything to the left by one
		{
			for(int i=removeIndex;i<Movies.length-1;i++)
			{
				Movies[i] = Movies[i+1];
			}
			Movies[Movies.length-1] = null;
		}
	}

	public void sortByTitle() 
	{
		swap = true;
		while(swap == true)
		{
			swap = false;
			for(int i = 0; i < Movies.length; i++)
			{
				
				if(Movies[i+1]==null)
				{
					break;
				}
				
				if(Movies[i].getName().charAt(0)>Movies[i+1].getName().charAt(0))
				{
					Movie temp = Movies[i];
					Movies[i] = Movies[i+1] ;
					Movies[i+1] = temp;
					swap = true;
				}
			}
		}
	}

	public void sortByRating() 
	{
		swap = true;
		while(swap == true)
		{
			swap = false;
			for(int i = 0; i < Movies.length; i++)
			{
				
				if(Movies[i+1]==null)
				{
					break;
				}
				
				if(Movies[i].getRating().length()>Movies[i+1].getRating().length())
				{
					Movie temp = Movies[i];
					Movies[i] = Movies[i+1] ;
					Movies[i+1] = temp;
					swap = true;
				}
			}
		}
	}

	public void sortByGross() 
	{
		swap = true;
		while(swap == true)
		{
			swap = false;
			for(int i = 0; i < Movies.length; i++)
			{
				
				if(Movies[i+1]==null)
				{
					break;
				}
				
				if(Movies[i].getGross()>Movies[i+1].getGross())
				{
					Movie temp = Movies[i];
					Movies[i] = Movies[i+1] ;
					Movies[i+1] = temp;
					swap = true;
				}
			}
		}
	}

	public void sortByDirector() 
	{
		String[] lastNameIndex1,lastNameIndex2;
		swap = true;
		while(swap == true)
		{
			swap = false;
			for(int i = 0; i < Movies.length; i++)
			{
				if(Movies[i+1]==null)
				{
					break;
				}
				
				lastNameIndex1=Movies[i].getDirector().split(" "); //more efficient way?
				lastNameIndex2=Movies[i+1].getDirector().split(" ");
				
				if(lastNameIndex1[1].charAt(0)> lastNameIndex2[1].charAt(0))
				{
					Movie temp = Movies[i];
					Movies[i] = Movies[i+1] ;
					Movies[i+1] = temp;
					swap = true;
				}
			}
		}
	}
	
	public void sortByYear()
	{
		swap = true;
		while(swap == true)
		{
			swap = false;
			for(int i = 0; i < Movies.length; i++)
			{
				if(Movies[i+1]==null)
				{
					break;
				}
				if(Movies[i].getYear()>Movies[i+1].getYear())
				{
					Movie temp = Movies[i];
					Movies[i] = Movies[i+1] ;
					Movies[i+1] = temp;
					swap = true;
				}
			}
		}
	}

	public void printToFile(String aFileName) 
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName));
			for(Movie movie: Movies)
			{
				if(movie == null)
				{
					break;
				}
				fileWriter.println(movie.getName() + DELIM +
									movie.getYear() + DELIM +
									movie.getRating() + DELIM +
									movie.getDirector() +DELIM +
									movie.getGross() + DELIM
									);
			
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception" +e.getMessage());
		}
	}

	public void readFromFile(String aFileName) 
	{
		try
		{
			Movies = new Movie[DATABASE_SIZE];
			Scanner fileScanner = new Scanner(new File(aFileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 5)
				{
					name = splitLines[0];
					year = Integer.parseInt(splitLines[1]);
					rating = splitLines[2];
					director = splitLines[3];
					gross = Integer.parseInt(splitLines[4]);
					
					//TODO: Find a way to add info to a list of movies
					addMovie(name, year, rating, director, gross);
				}
			}
			fileScanner.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception" +e.getMessage());
		}
	}
}
