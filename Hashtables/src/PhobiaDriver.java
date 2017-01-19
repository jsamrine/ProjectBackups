import java.util.*;

public class PhobiaDriver {

	public static void main(String[] args) {
		PhobiaHashTable table = new PhobiaHashTable();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to your fear hash table ");
		while (true) {
			System.out.println("Enter: \n"

					+ "1. To add a fear \n" + "2. To remove a fear \n" + "3. To look up a fear \n"
					+ "4. Print all fears \n" + "5. Quit");
			int i = input.nextInt();
			input.nextLine();
			String aName, aDesc;
			Phobia p;
			switch (i) {
			case 1:
				System.out.println("Name of the fear:");
				aName = input.nextLine();
				System.out.println("Describe the fear");
				aDesc = input.nextLine();
				p = new Phobia(aName, aDesc);
				table.insert(p);
				break;
			case 2:
				System.out.println("Deleting");
				System.out.println("Name of the fear:");
				aName = input.nextLine();
				System.out.println("Describe the fear");
				aDesc = input.nextLine();
				p = new Phobia(aName, aDesc);
				table.remove(p);
				break;
			case 3:
				System.out.println("Name of the fear: ");
				aName = input.nextLine();
				System.out.println(table.lookUp(aName).toString());
				break;
			case 4:
				table.printHashTable();
				break;
			case 5: 
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("You broke the code famalams");
			}

		}

	}
}
