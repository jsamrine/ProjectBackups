
public class Booze {
public String name;
public double alcContent;
	public Booze()
	{
		this.name = "No Name";
		this.alcContent = 0.0;
	}
	
	public Booze(String aName, double anAlcContent)
	{
		setName(aName);
		setAlcContent(anAlcContent);
	}
	
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	public void setAlcContent(double anAlcContent)
	{
		if(anAlcContent>0.0 && anAlcContent <1.0)
		{
			this.alcContent = anAlcContent;
		}
		else
		{
			System.out.println("Please enter an alcohol content between 0 and 1");
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getAlcContent()
	{
		return this.alcContent;
	}
	
	public double intoxicated(Booze aBooze, int aWeight)
	{
		double drinks = (0.08 + 0.015)*aWeight / (12*7.5*aBooze.getAlcContent());
		return drinks;
	}
}
