import java.util.Scanner;
public class BoozeDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Let's get a little boozy.");
		System.out.println("Enter the name of the first drink");
		String drink = input.nextLine();
		System.out.println("What's the alcoholic content?");
		double content = input.nextDouble();
		Booze drink1 = new Booze(drink, content);
		System.out.println("Enter the name of the first drink");
		input.nextLine();
		drink = input.nextLine();
		System.out.println("What's the alcoholic content?");
		content = input.nextDouble();
		Booze drink2 = new Booze(drink, content);
		System.out.println("How much does the aspiring drinker weigh?");
		int weight = input.nextInt(); 
		
		double intoxication1 = drink1.intoxicated(drink1,weight);
		double intoxication2 = drink2.intoxicated(drink2, weight);
		System.out.println("It would take " + intoxication1 + "Pabst Blue Hipster beers to become intoxicated");
		
		

	}

}
