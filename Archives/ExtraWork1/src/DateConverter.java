import java.util.Scanner;

public class DateConverter {
	private static String dateString = "";

	public static void main(String[] args) {
		try {
			
			convertDates();
			
		} catch (DayException e) {
			System.out.println(e.getMessage());
		} catch (MonthException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void convertDates() throws DayException, MonthException {

		boolean dayCheck = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a numeric date formatted as month/day or \"Exit\" to quit.");
		while (dayCheck == false) 
		{
			String date = input.nextLine();
			if(date.equalsIgnoreCase("Exit"))
			{
				System.out.println("Mad props to the hood yo.");
				System.exit(0);
			}
			String[] aDate = date.split("/");
			int month = Integer.parseInt(aDate[0]);
			int day = Integer.parseInt(aDate[1]);
			String monthString;

			switch (month) {
			case 1:
				monthString = "January";
				break;
			case 2:
				monthString = "February";
				break;
			case 3:
				monthString = "March";
				break;
			case 4:
				monthString = "April";
				break;
			case 5:
				monthString = "May";
				break;
			case 6:
				monthString = "June";
				break;
			case 7:
				monthString = "July";
				break;
			case 8:
				monthString = "August";
				break;
			case 9:
				monthString = "September";
				break;
			case 10:
				monthString = "October";
				break;
			case 11:
				monthString = "November";
				break;
			case 12:
				monthString = "Decemeber";
				break;
			default:
				throw new MonthException();
			}

			if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
					&& (day <= 31)) || ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)
					|| (month == 2 && day <= 29) && day > 0) 
			{
				dateString = day + " " + monthString;
				break;	
			}
			else 
			{
				throw new DayException();
			}
		}
		input.close();
		System.out.println("The date is " + dateString);	

		}
	}

