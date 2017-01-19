//all sheep are comparable based on weight
public class Sheep implements Comparable<Sheep>{
	private double weight;
	private String name;
	//default constructor
	public Sheep()
	{
		this.name = "Bahh";
		this.weight = 0.0;
	}
	
	//parameterized, accepting a string and weight
	public Sheep(String aName, double aWeight)
	{
		this.setName(aName);
		this.setWeight(aWeight);
	}
	
	//generic getters and setters
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//compares one sheep to another based on weight
	public int compareTo(Sheep aSheep)
	{
		
		return Double.compare(this.weight, aSheep.getWeight());
	}
	
	//prints sheep info
	public String toString()
	{
		return this.getName() +" weighs "+ this.getWeight() +" pounds ";
	
	}
}

/*

"			             _.-..
"                      ,'9 )\)`-.,.--. 
"                      `-.|           `.\ 
"                         \ ,     ,   \ )\ +
"                          `.  )._\\   (\ 
"                            |//   `-,/
"                            ]||    /\" 
"                            ""     "";
 */