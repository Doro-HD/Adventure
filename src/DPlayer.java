public class DPlayer {
    private String name;
    private Room currentRoom;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCurrentRoom(Room newPlayerPosition) {
        if (newPlayerPosition != null) {
            this.currentRoom = newPlayerPosition;
        } else {
            System.out.println("you cannot go that way");
        }
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
