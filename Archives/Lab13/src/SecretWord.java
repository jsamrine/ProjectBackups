import java.util.Random;
public class SecretWord {
	
	private int numberOfTurns;
	private String[] secretWords = {"animal", "vegetable", "mineral"};
	private String secretWord,hintWord; 
	private char[] hintWordArray;
	private Random RNG = new Random();
	
	//default constructor
	public SecretWord()
	{
		int i = RNG.nextInt(3);
		this.secretWord = secretWords[i] ;
		hintWordArray = secretWord.toCharArray();
		for(int j = 0; j<secretWord.length(); j++)
		{
			hintWordArray[j] = '*';
		}
		this.hintWord = new String(hintWordArray);
		this.numberOfTurns = 0;
	}
	
	public SecretWord(String aSecretWord, String aHintWord, int aNumberOfTurns)
	{
		this.secretWord = aSecretWord;
		this.hintWord = aHintWord;
		this.numberOfTurns = aNumberOfTurns;
	}
	
	//accessors
	public String getSecretWord()
	{
		return this.secretWord;
	}
	
	public String getHintWord()
	{
		return this.hintWord;
		
	}
	
	public int getNumberOfTurns()
	{
		return this.numberOfTurns;
	}
	
	//mutators
	public void setNumberOfTurns(int aNumberOfTurns)
	{
		if(aNumberOfTurns<0)
		{
			System.out.println("That is not a valid number of turns");
			return;
		}
		this.numberOfTurns=aNumberOfTurns;
					
	}
	
	
	//other Methods
	public void guessLetter(char guess)
	{
		for(int i = 0; i<secretWord.length();i++)
			
			if(guess == secretWord.charAt(i))
				{
					hintWordArray[i]=guess;
				}
	}
}
