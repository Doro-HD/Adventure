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
    public void takeItem(String itemName) {
        for (int i = 0; i < this.currentRoom.getItems().size(); i++) {
            if (this.currentRoom.getItems().get(i).getName().equals(itemName)) {
                this.inventory.add(this.currentRoom.getItems().get(i));
                this.currentRoom.getItems().remove(i);
                i++;
            }
        }
    }

    //todo: make sure this method supports the way that the item is written by Nana
    public void dropItem(String itemName) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getName().equals(itemName)) {
                this.currentRoom.getItems().add(this.inventory.get(i));
                this.inventory.remove(i);
                i++;
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
}
