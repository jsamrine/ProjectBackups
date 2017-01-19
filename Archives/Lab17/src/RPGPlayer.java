import java.io.*;
import java.util.Scanner;
public class RPGPlayer {
	private static String name, weapon;
	private static int hp, strength;
	private static double speed;
	private static final String delim = "/t";
	
	public RPGPlayer()
	{
		setName("Nameless");
		setHP(10);
		setStrength(1);
		setSpeed(1);
		setWeapon("Broken Dagger");
		
	}
	
	public RPGPlayer(String aName, int aHP, int aStrength, double aSpeed, String aWeapon)
	{
		setName(aName);
		setHP(aHP);
		setStrength(aStrength);
		setSpeed(aSpeed);
		setWeapon(aWeapon);
	}
	
	public RPGPlayer(String fileName)
	{
		readPlayerFile(fileName);
		
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	
	public int getHP()
	{
		return this.hp;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	public String getWeapon()
	{
		return this.weapon;
	}
	
	
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	public void setHP(int aHP)
	{
		this.hp = aHP;
	}
	
	public void setStrength(int aStrength)
	{
		this.strength = aStrength;
	}
	
	public void setSpeed(double aSpeed)
	{
		this.speed = aSpeed;
	}
	
	public void setWeapon(String aWeapon)
	{
		this.weapon = aWeapon;
	}
	
	//methods
	
	public static void writePlayerFile(RPGPlayer player, String fileName, boolean append)
	{
		try
		{
			PrintWriter fileWrite = new PrintWriter(new FileOutputStream(fileName), append);
			//indicate player #?

			fileWrite.println("Name" + delim + player.getName());
			fileWrite.println("HP" + delim + player.getHP());
			fileWrite.println("Strength" + delim + player.getStrength());
			fileWrite.println("Speed" + delim + player.getSpeed());
			fileWrite.println("Weapon" + delim + player.getWeapon());
			fileWrite.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static RPGPlayer readPlayerFile(String fileName)
	{
		if(fileName==null)
		{
			return null;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine = fileScanner.nextLine();
			String[] splitLines = fileLine.split(delim);
			RPGPlayer player = null;
			while(fileScanner.hasNext())
			{
				fileLine = fileScanner.nextLine();
				splitLines = fileLine.split(delim);
				player = new RPGPlayer(name, hp, strength, speed, weapon);
			}
			fileScanner.close();
			return player;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void printInfo()
	{
		
	}
}
