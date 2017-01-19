//Julian Amrine
import java.util.Random;

public class LinearVBinarySearches {
	public static int[] array = new int[2000];
	public static Random RNG = new Random();
	public static int lTotCheck, bTotCheck, aValue, lCheck, bCheck;
	public static double bAvg, lAvg;
	public static void main(String[] args) {
		
		
		for(int j= 0; j < 20; j++)
		{
			//new array is initialized with 1000 randomly generated integers between 0 and 999
			array = initialize();
			aValue = RNG.nextInt(2000);
			
			//performs a linear search
			System.out.println("Searching using linear search");
			lCheck = linearCheck(array, aValue, 0, 0);
			
			//increases total amount of linear checks by the current amount of checks
			lTotCheck+=lCheck;
			
			//performs binary search
			System.out.println("Searching using binary search");
			bCheck = binaryCheck(array, aValue, 0, array.length-1, 0);
			
			//increases total amount of binary checks by the current amount of checks
			bTotCheck += bCheck;
			
			System.out.println("Linear Checks: " + lCheck);
			System.out.println("Binary Checks: " + bCheck);
			
			System.out.println();
		}
		bAvg = bTotCheck/20.0;
		lAvg = lTotCheck/20.0;
		System.out.println("The average number of checks for 20 binary and linear searches were:");
		System.out.println("Linear Checks: " + lAvg);
		System.out.println("Binary Checks: " + bAvg);
	}
	//returns a sorted array
	private static int[] initialize()
	{
		for(int i = 0; i< array.length; i++)
		{
			array[i] = RNG.nextInt(2000);
		}
		//selection sort sorts array from least to greatest
		for(int i = 0 ; i<array.length-1; i++)
		{
			int key = i;
			for(int j = i+1; j<array.length-1; j++)
			{
				if(array[j]<array[key])
				{
					key = j;
				}
			}
			if(key!=i){
				int tmp = array[i];
				array[i] = array[key];
				array[key] = tmp;		
			}
		}
		return array;	
	}
	//Linear check takes in an array, the value to search for, the beginning index and 
	private static int linearCheck(int[] a, int value, int index, int checks) {
		if (a[index] == value) {
			System.out.println("Found");
			//returns the amount of checks performed to find the number
			return checks;
		} else {
			index++;
			if (index >= a.length) {
				System.out.println("Not found");
				
				//returns the amount of checks performed
				return ++checks;
			} else {
				//check has been successfully performed, so the amount of checks is increased by one.
				checks++;
				//recursive call
				return linearCheck(a, value, index, checks);
			}
		}
	}

	private static int binaryCheck(int[] a, int value, int minIndex, int maxIndex, int checks) {
		//finds mid point of the array
		int midIndex = (maxIndex + minIndex) / 2;
		
		if (minIndex > maxIndex) {
			System.out.println("Not found");
			return checks;
		}
		if (a[midIndex] == value) {
			System.out.println("Found");
			//returns the amount of checks performed to find the number
			return checks;
		} else {
			if (value > a[midIndex]) {
				//midIndex is incremented by one and used as the minIndex if the value is greater than the value at the current midIndex
				midIndex++;
				return binaryCheck(a, value, midIndex, maxIndex, ++checks);
			} else {
				//midIndex is decreased by one and used as the maxIndex if the value is less than the value at the current midIndex
				midIndex--;
				return binaryCheck(a, value, minIndex, midIndex, ++checks);
			}

		}
	}
}
