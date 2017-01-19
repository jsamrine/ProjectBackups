//Julian Amrine
import java.util.Scanner;
public class RecursivePalindromes {
	public static String word, wordCopy, reply;
	public static void main(String[] args) {
		//program as a seperate method allows for recursive use, although inefficient 
		program();
	}
	private static void program()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word and I will determine if it is a palindrome");
		word = input.nextLine();
		wordCopy = word;
		//Converts word to uppercase. then trims the word of 
		word = word.toUpperCase();
		word = word.replaceAll(" ", "");
		//variables used to as placeholders for char locations in the word
		int startInd = 0;
		int endInd = word.length()-1;
		//boolean check = false;
		int n =0;
		//for(int i = 0)
		while(word.charAt(startInd)==word.charAt(endInd) && startInd <= word.length()/2)
		{
			n++;
			startInd++;
			endInd--;
		}
		n++;
		//if(reverseWord(word, startInd, endInd)) if this is true, the word is a palindrome
		if(n!=0 && n==word.length()/2)
		{
			System.out.println("The word " + wordCopy + " is a palindrome.");
		}
		else
		{
			System.out.println(wordCopy + " is not a palindrome");
		}
		System.out.println("Would you like to check another word? Enter yes or no");
		reply = input.nextLine();
		if(reply.toLowerCase().contains("yes"))
		{
			//recursive call
			program();
		}
		else
		{
			System.out.println("Goodbye!");
		}
	}
	//reverseWord returns a boolean true or false depending on the characters at opposite ends of the word match
	
	
	
	private static boolean reverseWord(String aWord, int startInd, int endInd)
	{
		//if the character at the start index and its opposite index does not 
		
		if(word.charAt(startInd) != word.charAt(endInd))
		{
			return false;
		}
		//if statement checks if the word length is less than two or if each character is the same in opposing indexes
		else if(word.length()<2)
		{
			return true;
		}
		else if((word.charAt(startInd) == word.charAt(endInd) && startInd <= word.length()/2))
		{
			//System.out.println(word.charAt(startInd) + " vs " + word.charAt(endInd));
			startInd++; //start index is moved up one
			endInd--; //end index is moved back one
			//System.out.println(word.charAt(startInd) + " vs " + word.charAt(endInd));
			return reverseWord(aWord, startInd, endInd); //method is called again
		}
		else //if the word has gotten to middle of the word, the start index is greater than half the word, so all checks have been completed and any more would be redundant
		{
			return true;
		}
		
		
	}
}
