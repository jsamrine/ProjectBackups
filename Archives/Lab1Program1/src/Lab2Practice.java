//Julian Amrine
import java.util.Scanner;

public class Lab2Practice {

	public static void main(String[] args) {
	
		int quarter = 25;
		int dime = 10;
		int nickle = 5;
		int penny = 1;
		System.out.println("Please enter a whole number from 1 to 99");
		System.out.println("The Machine will determine a combination of coins");
		Scanner change = new Scanner(System.in); //Creates a new scanner called volCalc
		
		int totalChange = change.nextInt(); //defines the variable M as an value entered in the scanner
		
		change.close();
		int changeReadOut = totalChange;
		
		int remainder = totalChange%quarter;
		int totalQuarters = (totalChange - remainder)/quarter;
						
		totalChange = remainder;
		remainder= remainder%dime;
		int totalDimes = (totalChange - remainder)/dime;
		
		totalChange = remainder;
		remainder = totalChange%nickle;
		int totalNickles = (totalChange - remainder)/nickle;
		
		totalChange = remainder;
		remainder = totalChange%penny;
		int totalPennies = (totalChange - remainder)/penny;
		
		
		
		
		System.out.println(changeReadOut + " cents in coins:");
		System.out.println(totalQuarters + " quarters");
		System.out.println(totalDimes + " dimes");
		System.out.println(totalNickles + " nickles");
		System.out.println(totalPennies + " pennies");
				
	}

}
