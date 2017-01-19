/* Julian Amrine
 * This program takes the player on a CYOA style adventure game
 */
import java.util.Scanner;
public class DorfQuest {
public static String ready, playerInput;
public static int numericPlayerInput, tolerance, strength, chancesOfSuccess;
public static Scanner input;
public static boolean death, townStanding;
	public static void main(String[] args) {
		introduction();
	}
	
	private static void introduction() {
		input = new Scanner(System.in);
		System.out.println("Welcome to DorfQuest");
		System.out.println("Are you ready for adventure?");
		ready = input.nextLine().toLowerCase();
		if (ready.contains("ready") || ready.contains("yes") || ready.contains("yeah")) {
			System.out.println("Prepare for adventure!");
			adventure();
		} else {
			System.out.println("Come back when you're ready."); //end
			return;
		}
	}
	private static void adventure() {
		System.out.println("You are Ironbreaker Ingvar Trollkicker the dwarf. Mighty adventurer, kicker of trolls, and breaker of ferrous materials. Now go! Fame and fortunre await.");
		System.out.println("Currently, you're sitting at the bar. You've heard talk of dangerous trolls plaguing the nearby caves, as well as a horde of goblins approaching from the forest to the south.");
		System.out.println("Do you stay and drink? Fight trolls? Fight goblins? Or none of these?");
		playerInput = input.nextLine().toLowerCase();
		if (playerInput.contains("drink") || playerInput.contains("stay")) {
			adventure1();
		} else if(playerInput.contains("trolls")){
			adventure2();
		} else if(playerInput.contains("goblins")){
			adventure3();
		}else if(playerInput.contains("none")){
			existentialCrisis();
		}
	}
	private static void adventure1() {
		System.out.println("Party time! How many beers do you order?");
		tolerance = 100;
		drinking();
		
		}
	
	private static void drinking() {
		numericPlayerInput=input.nextInt();
		
			if (numericPlayerInput > 100) 
			{
				System.out.println("The bartender gives you a shrewd look, 'Woah! Slow down there Gizur! You may be a dwarf but thats still no reason to practice some self control. Anyways, you dont have enough money!'");
				System.out.println("You'd best try a smaller order");
				drinking();
			} 
			else if (numericPlayerInput <=0) 
			{
				System.out.println("The bartender looks at you in disbelief, 'You're trying to buy beers, not give them away!'");
				System.out.println("You'd best try a larger order");
				drinking();
			}
			else if (numericPlayerInput < 100 && numericPlayerInput > 0 ) 
			{
				tolerance = tolerance - numericPlayerInput;
				System.out.println("You slide the bartender " + numericPlayerInput + " gold pieces. 'Gimme " + numericPlayerInput + " beers.' You drink deeply. This beer is awful.");
				System.out.println("Do you want to drink more?");
				input.nextLine();
				playerInput=input.nextLine().toLowerCase();
				if(playerInput.contains("yes")||playerInput.contains("yeah")||playerInput.contains("y"))
				{
					System.out.println("'An how many more beers would ye be wantin'?");
					drinking();
				} 
				else 
				{
					System.out.println("You decide you've had enough, and get ready to leave.");
				}
			}
			else if (numericPlayerInput == 100)
			{
				System.out.println("That's a lot. Are you sure?");
				input.nextLine();
				playerInput=input.nextLine().toLowerCase();
				if (playerInput.equals("yes")||playerInput.equals("yeah")||playerInput.equals("y"))
				{
					tolerance = tolerance - numericPlayerInput;
					System.out.println("You slide the bartender 100 gold pieces. 'Gimme as many beers as that can buy,' you say. An hour passes, and you drink 100 beers in one sitting. You think you might be sick.");
					System.out.println("The bartender looks at you with concern, 'You doing alright there Gizur?' How do you respond?");
					playerInput=input.nextLine().toLowerCase();
					if (playerInput.contains("great") || playerInput.contains("amazing") || playerInput.contains("awesome")) 
					{
						System.out.println("You manage to rally your senses. The bartender looks at you with astonishment.");
						
					} 
					else 
					{
						System.out.println("You let out one last burp as you pass out at the bar. Maybe you should have paced yourself more.");
						System.out.println("While you sleep the night away, the trolls and the goblins band together and destroy the town. The bar is the first to go, you die a horrible flaming death.");
						death = true;
						townStanding = false;
						gameOver();
					}
				} 
				else 
				{
					System.out.println("Good idea. Try something smaller!");
					drinking();
				}
			}
		
		System.out.println("You've had quite a lot to drink now. You're feeling pretty good.");
		System.out.println("An Orc comes up to you at the bar. \"OI YA RUNT, I IS GORGUTZ 'EADSMASHA AND I CHALLENGE YOUZ TO A DRINKING CONTEST!\" The bar is absolutely silent. How do you reply?"); // If declined, the ork will fight the player, if not, the orc and the player go out on the town and destroy it in a drunken rampage
		System.out.println("Dialogue Choices: (please choose A or B)");
		System.out.println("A: OH YER ON YEH GREAT GREEN BEASTIE!");
		System.out.println("B: AN WHY WOULD AH BE WANTIN' TO PARTICIPATE IN A DRINKIN' CONTEST WITH THE LIKES OF YEH?!");
		playerInput=input.nextLine().toLowerCase();
		if (playerInput.contains("a")) 
		{
			System.out.println("You agree to a drinking game! Do you think you're up to the task? (Yes or No)");
			drinkingGame();
		}
		else if (playerInput.contains("b")) 
		{
			System.out.println("You've gravely offended the orc. He screws up his face in rage and belows, \"NO ONE REFUSES A DRINKIN' CONTEST WITH GORGUTZ 'EADSMASHA!\" He cracks his knuckles and approaches you, fists raised.");
			System.out.println("Action Choices: (please choose A or B)");
			System.out.println("A: Punch him in the face!");
			System.out.println("B: Sing him the song of your people");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a")) 
			{
				System.out.println("A crowd has circled around the two of you, chanting your name. You raise your fists at just the right time to block Gorgutz' first punch. You dance around him, throwing in jabs, left hooks, right hooks, and finally landing a vicious uppercut that knocks the orc out.");
				System.out.println("With the orc menace defeated, the tavern crowd cheers as they toss the unconscious Gorgutz out into the cold night.");
				System.out.println("Drunk off victory and cheap tavern beer, you buy several rounds for everyone at the bar. The night wears on, most people leave or pass out at the bar.");
				System.out.println("The trolls and the goblins band together and attack the town. The bar is the first to go, you die a drunken, flaming death.");
				death = true;
				townStanding = false;
				gameOver();
			}
			else if (playerInput.contains("b")) 
			{
				System.out.println("You open your mouth and begin to sing the orc the song of your people. You sing so beautifully the Orc falls to his knees in awe.");
				System.out.println("\"DAT WUZ BOOTIFUL. IZ SORRY I TRIED PICKIN' A FIGHT WITH YER.\" The orc buys you a drink and the two of you talk about your own cultural heritages. You each talk about how misunderstood your races are and become fast friends.");
				System.out.println("\"HAH, YOU DWARVES AINT SO BAD. ME AN A FEW OF ME BOYS WUZ GONNA BURN DIS TOWN TO DA GROUND! BUT NOW I THINKS WE'Z GONNA MOVE ON TO DA NEXT TOWN AND SEE WOT THEY GOT.\"");
				System.out.println("sysoutApparently, the goblin army heading towards the town was under this Orc's leadership! The trolls descend from the caves in the dead of night, but the town is prepared! The trolls are driven off howling by the goblin army.");
				System.out.println("The morning comes and you and the orc part as friends, eager to meet each other once again.");
				death = false;
				townStanding = true;
				gameOver();
				
			}
		}
	}
	private static void drinkingGame() {
		playerInput=input.nextLine().toLowerCase();
		if(playerInput.contains("yes"))
		{
			System.out.println("You drink and you drink some more, until atlast Gorgutz throws his hands up in defeat. \"YOU *BUUUUUURP* WIN. I GIVES UP!");
			System.out.println("Finishing the last of your glass you clap the orc over the shoulders, \"AYE YE GREEN BEASTIE, THAT WAS THE BEST DRINKIN' I'VE SEEN IN ALL MY YEARS! ANY BEAST THAT CAN DRINK LIKE THAT IS A FRIEND OF MINE!\"");
			System.out.println("You two become fast friends, and have a few more drinks before leaving. In a drunken haze, the two of you ransack the entire town, until only scarred rubble remains.");
			death = false;
			townStanding = false;
			gameOver();
		}
		else if (playerInput.contains("no"))
		{
			System.out.println("The drinking goes on for hours, and you make a damn good show of it. But the smell of the beer becomes too great for you, and you retch then pass out at your table.");
			System.out.println("\"YER PUNY PROTECTOR ISNT 'ERE TO SAVE YOUS! ME BOYS AN I IZ GONNA MAKE DIS TOWN OURS!\" the orc bellows to the crowd. The bar erupts in flames as the goblins waiting outside toss torches onto the building. You die a drunken, fiery death.");
			death = true;
			townStanding = false;
			gameOver();
		}
	}
	
	private static void adventure2() {
		chancesOfSuccess = 0;
		System.out.println("You decide to go kick some Trolls. Adventure!");
		System.out.println("Now were those trolls in the forest or the cave?");
		playerInput=input.nextLine().toLowerCase();
		if(playerInput.contains("forest"))
		{
			System.out.println("You walk into the horde of vicious goblins. Too late you realize your mistake, and as the goblins stab you to death, you curse your short memory.");
			System.out.println("Without a protector, the town falls easily to the combined efforts of the trolls and the goblins.");
			death = true;
			townStanding = false;
			gameOver();
		}
		else if(playerInput.contains("cave"))
		{
			System.out.println("You pay your tab at the bar, and strike out for the caves.");
			System.out.println("How strong are you feeling today?");
			System.out.println("A: SUPER STRONG!!!");
			System.out.println("B: Very strong!");
			System.out.println("C: Strong.");
			System.out.println("D: Eh.");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a"))
			{
				chancesOfSuccess = chancesOfSuccess + 3;
			} 
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 2;
			}
			else if (playerInput.contains("c"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
			}
			else if (playerInput.contains("d"))
			{
				chancesOfSuccess = chancesOfSuccess + 0;
			}
			System.out.println("As you leave the town, an elf approaches you. \"Excuse me, but you're Gizur Trollkicker arent you?! I've heard so much about you. I'm Felix the Bard, and I'm damn good with a bow. You're going after those trolls in the caves arent you? Could I come?\"");
			System.out.println("Dialogue Choices: (please choose A or B)");
			System.out.println("A: \"AN WHAT MAKES YE THINK I NEED THE HELP OF A STINKIN', POINTY EARED ELF?!\"");
			System.out.println("B: \"I COULD USE A BARD TO GET ME STORY OUT IN THE WORLD, COME ALONG WITH ME LADDIE\"");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a"))
			{
				chancesOfSuccess = chancesOfSuccess + 0;
				System.out.println("The elf gives you a look of disgust, \"Well, there's no need to be rude!\" The elf stomps off in a huff.");
			} 
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
				System.out.println("The elf looks you in the eye, \"I won't let you down, you have my bow!\"");
			}
			System.out.println("You continue on your way, the town gives way to the rolling countryside, which in turn gives way to the craggy foothills of the mountains");
			System.out.println("It is around nightfall when you hear the trolls, they seem to be seated around a large campfire, and cooking what looks like fourteen small objects. What do you do?");
			System.out.println("Action Choices: (please choose A, B, or C)");
			System.out.println("A: Charge into battle! These trolls dont stand a chance.");
			System.out.println("B: It would be best to lie in wait and ambush these trolls if they make a mistake!");
			System.out.println("C: Make friends with them!");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a")) 
			{
				chancesOfSuccess = chancesOfSuccess + 0;
				System.out.println("CHARGE! You rush into battle axe raised, belowing a terrible battle cry. You become a blur of steel and many a troll flees in terror before you.");
			}
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
				System.out.println("You sneak around the troll encampment, and hide in a clump of bushes waiting. When one of the trolls leaves the encampment, you leap out of the bush and lop the head off the nearest troll!");
			}
			else if (playerInput.contains("c"))
			{
				System.out.println("In a fit of madness, you walk into the clearing and wave at the trolls, \"OI LADS! ME NAME'S GIZUR TROLLKICKER, WOULD YE LIKE TO BE MAH FRIENDS?!\"");
				System.out.println("The trolls stare at you and look at each other in disbelief. They beckon you over, and you foolishly approach. A troll comes out of peripherals and tosses a bag over your head.");
				System.out.println("The trolls sit on you, cook you and then eat you. Without a protector, the town falls easily to the combined efforts of the trolls and the goblins.");
				death = true;
				townStanding = false;
				gameOver();
			}
			
			if (chancesOfSuccess >= 3) 
			{
				System.out.println("The last troll falls to your mighty blow. You are victorious! You pull your axe out of the deceased troll's skull and peek into their cave.");
				System.out.println("Inside you find untold riches and mysterious trinkets. You've hit the mother lode! Maybe you can finally retire. You decide to camp out here until morning.  \n When dawn comes, you set out for home, with your pack full of loot, and a pep in your step.");
				System.out.println("However, you find that town has been razed by the goblin marauders sometime in the night! You leave as quickly as you can, bereft of home and laden with your fortune.");
				death = false;
				townStanding = false;
				gameOver();
			} 
			else if(chancesOfSuccess <= 3)
			{
				System.out.println("You fight bravely, and kick many trolls, but you were ill prepapred and are soon overwhelmed by the trolls.");
				System.out.println("You fell one last troll before you collapse. The trolls kill you and toss you up to roast next to the other objects above the fire. \n Without a protector, the town falls easily to the combined efforts of the trolls and the goblins.");
				
				death = true;
				townStanding = false;
				gameOver();
			}
		}
	}
	
	private static void adventure3() {
		System.out.println("You bravely decide to fight off the goblin horde approaching the town.");
		chancesOfSuccess = 0;
		System.out.println("Now were those goblins in the forest or the cave?");
		playerInput=input.nextLine().toLowerCase();
		if(playerInput.contains("cave"))
		{
			System.out.println("You walk into a troll encampment. Too late you realize your mistake, and as the trolls crush you and prepare you for dinner, you curse your short memory.");
			System.out.println("Without a protector, the town falls easily to the combined efforts of the trolls and the goblins.");
			death = true;
			townStanding = false;
			gameOver();
		}
		else if(playerInput.contains("forest"))
		{
			System.out.println("You pay your tab at the bar, and strike out for the forest.");
			System.out.println("How strong are you feeling today?");
			System.out.println("A: SUPER STRONG!!!");
			System.out.println("B: Very strong!");
			System.out.println("C: Strong.");
			System.out.println("D: Eh.");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a"))
			{
				chancesOfSuccess = chancesOfSuccess + 3;
			} 
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 2;
			}
			else if (playerInput.contains("c"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
			}
			else if (playerInput.contains("d"))
			{
				chancesOfSuccess = chancesOfSuccess + 0;
			}
			
			System.out.println("Are you feeling brave? (Yes or No)");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("yes"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
			}
			else if (playerInput.contains("no"))
			{
				chancesOfSuccess = chancesOfSuccess + 0;
			}
			
			playerInput=input.nextLine().toLowerCase();
			System.out.println("As you leave the town, you run across a mob of about 30 stinking, angry peasants. One looks at you and asks, \"Master Dwarf, we was wonderin' if youd teach us how to fight");
			System.out.println("Dialogue Choices: (please choose A or B)");
			System.out.println("A: \"YE ALL STINK! WHY WOULD I WANT A BUNCHA NO GOOD LAZY PEASANTS AROUND ME? YER STINK WOULD ALERT THE GOBLINS WE WERE COMIN MILES BEFORE WE EVEN SAW THEM. NOW GO BEFORE I GET SICK OF YE!\"");
			System.out.println("B: \"YER ALL A BUNCHA STINKY PEASANTS, BUT YE GOT SPIRIT! I COULD TEACH YOU THE WAYS O' BEIN' A STINKY DWARF! STICK WITH ME AN I'LL SHOW YA HOW WE TAKE CARE OF GOBLINS\"");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a"))
			{
				chancesOfSuccess = chancesOfSuccess + 0;
				System.out.println("The peasants look at you with shock, utterly flabbergasted. A few moments pass, and the mob scatters.");
			} 
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
				System.out.println("The peasants let out a loud cheer, and you spend a few hours teaching them in the ways of Dwarfery.");
			}
			System.out.println("You continue on your way, the town gives way to the rolling countryside, which in turn gives way to the misty forest");
			System.out.println("It is around nightfall when you see smoke on the horizon. That must be the goblin camp! What do you do?");
			System.out.println("Action Choices: (please choose A, B, or C");
			System.out.println("A: Charge into battle! These spineless goblins dont stand a chance.");
			System.out.println("B: It would be best to hide and wait for these goblins to make some mistake!");
			System.out.println("C: Offer a truce with the goblins!");
			playerInput=input.nextLine().toLowerCase();
			if (playerInput.contains("a")) 
			{
				chancesOfSuccess = chancesOfSuccess + 0;
				System.out.println("CHARGE! You rush into battle axe raised, belowing a terrible battle cry. You become a blur of steel and as you cut down wave after wave of goblins.");
			}
			else if (playerInput.contains("b"))
			{
				chancesOfSuccess = chancesOfSuccess + 1;
				System.out.println("You sneak around the goblin encampment, and hide in a clump of bushes waiting. When one of the trolls leaves the encampment, you leap out of the bush and kill a handful of goblins with one mighty sweep. \n The surrounding goblins let out a shriek of fear as they take in your frightening appearance. ");
			}
			else if (playerInput.contains("c"))
			{
				System.out.println("You go to treat with the goblins, waving the white flag of peace.");
				gameOver();
			}
			
			if (chancesOfSuccess >= 4) 
			{
				System.out.println("You fight well and true! Your trusty axe has claimed the lives of many goblins. But the victory has come at a great cost. You sit and ponder the monumentous loss of life until morning.");
				System.out.println("At dawn you conclude that any loss of life is lamentable, but the ends justify the means. \n You return to the village, only to find that it has been destroyed by trolls! You leave behind the smoking ruin, starting a new life as a priest, preaching nonviolence and tolerance");
				death = false;
				townStanding = false;
				gameOver();
			} 
			else if(chancesOfSuccess <= 4)
			{
				System.out.println("You cleave great holes within the goblin ranks, but their numbers seem without end. You collapse from exhaustion and you die a horrible death, stabbed by many ugly goblins.");
				death = true;
				townStanding = false;
				gameOver();
			}
		}
	}
	
	private static void existentialCrisis() {
		System.out.println("You realize the life of an adventurer is not for you. You return home to confront your father, who pressured you into adventuring in the first place!");
		System.out.println("You stand outside your house. Do you GO IN and face your father or LEAVE");
		playerInput=input.nextLine().toLowerCase();
		if(playerInput.contains("go")||playerInput.contains("in"))
		{
		System.out.println("You come home to find your dad sitting on the couch, watching his shows at an unbearable volume! /n \"PA! I NEVER WANTED TO BE AN ADVENTURER! I WAS MADE TO CREATE NOT DESTROY!");
		System.out.println("Your father turns around, looking you sternly in the eye, \"YE'D BETTER NOT TAKE THAT TONE AGAIN WITH ME LADDIE, I'LL WHIP YE SEVEN WAYS FROM TYRSDAE.");
		System.out.println("\"YE CANNOT MAKE ME DO ANYTHIN' PA! I'M GONNA BECOME THA GREATEST SCUPLTURE ARTIST THIS WORLD HAS SEEN!\" You throw your axe down at your feet, and stomp out of the house, intent on fulfilling your passion as a sculptor.");
		System.out.println("You find a studio and a block of marble that night! Do have any idea about what you're doing?!");
		playerInput=input.nextLine().toLowerCase();
			if(playerInput.contains("sure")||playerInput.contains("yeah")||playerInput.contains("yes"))
			{
				System.out.println("You work hard, and when dawn comes you think you've got a good foundation for your sculpture. \n Unfortunately, the town has no protector, and is attacked by goblins and trolls! They burn down your studio, and you die for your art. Such is life as an artist.");
				death = true;
				townStanding = false;
				gameOver();
			}
			else if(playerInput.contains("maybe")||playerInput.contains("no")||playerInput.contains("nah"))
			{
				System.out.println("Marble sculpting is a lot harder than it looks. You end up with a lot dust. \n Unfortunately, the town has no protector, and is attacked by goblins and trolls! They burn down your studio, and you die for your art, penniless and unknown. Such is life as an artist. ");
				death = true;
				townStanding = false;
				gameOver();
			}
			} 
		else if (playerInput.contains("leave"))
		{
			System.out.println("Yeah, your dad is a lot scarier than trolls or dragons. Lets go back to adventuring!");
			adventure();
		}
	}
	
	private static void gameOver() {
		if (death == true) {
			System.out.println("You seem to have died. So sorry about that."); 
		} 
		else if (death == false && townStanding == false) 
		{
			System.out.println("You win! Sort of. The town was destroyed, but atleast you have your health!");
		} 
		else if (death == false && townStanding == true) 
		{
			System.out.println("Congratulations, you've beaten the game! You've learned the true value of friendship, and that violence is not always the answer.");
		}
		System.out.println("Would you like to play again?");
		playerInput=input.nextLine().toLowerCase();
		if (playerInput.contains("yes")||playerInput.contains("yeah")||playerInput.contains("y")) 
		{
			adventure();
		} 
		else 
		{
			System.out.println("I hope you enjoyed the game! Until we meet again!");
			System.exit(0);
		}
	}
}
		