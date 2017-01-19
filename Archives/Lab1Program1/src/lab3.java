//Julian Amrine, Lab 3

/*
Objective:
 
Write a program that prompts the user for a 4 digit whole number (we assume the users will enter this correctly) and then displays it squared!  No, not the mathematical squaring silly goose.  This will make a square box of the number!  WHOA!  The top is the number, the left hand side is the number but going down, the bottom is the number reversed, and the right hand side is the number going up.
 
Example Dialog:
 
Enter an 4 digit number
1234
1234
2  3
3  2
4321
*/
//This program will make a square diagram of any 4 character sequence
import java.util.Scanner;

public class lab3 {
public static String input, row2, row3, row4;

	public static void main(String[] args) {
		requestValue();
		squareValue();
		outputValue();
		
	}
	private static void requestValue() {
		System.out.println("Please Enter a 4 digit whole numnber");
		Scanner numberInput= new Scanner(System.in);
		input = numberInput.nextLine();
		if(input.length() > 4) {
			System.out.println("Incorrect Input. Please enter a 4 digit whole number.");
			requestValue();
		}
		numberInput.close();
	}
	
	private static void squareValue() {
		row2 = ""+input.charAt(1)+ "  " + input.charAt(2);	
		row3 = ""+input.charAt(2)+ "  " + input.charAt(1);
		row4 = ""+input.charAt(3) + input.charAt(2) + input.charAt(1) + input.charAt(0);
	}
	
	
	private static void outputValue() {
		System.out.println(input);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(row4);
	}
}
