//Julian Amrine
//This program accepts 10 tacos and their prices, then rearranges from lowest price to highest price
//

import java.util.Scanner;

public class FoodArrays {
	
	public static Scanner input;
	public static int count, smallestPrice;
	public static double[] tacoValue;
	public static String[] tacoInput;
	public static final int TOTAL_TACOS = 10;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		tacoInput = new String[TOTAL_TACOS];
		tacoValue = new double[TOTAL_TACOS];
		count = 1;
		System.out.println("Welcome to the TacoTron9000. This program will accept up to 10 tacos and their prices, and sort them according to price. ");
		for (int i = 0; i<10; i++)
		{
			System.out.println("Enter the name of taco " + count);
			tacoInput[i] = input.nextLine();
			System.out.println("Enter taco's price: ");
			double tacoPrice = input.nextDouble();
			
			if (tacoPrice > 0)
			{
				tacoValue[i] = tacoPrice;	
			} 
			else 
			{
			System.out.println("Bro we're not giving away tacos! This isnt a taco charity!");	
			}
			
			input.nextLine();
			count++;
		}
		
		sort();
		for (int i = 0; i < tacoValue.length; i++)
		{
			System.out.printf("Taco Prices " + tacoInput[i] + " " + "%.2f",tacoValue[i]);
			System.out.println("");
		}
	}
	private static void sort()
	{
		for(int i = 0; i<tacoValue.length; i++) //checks each index value starting with the first
		{
			smallestPrice = i; //Starts with first value of the index
			for(int j = i; j<tacoValue.length;j++) //starting with the first value of the index, will compare the two. Any number in the index that is less than the number being checked will update smallestValue to that number, which is now its reference location within the arrays
			{
				if(tacoValue[j]< tacoValue[smallestPrice])
				{
					smallestPrice = j;
				}
			}
			if (smallestPrice != i)//Swaps values if a smaller number is found
			{
				double tempNum = tacoValue[i];
				tacoValue[i] = tacoValue[smallestPrice];
				tacoValue[smallestPrice] = tempNum;
				
				String tempStr = tacoInput[i];
				tacoInput[i] = tacoInput[smallestPrice];
				tacoInput[smallestPrice] = tempStr;
				
						
			}
		}
	}

}
