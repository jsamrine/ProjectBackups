import java.util.Scanner;
public class PlayerParser {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Player stuff"); //check online for more in depth info
		String input = keyboard.nextLine();
		String copyInput = input;
		int workingIndex = copyInput.indexOf(" ");
		String name = copyInput.substring(0, workingIndex);
		copyInput = copyInput.substring(workingIndex+1);
		
		workingIndex = copyInput.indexOf(" ");
		String sModelId = copyInput.substring(0, workingIndex);
		int ModelID = Integer.parseInt(sModelId); //converts strings to integer values
		copyInput = copyInput.substring(workingIndex+1);
		
		//double.ParseDouble();
		
		System.out.println("Hello" + name);
		
		
		

	}

}
