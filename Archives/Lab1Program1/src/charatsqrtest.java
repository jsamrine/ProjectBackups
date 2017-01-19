import java.util.Scanner;
public class charatsqrtest {

	public static void main(String[] args) {
		
		Scanner binaryConversion = new Scanner(System.in);
		String i = binaryConversion.nextLine();
		int result = i.charAt(0)^1 + i.charAt(1)^2;
		
		System.out.println(result);

	}

}
