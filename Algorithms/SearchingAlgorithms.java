
public class SearchingAlgorithms {

	public static void main(String[] args) {
		
	}
	
	public static boolean linearSearchIterative(int[] a, int value)
	{
		for(int i = 0; i <a.length; i++)
		{
			if(a[i] == value)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean linearSearchRecursive(int[] a, int value, int index)
	{
		if(a[index] == value)
		{
			return true;
		}
		else {
			index++;
			if(index>= a.length)
			{
				return false;
			}
			else 
			{
				return linearSearchRecursive(a, value, index);
			}
		}
	}
	
	public static boolean binarySearchRecursive(int[] a, int value, int minIndex, int maxIndex)
	{
		int midIndex = (maxIndex+ minIndex)/2;
		if(minIndex > maxIndex)
		{
			return false;
		}
		if(a[midIndex] == value)
		{
			return true;
		}
		else
		{
			if(value>a[midIndex])
			{
				return binarySearchRecursive(a, value, minIndex++, maxIndex);
			}
			else
			{
				return binarySearchRecursive(a, value, minIndex, midIndex--);
			}
					
		}
	}
//Benchmark testing?
	//Asymptotics
	/*
	 * How do we measure efficiency
	 * Big O
	 * Theoretical upper bound of an algorithm
	 * f(n)=O(g(n)) where n E R as n approaches infinity
	 */

}
