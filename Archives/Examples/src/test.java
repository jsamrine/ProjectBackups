import java.util.Random;
public class test {

	public static void main(String[] args) {
		int[]  a= {1,2,3,4,5};
		int sum = 0;
		for (int i = 0; i<a.length;i++)
		{
			sum+=a[i];
		}
		
		double average = sum/a.length;
		
		int last = a[a.length-1];
		System.out.println(average);
		System.out.println(last);

	}

}
