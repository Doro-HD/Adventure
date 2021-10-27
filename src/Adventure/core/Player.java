package Adventure.core;

import Adventure.items.Food;
import Adventure.items.Item;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private Room currentRoom;
    private int hp;
    private int startHp;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.setCurrentRoom(startPosition);
        this.inventory = new ArrayList<>();
        this.startHp = 200;
        this.hp = startHp;
    }

    //Returns a boolean to Command that represents if the item was found
    public boolean takeItem(String itemName) {
        Item newItem = this.currentRoom.givePlayerItem(itemName);
        if (newItem != null) {
            this.inventory.add(newItem);
            return true;
        } else {
            return false;
        }
    }

    //Returns a boolean to Command that represents if the item was found
    public boolean dropItem(String itemName) {
        Item item = findItem(itemName);

        if(item != null) {
                this.currentRoom.recievePlayerItem(item);
                this.inventory.remove(item);
                return true;
            }
        else {
            return false;
        }
    }

    private Item findItem(String itemName) {
        for (Item item : this.inventory) {
            if (item.isSameType(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //Sets the players current position to be a new room unless that room is null
    //The argument given in the client code is a reference to another room
    public boolean setCurrentRoom(Room newPlayerPosition) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
            return true;
        }else
            return false;
    }

    //Prints the player's current location
    public void printLocation() {
        System.out.println("You are now in " + this.currentRoom);
    }

    public boolean inventoryIsEmpty() {
        if (this.inventory.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean consumeFood(String name){
        Food item = (Food) findItem(name);
        if(item!=null && item instanceof Food){
            this.setHp(item.getHealingHp());
            return true;
        }else
            return false;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp,startHp);
    }

    public void setStartHp(int startHp) {
        this.startHp = startHp;
    }

    public int getStartHp() {
        return startHp;
    }

    public int getHp() {
        return hp;
    }
}
