import java.util.Scanner;

public class Lab1VolumeCalculation {

	public static void main(String[] args) {
		volumeCalculation(); //Calls method volumeCalculation
	}
		private static void volumeCalculation() { //defines method volumeCalculation
			System.out.println("This program calculates volume from user specified mass and density.");
			System.out.println("Please enter the objects mass in grams.");
			Scanner volCalc = new Scanner(System.in); //Creates a new scanner called volCalc
			double M = volCalc.nextInt(); //defines the variable M as an value entered in the scanner
			System.out.println("Please enter the objects density in grams per cubic centimeter.");
			double D = volCalc.nextInt(); //defines the variable D as an value entered in the scanner
			double V = M/D; //calculates Volume
			System.out.println("The volume of the specified object is " + V + "cm^3");
		}
	}
