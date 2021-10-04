public class Player {
    private String name;
    private Room currentRoom;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.setCurrentRoom(startPosition, false);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //Sets the players current position to be a new room unless that room is null
    //The argument given in the client code is a reference to another room
    public void setCurrentRoom(Room newPlayerPosition, boolean printLocation) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
            if (printLocation) {
                this.printLocation();
            }
        } else {
            System.out.println("you cannot go that way");
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
