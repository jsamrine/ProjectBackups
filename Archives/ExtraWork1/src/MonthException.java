
public class MonthException extends Exception
{
	public MonthException()
	{
		super("Month Exception: Months must between 1 and 12 inclusively");
	}
	
	public MonthException(String message)
	{
		super(message);
	}
	
}
