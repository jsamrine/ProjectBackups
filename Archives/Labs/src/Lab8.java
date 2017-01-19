//Julian Amrine
//This program records 10 days worth of temperatures, calculates an average, then indicates which days were hotter than the average
import java.util.Scanner;
public class Lab8 {
	public static Scanner input;
	public static double[] weeklyWeather;
	public static double userInput, tempSum, tempAvg;
	public static int day;
	
	public static final int DAYS = 10; //Hard caps the amount of days to 10
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Welcome to the above average temperature tester program.");
		weeklyWeather = new double[DAYS];
		for (int i = 0; i <weeklyWeather.length; i++)
		{
			day = i + 1;
			System.out.println("Please enter the temperature for day " + day + " in degrees Fahrenheit");
			userInput = input.nextDouble();
			if(userInput>134||userInput<-130)
			{
				System.out.println("Woah now! That temperature is impossible under the earth's current conditions.");
				System.out.println("Why dont you try some more realistic temperartures between 135F and -130C");
				System.exit(0);
			}
			weeklyWeather[i] = userInput;
		}
		for (double i: weeklyWeather)
		{
			tempSum += i; //adds each of the temperatures in the array as tempSum = tempSum + (arrayValue)
		}
		tempAvg = tempSum/DAYS;
		System.out.println("The average temperature was " + tempAvg);
		System.out.println("The days that were above average were");
		for(int i = 0; i < weeklyWeather.length; i++)
		{
			day = i + 1;
			if(weeklyWeather[i]>tempAvg) //Checks for temperatures above the 10 day average.
			{
				System.out.println("Day " + day + " with " + weeklyWeather[i]);
			}
		}
		input.close();
	}

}
