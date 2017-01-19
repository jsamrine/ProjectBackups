import java.io.*;
import java.util.*;
public class SalaryAnalyzer {
	static final String IN_FILE_NAME = "StateOfSC-Salary-List-04012015.txt";
	static final String OUT_FILE_NAME = "OVER250000.txt";
	static final String DELIM = "\t";
	public static void main(String[] args)
	{
		System.out.println("Let's see how many state employees make over $250,000 and work at USC.");
		analyzeEmployeeFile(IN_FILE_NAME);
		System.out.println("Results have been printed to "+OUT_FILE_NAME);
	}
	public static void analyzeEmployeeFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			//Reads the professors
			
			while(fileScanner.hasNext())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				int lineLength = splitLines.length;
								
				if(splitLines.length == lineLength)
				{
					int totalIncome = Integer.parseInt(splitLines[6]);
					if(totalIncome>=250000.0)
					{
						String agency = splitLines[0];
						String lastName = splitLines[1];
						String firstName = splitLines[2];
						String jobTitle = splitLines[3];//There's error between here and the next line where it reads the job title as part of the salary. I think it has something to do with multiple delimeters. I'm not sure
						String baseSalary = splitLines[4]; 
						String bonusSalary = splitLines[5];
						String over250000= agency+DELIM+lastName+DELIM+firstName+DELIM+jobTitle+DELIM+baseSalary+DELIM+bonusSalary+DELIM+totalIncome;
						printToSalaryFile(OUT_FILE_NAME, over250000);
					}
				}
				else
				{
					System.out.println("Incorrectly formatted");
				}
				
			}
			
			fileScanner.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	public static void printToSalaryFile(String fileName, String text)
	{
		try
		{
			PrintWriter fileWrite = new PrintWriter(new FileOutputStream(fileName));
			fileWrite.println("Let's see how many state emplyoees make over $250,000 and work at USC");
			for(int i =0; i<100; i++)
			{
				fileWrite.println(text);
			}
			
			fileWrite.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}