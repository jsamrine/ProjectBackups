
public class test {
	
	public static void main(String[] args) {
	
	int x = 3;
	
	for(int i = 1; i<= 7; i++)
	{
		if(i<=4)
		{
			for(int j = 1; j<=i ;j++)
			{
				System.out.printf("*");
			}
			System.out.println("");
		}
		

		if(i<=4)
		{
			for(int j = x; j>0;j++)
			{
				System.out.printf("*");
			}
			x--;
			System.out.println("");
		}
	}
}
}

