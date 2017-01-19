import java.util.Scanner;
public class Lab10 {

	public static Scanner input;
	public static int[] a, b;
	public static int arrayBound;
	public static boolean swap = true;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Please enter the number of values you want to sort.");
		arrayBound = input.nextInt();
		a = new int[arrayBound];
		b = new int[arrayBound];
		
		for(int i=0; i<a.length; i++)
		{
			System.out.println("Please enter the number at " + i);
			a[i] = input.nextInt();
			b[i] = a[i];
		}
		
		for(int i = a.length - 1; i>0; i--)
		{
			int key = a[i];
			int j = i-1;
			
			while(j>0 && a[j]>key)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j] = key;//???
		}
		/*while(swap == true)
		{
			swap = false;
			for(int i = a.length - 1; i>0; i--)
			{
				if(a[i]<a[i-1])
				{
					int temp = a[i];
					a[i] = a[i-1] ;
					a[i-1] = temp;
					swap = true;
				}
			}
		}*/
			
		System.out.println("The unsorted array is");
		for(int i=0; i<a.length; i++)
		{
			System.out.print(b[i] + " ");
		}
		System.out.println("");
		System.out.println("The sorted array is");
		for(int i=0; i<b.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("\nDone");
	}
}
