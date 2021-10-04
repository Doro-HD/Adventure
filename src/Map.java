public class Map {
    private Room startRoom;
    private Room endRoom;

    //Constructor calls method that sets up a 3x3 grid map, later it might be able to set up different maps depending on user input.
    public Map() {
        setup3x3Map();
    }

    //Method for setting up a 3x3 grid map
    //Creates 9 rooms and connects them to one another
    public void setup3x3Map() {
        Room room1 = new Room("test1", "This is test1");
        Room room2 = new Room("test2", "This is test2");
        Room room3 = new Room("test3","This is test3");
        Room room4 = new Room("test4", "This is test4");
        Room room5 = new Room("test5", "This is test5");
        Room room6 = new Room("test6", "This is test6");
        Room room7 = new Room("test7", "This is test7");
        Room room8 = new Room("test8", "This is test8");
        Room room9 = new Room("test9", "This is test9");

        this.setStartRoom(room1);
        this.setEndRoom(room5);

        //Sets the exits to form a 3x3 square grid.
        //When a room's westExit is set, the room set as that exit will automatically add the other room as it's east exit
        //The above comment also applies to north and south exits.
        room2.setHorizontalExits(room1, room3); // room 2 westExit er room1 og dens eastExit er room3
        room4.setVerticalExits(room1, room7); //Sets room4 northExit to room1, and it's southExit to room7
        room6.setVerticalExits(room3, room9); //Sets room6 westExit to room3, and it's eastExit to room9
        room8.setThreeWay(room5, room7, room9); //Sets room8 westExit to room5, it's eastExit to room7, and it's northExit to room9
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public Room getStartRoom() {
        return this.startRoom;
    }

    public void setEndRoom(Room endRoom) {
        this.endRoom = endRoom;
    }

    public Room getEndRoom() {
        return this.endRoom;
    }
}
