import java.util.*;
import java.io.*;
//Julian Amrine
public class MovieDriver extends MovieDB {
	private static boolean running = true;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		MovieDB MovieList = new MovieDB();
		while(running==true)
		{
			System.out.println("Welcome your personal movie database. \nPress 1 to create a list, and 2 to view your list, and 0 to exit the program");
			String userInput = input.nextLine();
		
			if(userInput.equals("1"))
			{
				MovieList.createList();		
			}
			else if(userInput.equals("2"))
			{
				MovieList.editList();
			}
			else if(userInput.equals("0"))
			{
				running=false;
				System.exit(0);
			}
		}
		input.close();
	}
}
