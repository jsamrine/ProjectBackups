
public class Movie {
	private String movieName, rating, directorName; 
	private int year, boxOfficeGross;
	
	public Movie()
	{
		this.movieName = "Star Wars: A New Hope";
		this.year = 1972;
		this.rating = "*****";
		this.directorName = "George Lucas";
		this.boxOfficeGross = 10000000;
	}
	
	public Movie(String aName, int aYear, String aRating, String aDirector, int aBoxOfficeGross)
	{
		setName(aName);
		setYear(aYear);
		setRating(aRating);
		setDirector(aDirector);
		setGross(aBoxOfficeGross);
	}
	
	public String getName()
	{
		return this.movieName;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public String getRating()
	{
		return this.rating;
	}
	
	public String getDirector()
	{
		return this.directorName;
	}
	
	public int getGross()
	{
		return this.boxOfficeGross;
	}
	
	public void getMovie()
	{
		getName();
		getYear();
		getRating();
		getDirector();
		getGross();
	}
	
	//TODO: Be sure to check for correct input
	public void setName(String aName)
	{
		this.movieName = aName;
	}
	
	public void setYear(int aYear)
	{
		if(aYear>1900)
		{
			this.year = aYear;
		}
		else
		{
			System.out.println("Film wasn't invented then jerk.");
		}
	}
	
	public void setRating(String aRating)
	{
		if(aRating.length()>=1 && aRating.length()<=5)
		{
			this.rating = aRating;
		}
		else
		{
			this.rating = "*";
		}
	}
	
	public void setDirector(String aDirector)
	{
		this.directorName = aDirector;
	}
	
	public void setGross(int aGross)
	{
		if(aGross>0)
		{
			this.boxOfficeGross = aGross;
		}
	}
}
