//Julian Amrine
/*
 * 
 */
import java.util.Scanner;

public class lab4 {

public static String dateInput, monthStr, dayStr, newDate, answer;
public static Scanner date = new Scanner(System.in);
public static boolean yn;

public static int mon, dy, monthInt, dayInt, monLength;
	public static void main(String[] args) {
		requestDate();
		checkDate();
		askForNewDate();
	}
	
	private static void requestDate() {
		System.out.println("Please enter a valid date in the form of month/date");
		
		dateInput = date.nextLine();
		mon = dateInput.indexOf("/"); //stores the index at '/'
		
		monthStr = dateInput.substring(0,mon); //stores the string from 0 to /
		monthInt = Integer.parseInt(monthStr); 
			
		dayStr = dateInput.substring(mon+1);
		dayInt = Integer.parseInt(dayStr);	
	}

	private static void checkDate() {
		if (((monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt==7 || monthInt==8 || monthInt == 10 || monthInt == 12) && (dayInt <= 31)) || (( monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt== 11) && dayInt <=30) || (monthInt == 2 && dayInt<=29)) {
			System.out.println(dateInput + " is a valid date!");
		} else {
			System.out.println(dateInput + " is NOT a valid date!");
		}
	}
	
	private static void askForNewDate() {
		Scanner newDate = new Scanner(System.in);
		System.out.println("Would you like to try a new date?");
		answer = newDate.nextLine().toLowerCase();
		
		if(answer.equals("yes") || answer.equals("y")) {
			requestDate();
			checkDate();
			askForNewDate();
			
		} else if(answer.equals("no") || answer.equals("n")){
			newDate.close();
			date.close();
			System.out.println("Peace out.");
				
		} else {
			System.out.println("Please answer yes or no.");
			askForNewDate();
		}
	}
	
}

