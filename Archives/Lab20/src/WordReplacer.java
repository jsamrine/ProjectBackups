import java.util.Scanner;
import java.io.*;
public class WordReplacer {
	private static final String REPLACED_WORD = "danger";
	private static final String DELIM = " ";
	public static void main(String[] args) {
		
		String fileName = "dangerzone.txt";
		String userInput = "";
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word to replace" + REPLACED_WORD + " with");
		userInput = input.nextLine();
		
		Scanner docScanner = new Scanner(new File(fileName));
		String fileLine = "";
		while (docScanner.hasNext())
		{
			fileLine+=docScanner.nextLine();
		}
		fileLine = fileLine.split();
		
	}

}
