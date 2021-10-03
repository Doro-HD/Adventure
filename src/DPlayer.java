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
        this.currentRoom = newPlayerPosition;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
