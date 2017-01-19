//Julian Amrine
import java.util.Scanner;
import java.io.*;
public class VowelCounter {

	public static void main(String[] args) {
		String fileName = "blah.txt";
		int aeiouCount = 0;
		
		System.out.println("Reading file...");
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine = "";
			
			while(fileScanner.hasNextLine())
			{
				fileLine+=fileScanner.nextLine();
			}
			//converts fileLine to lower case, replacing everything that is not a vowel
			fileLine = fileLine.replaceAll("\\s+", "");
			fileLine = fileLine.replaceAll(" ", "");
			fileLine = fileLine.replaceAll("\\W+", "");
			fileLine = fileLine.toLowerCase();
			String vowelLine = fileLine.replaceAll("[bcdfghjklmnpqrstvwxyz]", "");
			
			//converts the string into an array of characters
			char[] vowelArray = vowelLine.toCharArray();
			//starting at index i, searches for consecutive instances of AEIOU
			for(int i = 0; i<vowelLine.length(); i++)
				if(vowelArray[i]=='a'
						&& vowelArray[i+1] == 'e'
						&& vowelArray[i+2] == 'i'
						&& vowelArray[i+3] == 'o'
						&& vowelArray[i+4] == 'u')
				{
					aeiouCount++;
					i+=4;
				}
			
			System.out.println("The file " +  fileName + " has \"AEIOU\" in order " +aeiouCount+ " times");
			fileScanner.close();
			

		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
