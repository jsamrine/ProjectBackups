//Julian Amrine - CSCE 145 Sec - 001
import java.util.Scanner;

public class Lab2 {
	public static int quarter = 25;
	public static int dime = 10;
	public static int nickle = 5;
	public static int penny = 1;
	public static int totalChange;
	public static int changeReadOut, totalQuarters, totalDimes, totalNickles, totalPennies;
	
	public static void main(String[] args) {
		
		requestChangeValue();
		calculateChange();
		returnChange();
	}
	
		private static void requestChangeValue() {
			System.out.println("Please enter a whole number from 1 to 99");
			System.out.println("The machine will determine a combination of coins");
			Scanner change = new Scanner(System.in); //Creates a new scanner called volCalc
			totalChange = change.nextInt(); //defines the variable M as an value entered in the scanner
			if (totalChange > 99) {
				System.out.println("Please enter a number between 1 and 99.");
				requestChangeValue();
			} else {
				change.close();
			}
		}
		
		
		private static void calculateChange() {
			changeReadOut = totalChange;
		
			totalQuarters = totalChange/quarter;
			totalChange = totalChange%quarter;
		
			totalDimes = totalChange/dime;
			totalChange = totalChange%dime;
		
			totalNickles = totalChange/nickle;
			totalChange = totalChange%nickle;
		
			totalPennies = totalChange/penny;
		}
		
		private static void returnChange() {
			System.out.println(changeReadOut + " cents in coins:");
			System.out.println(totalQuarters + " quarters");
			System.out.println(totalDimes + " dimes");
			System.out.println(totalNickles + " nickles");
			System.out.println(totalPennies + " pennies");
		}
	}


