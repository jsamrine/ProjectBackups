
public class Phobia {
	private String name;
	private String description;
	
	public Phobia()
	{
		this.name = "No Name";
		this.description = "I aint afraid of nothing";
	}
	
	public Phobia(String aName, String aDesc)
	{
		this.name = aName;
		this.description = aDesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString()
	{
		return this.name + ": " + this.description;
	}
	
	public boolean equals(Phobia aPhob)
	{
		return this.name.equals(aPhob.getName())&&this.description.equals(aPhob.getDescription());
	}

}
