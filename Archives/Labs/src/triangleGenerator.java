import java.util.Scanner;

public class triangleGenerator {
public static double height, width;
public static Scanner input;
	public static void main(String[] args) {
		System.out.println("Welcome to the Triangulon 9000. This program produces any isoceles Triangle you could imagine! Enter the triangle size.");
		input = new Scanner(System.in);
		width = input.nextDouble();
		height = width*2 - 1;
		for (double i = 0; i < height; i++) 
		{
			if (i <= width)
			{
				for (double k = 0; k < width; k++)
				{
					if(k <= i )
					{
						System.out.print("*");
					}
				}
			
			}
			else if (i >= width)
			{
				for(double j = width - 1; j < width; j--) 
				{
					if( j <= i)
					{
					System.out.print("*");
					}
				}
			
			}
			System.out.println("");
			/*for(double j = width; j > i; j--) 
			{
				if( j >= i)
				System.out.print("*");
			}
			System.out.println("");
			*/
		}
	}
}