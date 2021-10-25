import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private Room currentRoom;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.setCurrentRoom(startPosition, false);
        this.inventory = new ArrayList<>();
    }

    //todo: make sure this method supports the way that the item is written by Nana
    //todo: make that it can send a response to the user interface
    public void takeItem(String itemName) {
        Item newItem = this.currentRoom.givePlayerItem(itemName);
        if (newItem != null) {
            this.inventory.add(newItem);
        }
    }

    //todo: make sure this method supports the way that the item is written by Nana
    //todo: make sure that it can send a response to the user interface
    public void dropItem(String itemName) {
        for (Item item : this.inventory) {
            if (itemName.equals(item.getName())) {
                this.currentRoom.recievePlayerItem(item);
                this.inventory.remove(item);
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCurrentRoom(Room newPlayerPosition, boolean printLocation) {
        this.setCurrentRoom(newPlayerPosition, "", printLocation);
    }

    //Sets the players current position to be a new room unless that room is null
    //The argument given in the client code is a reference to another room
    public void setCurrentRoom(Room newPlayerPosition, String direction, boolean printLocation) {
        if (newPlayerPosition != null) {
            System.out.println("Going " + direction);
            this.currentRoom = newPlayerPosition;
            if (printLocation) {
                this.printLocation();
            }
        } else {
            System.out.println("You cannot go that way!");
        }
    }

    //Prints the player's current location
    public void printLocation() {
        System.out.println("You are now in " + this.currentRoom);
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
