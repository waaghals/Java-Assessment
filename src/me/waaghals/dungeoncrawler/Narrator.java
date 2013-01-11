package me.waaghals.dungeoncrawler;

import java.util.Random;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author Patrick Berenschot
 * 
 */
public class Narrator {
	private static Narrator instance;

	private Narrator() {
	}

	public static Narrator getInstance() {
		if (instance == null)
			// Call the its own constructor, which it can only do itself.
			instance = new Narrator();
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		// that'll teach 'em
	}

	public void say(String[] text, Object...args) {
		System.out.printf(getRandomString(text), args);
		System.out.println();
	}
	
	public void say(String[] text) {
		System.out.print(getRandomString(text));
		System.out.println();
	}
	
	public void say(String text, Object...args) {
		System.out.printf(text, args);
		System.out.println();
	}
	
	public void say(String text) {
		System.out.print(text);
		System.out.println();
	}
	
	private String getRandomString(String[] strings){
		if(strings.length != 0){
			Random randomGenerator = Constants.generator;
			return  strings[randomGenerator.nextInt(strings.length)];
		}
		return null;
	}

	//I love ram!!!!
	public static final String[] ITEM_NOT_IN_ROOM = {
		"The item %s is not in this room.",
		"Nope, there is no %s here",
		"Are you sure you meant %s?"
	};
	
	public static final String[] ITEM_NOT_IN_BACKPACK = {
		"You don't have a %s.",
		"Can't find a %s in your backpack",
		"Are you sure you meant %s, because you don't have one?"
	};
	
	public static final String[] ITEM_DROPPED = {
		"Dropped %s",
		"Removed %s from backpack",
		"You no longer have a %s in your backpack"
	};
	
	public static final String[] BACKPACK_CONTENT = {
		"You have a %s.",
		"This looks like %s",
		"There is a %s in your backpack",
		"You found a %s somewhere"
	};
	
	public static final String[] ITEMS_IN_ROOM = {
		"There is a %s here.",
		"This looks like a %s don't you think?",
		"We've stumbled upon a %s",
		"Look! a %s."
	};
	
	public static final String[] ITEM_RETRIEVED = {
		"Picked up %s",
		"* Puts %s in backpack"
	};
	
	public static final String[] ITEM_DUPLICATE = {
		"You already have a %s",
		"There already is a %s in you backpack"
	};
	
	public static final String[] BACKPACK_FULL = {
		"Your backpack is full",
		"Could not add %s to your backpack"
	};
	
	public static final String[] BACKPACK_EMPTY= {
		"Your backpack is empty",
		"There is nothing in your backpack",
		"You have air! in your backpack. Sadly you can't use it."
	};
	
	public static final String[] WALKING = {
		"Taking a hike %s",
		"Walking into the %s",
		"Heading %s"
	};
	
	public static final String[] NO_EXIT = {
		"We can't go %s, there is nothing but trees there.",
		"There is a sheer cliff %s of here.",
		"Looks like we can't go there.",
		"There are spiders in the %s, lets NOT go there",
		"Sweet Zombie Jesus! spiders in the %s! I'm not going there"
	};
	
	public static final String[] DIRECTIONS = {
		"We can exit at the %s side",
		"%s from here is a path we could take",
		"We could go %s",
		"There is an exit %s from here"
	};
	
	public static final String[] NOT_RECOGNISED = {
		"Wha?",
		"Say what?",
		"No idea what you want to do. type <help> for a list with valid commands",
		"Only english please"
	};
	
	public static final String[] MISSING_ARGUMENT = {
		"%s what?",
		"You need to type %s <argument>",
		"I did not understand that!",
		"Missing an argument for %s"
	};
	
	public static final String[] NO_ENEMY = {
		"There is no enemy here",
		"No enemy in this room",
		"Can't find any opponents here"
	};
	
	public static final String GAME_INTRO = new StringBuilder()
	.append("Good news, everyone!\n")
    .append("It seem that we've ran out of fuel!\n")
    .append("We need to find some Dark Matter to fuel the our ship.\n")
    .append("Fry, it is your job to find the Dark Matter and bring it back.\n")
    .append("When you've found the Dark Matter and are back at the ship\n")
    .append("then use it, than we'll be able to fly to the next level!\n")
    .append("\nThis envirment looks strange.\n")
    .append("Owh! Fry, remember if you don't know what to do, just type help.")
    .toString();
	
	public static final String LEVEL_COMPLETE = new StringBuilder()
    .append("You've finished this level!")
    .append("Lets fly off into space untill were out of fuel again.")
    .toString();
		
	public static final String GAME_HELP = new StringBuilder()
    .append("Usage: \n")
    .append("go \t<N, E, S or W>\t\tTravel in said direction\n")
    .append("get \t<item>\t\t\tPut <item> in backpack\n")
    .append("use \t<item> \t[argument]\tUse <item>\n")
    .append("pack\t\t\t\tShows what is in your back pack\n")
    .append("look\t\t\t\tTells you what your surrounding look like\n")
    .append("fight\t\t\t\tFight your opponent\n")
    .append("fight \tusing \t<item>\t\tFight your opponent and use <item> as a weapon\n")
    .append("loot\t\t\t\tGrab stuff from your opponent after you killed it\n")
    .append("help\t\t\t\tShows this message\n")
    .append("quit\t\t\t\tStops the game\n")
    .toString();
	
	public static final String IMAGE_SHIP = new StringBuilder()
    .append("                         `. ___\n")
    .append("                        __,' __`.                _..----....____\n")
    .append("            __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'\n")
    .append("      _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'\n")
    .append("    ,'________________                          \\`-._`-','\n")
    .append("     `._              ```````````------...___   '-.._'-:\n")
    .append("        ```--.._      ,.                     ````--...__\\-.\n")
    .append("                `.--. `-`                       ____    |  |`\n")
    .append("                  `. `.                       ,'`````.  ;  ;`\n")
    .append("                    `._`.        __________   `.      \'__/`\n")
    .append("                       `-:._____/______/___/____`.     \\  `\n")
    .append("                                   |       `._    `.    \\\n")
    .append("                                   `._________`-.   `.   `.___\n")
    .append("                                                      `------'`")
    .toString();
	
	public static final String IMAGE_LOGO = new StringBuilder()
    .append("\n   oooooooooooo ooooo     ooo ooooooooooooo ooooo     ooo ooooooooo.         .o.       ooo        ooooo       .o.\n")
    .append("   `888'     `8 `888'     `8' 8'   888   `8 `888'     `8' `888   `Y88.      .888.      `88.       .888'      .888.\n")
    .append("    888          888       8       888       888       8   888   .d88'     .8\"888.      888b     d'888      .8\"888.\n")
    .append("    888oooo8     888       8       888       888       8   888ooo88P'     .8' `888.     8 Y88. .P  888     .8' `888.\n")
    .append("    888    \"     888       8       888       888       8   888`88b.      .88ooo8888.    8  `888'   888    .88ooo8888.\n")
    .append("    888          `88.    .8'       888       `88.    .8'   888  `88b.   .8'     `888.   8    Y     888   .8'     `888.\n")
    .append("   o888o           `o888o'        o888o        `o888o'    o888o  o888o o88o     o8888o o8o        o888o o88o     o8888o\n")
    .append("\n")
    .append("                                         NOW IN ASCII ART")
    .toString();

}
