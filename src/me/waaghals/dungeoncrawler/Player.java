package me.waaghals.dungeoncrawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import me.waaghals.dungeoncrawler.items.Fists;
import me.waaghals.dungeoncrawler.items.Item;

/**
 * @author Patrick Berenschot
 * 
 */
public class Player {

	public static final int BACKPACK_SIZE = 10;

	private HashMap<String, Item> backpack = new HashMap<String, Item>();
	private Room currRoom; // The room the user is in
	private Narrator farnsworth = Narrator.getInstance();
	private int health = 100;

	/**
	 * Returns an Item if backpack holds it else returns null.
	 * 
	 * @param itemName
	 * @return Item if backpack holds it
	 */
	public Item get(String itemName) {
		if (backpack.containsKey(itemName)) {
			return backpack.get(itemName);
		}
		return null;
	}

	/**
	 * Tells the contents of the backpack
	 * 
	 */
	public void showBackpack() {
		if(backpack.size() == 0){
			farnsworth.say(Narrator.BACKPACK_EMPTY);
			return;
		}
		int i = 0;
		for (Entry<String, Item> item : backpack.entrySet()) {
			// item key is the itemName
			farnsworth.say(Narrator.BACKPACK_CONTENT, item.getKey());

			// Add a comma between sentences
			if (i > 0 && i < backpack.size()) {
				farnsworth.say(", ");

				// In the last place add " and "
			} else if (i == backpack.size()) {
				farnsworth.say(" and ");
			}
		}
	}

	/**
	 * Add new item to the users backpack
	 * 
	 * @param item
	 * @return true if user can use item now, otherwise false
	 */
	public boolean add(Item item) {
		if (backpack.size() < BACKPACK_SIZE) {
			if(get(item.getName()) != null){
				farnsworth.say(Narrator.ITEM_DUPLICATE, item.getName());
				return true;
			}
			backpack.put(item.getName(), item);
			farnsworth.say(Narrator.ITEM_RETRIEVED, item.getName());
			return true;
		}
		farnsworth.say(Narrator.BACKPACK_FULL, item.getName());
		return false;
	}

	/**
	 * Remove an item with itemName from the users backpack
	 * 
	 * @param itemName
	 * @return Item which was removed else null
	 */
	public Item drop(String itemName) {
		if (backpack.containsKey(itemName)) {
			Item tempItem = backpack.get(itemName);
			backpack.remove(itemName);
			// TODO say it is dropped
			return tempItem;
		}
		// TODO say nothing to drop
		return null;
	}

	public void use(String itemName) {
		Item item = get(itemName);
		if (item != null) {
			item.use();
		} else {
			farnsworth.say(Narrator.ITEM_NOT_IN_BACKPACK, itemName);
		}
	}

	public void use(String itemName, String argument) {
		Item item = get(itemName);
		if (item != null) {
			item.use(argument);
		} else {
			farnsworth.say(Narrator.ITEM_NOT_IN_BACKPACK, itemName);
		}
	}

	public int fight(String itemName) {
		Item currItem = backpack.get(itemName);
		if(currItem != null){
			return currItem.fight();
		}
		
		//If the item does not exist fight with the fists
		return fight();
	}

	public int fight() {
		// Fight using the players "fists"
		Item fists = new Fists();
		return fists.fight();
	}

	/**
	 * Move a player to a new room
	 * 
	 * @param direction
	 * @return boolean
	 * @throws Exception 
	 */
	public void move(int direction) {
		
		//double check that there is a room there.
		if (currRoom.hasExit(direction)) {
			setCurrRoom(currRoom.getAdjacentRoom(direction));
		}
	}

	public Room getCurrRoom() {
		return currRoom;

	}

	/**
	 * Place the user in a new room
	 * 
	 * @param newRoom
	 */
	public void setCurrRoom(Room curRoom) {
		this.currRoom = curRoom;

		// return the entryText for the new room so it can be spoken
		curRoom.sayEntryText();
	}

	public void setHealth(int health) {
		if (health > 100) {
			health = 100;
		}
		this.health = health;
	}
	
	/*
	 * Empty the players backpack
	 * 
	 */
	public void emptyBackpack(){
		backpack.clear();
	}

	public void damage(int diff){
		health = health - diff;
	}
	
	/**
	 * 
	 * @return true if Player is alive else false
	 */
	public boolean isAlive(){
		return health > 0;
	}
}
