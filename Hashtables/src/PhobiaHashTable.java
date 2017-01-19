import java.util.*;
public class PhobiaHashTable {
	ArrayList<Phobia>[] hashTable;
	public PhobiaHashTable()
	{
		this.hashTable = new ArrayList[26];
		for(int i = 0; i< hashTable.length; i++)
		{
			
			this.hashTable[i] = new ArrayList<Phobia>();
		}
	}
	
	public int calculateIndex(Phobia aPhobia)
	{
		char c = aPhobia.getName().toLowerCase().charAt(0);
		
		int index = c - 97;
	
		return index;
	}
	
	public int calculateIndex(String aName)
	{
		char c = aName.toLowerCase().charAt(0);
		
		int index = c - 97;
		
		return index;
	}
	
	public void insert(Phobia aPhobia)
	{
		int index = calculateIndex(aPhobia);
		
		hashTable[index].add(aPhobia);
	}
	
	public void remove(Phobia aPhobia)
	{
		int index = calculateIndex(aPhobia);
		if(hashTable[index].contains(aPhobia))
		{
			System.out.println("Removing");
			hashTable[index].remove(aPhobia);
		}
		else
		{
			System.out.println("Not found");
		}
	}
	
	public Phobia lookUp(String aName)
	{
		int index = calculateIndex(aName);
		for(Phobia p : hashTable[index])
		{
			if(p.getName().equals(aName)){
				return p;
			}
		}
		return null;
	}
	public void printHashTable()
	{
		for(int i = 0; i<hashTable.length; i++)
		{
			for(Phobia p : hashTable[i])
			{
				System.out.println(p.toString());
			}
		}
	}
}
