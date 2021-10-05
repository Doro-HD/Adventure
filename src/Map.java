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
        Room room1 = new Room("Hangar bay", "This room is huge. It is basically a big platform.\n There is nothing in here, except for the bright light in the ceiling.");
        Room room2 = new Room("Control Room","Straight out of a science fiction movie! This room is filled with computers - all with multiple screens..\nThe screens are flashing red, some displaying multiple error messages. \nThe screen at the captains chair is displaying message that takes up the entire screen, in bright white letters \nMALFUNCTION IN CORE REACTOR!");
        Room room3 = new Room("Cafeteria","White walls. White floor. This room is almost too white and too empty.\n Long tables with chairs are lined up in five rows, but no people to fill the chairs.");
        Room room4 = new Room("Meeting room",  "All around the walls are whiteboards and bulletin boards. In the corner furthest away from the door is a desk. \nAnd in the middle of the room is a large, round table with black leather chairs to surround it.");
        Room room5 = new Room("Core Reactor", "This is test5");
        Room room6 = new Room("Fitness room", "A bunch of treadmills and stationary bikes is lined up in front of the room.\n By the wall, is a shelve with different shapes and sizes of dumbbells. There is also some benches and mats.");
        Room room7 = new Room("Observation deck", "This room is big and empty. The walls are like one big window, where you can look out at space and the millions of stars surrounding you.");
        Room room8 = new Room("Escape pod bay", "Surrounding the room is 8 pod rooms. The 7 empty pod rooms signals that people have already tried to escape the space station.\n Wait, what is that? By the only pod left is.. A body?! A dead body!\n Someone from your crew has died trying to escape.");
        Room room9 = new Room("Sleeping quarters", "Nothing much is in this room besides a bunch of empty bunk beds.\nOn the ground is a couple of bags, probably filled with clothes.");

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
