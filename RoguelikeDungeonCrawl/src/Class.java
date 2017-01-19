import java.util.Random;
enum ClassType {Gunner, Doorkicker, Technician, Magos, Grunt};
enum rank {Rookie, etc};
enum skill {
				CQC, Crackshot
				//TODO: Enter skills, would skills best be suited to an enumeration? or would a series of arrays work better
			};

public class Class {
	private Random RNG = new Random();
	private static final int STAT_COUNT = 6;
	private static final int SKILL_COUNT = 2;
	private String playerName;
	private ClassType career;
	private int acu, str, fort, wis, intl, cha;
	private int[] statLine = new int[STAT_COUNT];
	private String[] statNames = new String[STAT_COUNT];
	private skill[] playerSkills = new skill[SKILL_COUNT];

	public Class()
	{
		this.initialize("No name", career.Grunt);
		initializeStats();
		initializeSkills();
	}

	//TODO: Is class initialization correct? Need name, class, stats, weapons

	//accessors
	public String getName()
		{
			return this.playerName;
		}

	public ClassType getType()
		{
			return this.career;
		}


	//mutators
	public void setName(String aName)
		{
			this.initialize(aName, this.career);
		}

	public void setClass(ClassType aType)
		{
			this.initialize(this.playerName, aType);
		}

	private void initialize(String aName, ClassType aType)
	{
		this.playerName = aName;
		this.career = aType;
	}

	private void initializeStats()
	{
		for(int i = 0; i<= STAT_COUNT; i++)
		{
			statLine[i] = (RNG.nextInt(6)+1)+(RNG.nextInt(6)+1)+(RNG.nextInt(6)+1);
			switch (i)
			{
				case 0: statNames[i] = "Strength";
						break;
				case 1: statNames[i] = "Wisdom";
						break;
				case 2: statNames[i] = "Charisma";
						break;
				case 3: statNames[i] = "Intelligence";
						break;
				case 4: statNames[i] = "Fortitude";
						break;
				case 5: statNames[i] = "Acuity";
						break;
				default: statNames[i] = "Ya done goofed";
						break;
			}
		}
	}

	//methods
	private void initializeSkills()
	{
		int skillOne = RNG.nextInt(skill.values().length); //set i to equal to a random number from 0 to number of skills
		selectSkill();
		int skillTwo = RNG.nextInt(skill.values().length);
		while(skillTwo == skillOne)
		{
			skillTwo = RNG.nextInt(skill.values().length);
		}
		selectSkill();
	}

	private void selectSkill()
	{
		for(int i = 0; i <SKILL_COUNT; i++)
		{
			switch (i)
			{
			case 0: playerSkills[i].equals(skill.CQC);
					break;
			case 1: playerSkills[i].equals(skill.Crackshot);
					break;
			}
		}
	}

	private void skillDescription()
	{

	}
}