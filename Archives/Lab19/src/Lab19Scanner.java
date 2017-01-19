//Julian Amrine

import java.util.Scanner;
import java.io.*;
public class Lab19Scanner{
	public static final String DELIM = " ";
	public static final String SCRIPT = "StarWarsNewHopeScript.txt";
	public static int deathStarCount, wookieCount, forceCount, jabbaCount;
	public static void main(String[] args) 
	{
		searchForKeyWords();
		readOut();
	}
	
	public static void searchForKeyWords()
	{
		System.out.println("Scanning Script for key words.");
		try
		{
			Scanner fileScanner = new Scanner(new File(SCRIPT));
			String fileLine = "";
			
			while(fileScanner.hasNextLine())
			{
				fileLine+=fileScanner.nextLine().toLowerCase()+DELIM;
			}
			fileScanner.close();
			fileLine = fileLine.replaceAll("\\s+", DELIM); 
			String[] splitLines = fileLine.split(DELIM);
			//Reads the professors
			
			for(int i = 0;i<splitLines.length;i++)
			{		
				if(splitLines[i].contains(("wookie")))
				{
					wookieCount++;
				}
				else if (splitLines[i].contains("jabba"))
				{
					jabbaCount++;
				}
				else if (splitLines[i].contains("death") && splitLines[i+1].contains("star"))
				{
					deathStarCount++;
				}
				else if(splitLines[i].contains("force"))
				{
					forceCount++;
				}
			}	
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void readOut()
	{
		System.out.println("The number of times the word \"Force\" appears in Star Wars is " + forceCount);
		System.out.println("The number of times the word \"Wookie\" appears in Star Wars is " + wookieCount);
		System.out.println("The number of times the word \"Jabba\" appears in Star Wars is " + jabbaCount);
		System.out.println("The number of times the word \"Death Star\" appears in Star Wars is " +deathStarCount);
	}

	}

