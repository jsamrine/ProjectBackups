import	java.util.Scanner;
public class Lab1Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The following asks for the users name and expected grade
		System.out.println("Hey you!"); //Welcome
		System.out.println("Enter your first and last name.");
		Scanner name = new Scanner(System.in);
			try {
				String firstName = name.nextLine(); //Defines firstName
				String lastName = name.nextLine(); //Defines lastName
				System.out.println("Enter the grade you'd like to get in this course.");
				String grade = name.nextLine();
		//System.out.println("My first name is " + firstName + " and my last name is " + lastName + " and if I study hard, I will make a(n) " + grade + " in CSCE145");
				System.out.println("So you are " + firstName + " " + lastName + ", and you'd like to get a(n) " + grade + " in this course?");
			} finally {
				name.close();
			}
		//The following will add two numbers
		System.out.println("This program computes the volume of an object.");
		Scanner keyboard = new Scanner(System.in);
			try {
				System.out.println("Please enter two values.");
				int value1 = keyboard.nextInt();
				int	value2 = keyboard.nextInt();
				int sum = value1 + value2; //adds the values
				System.out.println("The result of adding " + value1 + " and " + value2 + " is: " + sum);
				System.out.println("The Dude abides.");
			} finally {
				keyboard.close();
			}
		//The following will calculate Volume
		volumeCalculation(); //Calls method volumeCalculation
		}
			private static void volumeCalculation() { //defines method volumeCalculation
				System.out.println("This program calculates volume from user specified mass and density.");
				System.out.println("Please enter the objects mass in grams.");
				Scanner volCalc = new Scanner(System.in); //Creates a new scanner called volCalc
				try {
					double M = volCalc.nextInt(); //defines the variable M as an value entered in the scanner
					System.out.println("Please enter the objects density in grams per cubic centimeter.");
					double D = volCalc.nextInt(); //defines the variable D as an value entered in the scanner
					double V = M/D; //calculates Volume
					System.out.println("The volume of the specified object is " + V + "cm^3");
				} finally {
					volCalc.close();
				}
		}
	}


