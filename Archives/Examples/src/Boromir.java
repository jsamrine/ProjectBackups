import java.util.Random;
public class Boromir {
	public static Random bRandom, oRandom;
	public static int bHealth, oHealth, bDamage, oDamage, orcs;
	public static void main(String[] args) {
		bHealth = 100;
		oHealth = 30;
		orcs = 0;
		bRandom = new Random();
		oRandom = new Random();
		System.out.println("A horde of orcs are approaching!");
		fight();
		System.out.println("Boromir has slain " + orcs + " orcs.");
	}
	private static void fight(){
		
		while(bHealth > 0)
		{
			bDamage = bRandom.nextInt(10) + 8;
			System.out.println(bDamage);
			oDamage = oRandom.nextInt(5) + 2;
			System.out.println(oDamage);
			bHealth= bHealth-oDamage;
			System.out.println(bHealth);
			oHealth= oHealth-bDamage;
			System.out.println(oHealth);
			if(oHealth < 0)
			{
				
				System.out.println("Boromir has slain an orc!");
				orcs++;
				oHealth = 30;
				fight();
			}
		}

	}

}
