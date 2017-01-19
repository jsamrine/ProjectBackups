//Julian Amrine
//This program converts two binary numbers with a sum less than 15, converts them to integers, and calculates the sum.  
import java.util.Scanner;
public class homework1 {
public static String num1bin, num2bin, sumbin;
public static int num1int, num2int, sumint;

	public static void main(String[] args) {
		requestNumbers();
		performConversion();
		addValues();
		returnValues();
	}
	
	private static void requestNumbers() {
		System.out.println("This program adds two 4bit binary numbers to a maximum sum of 15");
		System.out.println("Enter a 4 bit binary number");
		Scanner binaryConversion = new Scanner(System.in);
		try {
			num1bin = binaryConversion.nextLine();
			System.out.println("Enter another 4bit binary number");
			num2bin = binaryConversion.nextLine();
			if(num2bin.length() > 4 || num1bin.length() > 4) {
				System.out.println("Please enter a 4bit binary number");
				requestNumbers();
			}
		} finally {
			binaryConversion.close();
		}
	}
	
	private static void performConversion() {
		num1int = (Character.getNumericValue(num1bin.charAt(0))*8) + (Character.getNumericValue(num1bin.charAt(1))*4) + (Character.getNumericValue(num1bin.charAt(2))*2) + Character.getNumericValue(num1bin.charAt(3));
		num2int = (Character.getNumericValue(num2bin.charAt(0))*8) + (Character.getNumericValue(num2bin.charAt(1))*4) + (Character.getNumericValue(num2bin.charAt(2))*2) + Character.getNumericValue(num2bin.charAt(3));;
		
	}
		
	private static void addValues() {
		sumint = num1int + num2int;
		sumbin = Integer.toBinaryString(sumint);
	}

	private static void returnValues() {
		System.out.println("The first number is " + num1int);
		System.out.println("The second number is " + num2int);
		System.out.println("Added together, the sum is " + sumint);
		System.out.println("Which is " + sumbin + " in binary");
	}
}
