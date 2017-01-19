
public class DayException extends Exception
{
	public DayException()
	{
		super("Day Exception: This day is in the wrong range for the month provided.");
	}
	
	public DayException(String message)
	{
		super(message);
	}
}
