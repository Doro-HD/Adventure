package Adventure.core;

import Adventure.items.Food;
import Adventure.items.Item;
import Adventure.items.Weapon;
import Adventure.util.Status;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int maxHp;
    private Weapon equippedWeapon;
    private ArrayList<Item> inventory;
    private Room currentRoom;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.setCurrentRoom(startPosition);
        this.inventory = new ArrayList<>();
        this.setMaxHp(200);
        this.hp = this.maxHp;
    }

    public String inventoryToString() {
        String itemsString = "";
        for (Item item : this.inventory) {
            itemsString += "\t" + item.toString() + "\n";
        }
        return itemsString;
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
        boolean itemWasDropped;
        Item item = findItem(itemName);

        if (item != null) {
            this.currentRoom.recievePlayerItem(item);
            this.inventory.remove(item);
            itemWasDropped = true;
        } else {
            itemWasDropped = false;
        }
        return itemWasDropped;
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

    //Sets the players current position to be a new room unless that room is null
    //The argument given in the client code is a reference to another room
    public boolean setCurrentRoom(Room newPlayerPosition) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
            return true;
        } else
            return false;
    }

    public boolean inventoryIsEmpty() {
        if (this.inventory.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Status consumeFood(String name) {
        //Finds a food item in the players inventory
        Item item = findItem(name);
        if (item == null) {
            return Status.notFound;
        } else if (!(item instanceof Food)) {
            return Status.notUsable;
        } else {
            return Status.usable;
        }
    }

    public boolean equipWeapon(String weaponType) {
        Item foundWeapon = findItem(weaponType);
        if (foundWeapon instanceof Weapon) {
            this.equippedWeapon = (Weapon) foundWeapon;
            return true;
        }
        return false;
    }


    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }
}
