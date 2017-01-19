//Julian Amrine
import java.util.Scanner;

public class lab9 {
	public static int[][] matrix1, matrix2, matrixSum;
	public static int countI, countJ, length, height;
	public static String matrixID;
	public static Scanner input;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Matrix...");
		System.out.println("...calculator.");
		
		input = new Scanner(System.in);
		matrixID = "first";
		//gets dimensions for each array
		for(int i = 0; i<2; i++)
		{
			System.out.println("Please enter the length of the " + matrixID + " matrix");
			length = input.nextInt();
			System.out.println("Please enter the height of the " + matrixID + " matrix");
			height = input.nextInt();
			matrixID = "second";
			if ( i == 0)
			{
				matrix1 = new int[height][length];
			}
			else if (i == 1)
			{
				matrix2 = new int[height][length];
			}
		}
		//Checks to see if the arrays have the same amount of rows
		int colCheck = matrix2.length - matrix1.length;
		if(colCheck>0 || colCheck<0)
		{
			System.out.println("Cannot add these! Dimension mismatch" );
			System.exit(0);
		}
		
		//Checks to see if the arrays have the same amount of columns
		for (int i = 0; i < height; i++)
		{
			int rowCheck = matrix2[i].length - matrix1[i].length;
			if(rowCheck>0 || rowCheck<0)
			{
				System.out.println("Cannot add these! Dimension mismatch" );
				System.exit(0);
			}
		}
		
		//gets values for matrix 1
		for(int i=0; i<matrix1.length; i++)
		{
			for(int j=0; j<matrix1[i].length; j++ )
			{
				countI = i + 1;
				countJ = j+1;
				System.out.println("Please enter a value for matrix 1 space " + countI + ", " + countJ);
				matrix1[i][j] = input.nextInt();
			}
		}
		//gets values for matrix 2
		for(int i=0; i<matrix2.length; i++)
		{
			for(int j=0; j<matrix2[i].length; j++ )
			{
				countI = i + 1;
				countJ = j+1;
				System.out.println("Please enter a value for matrix 2 space " + countI + ", " + countJ);
				matrix2[i][j] = input.nextInt();
			}
		}
		
		
		//Creates sum Matrix
		matrixSum = new int[height][length];
				
		//displays values of matrix 1
		for(int i=0; i<matrixSum.length; i++)
		{
			for(int j=0; j<matrixSum[i].length; j++ )
			{
				System.out.print(matrix1[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("+");
		//displays values of matrix 2
		for(int i=0; i<matrixSum.length; i++)
		{
			for(int j=0; j<matrixSum[i].length; j++ )
			{
				System.out.print(matrix2[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("=");
		//calculates the sum and prints the values of matrixSum
		for(int i=0; i<matrixSum.length; i++)
		{
			for(int j=0; j<matrixSum[i].length; j++ )
			{
				matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(matrixSum[i][j] +" ");
			}
			System.out.println("");
		}
		System.out.println("DONE!!!");
	}
}
