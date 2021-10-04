public class Player {
    private String name;
    private Room currentRoom;

    public Player(String name, Room startPosition) {
        this.setName(name);
        this.currentRoom = startPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCurrentRoom(Room newPlayerPosition) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
            System.out.println("Your are now in " + this.currentRoom);
        } else {
            System.out.println("you cannot go that way");
        }
    }

    public void printLocation() {
        System.out.println("You are now in " + this.currentRoom);
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
