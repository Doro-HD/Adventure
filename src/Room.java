public class Room {
    /*private String name;

    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String name) {
        this.setName(name);
    }

    public void printExits() {
        System.out.println("North exit is: " + this.northExit);
        System.out.println("South exit is: " + this.southExit);
        System.out.println("West exit is: " + this.westExit);
        System.out.println("East exit is: " + this.eastExit);
    }

    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNorthExit(Room room) {
        this.northExit = room;

        if (room.southExit == null) {
            room.setSouthExit(this);
        }
    }

    public Room getNorthExit() {
        return this.northExit;
    }

    public void setSouthExit(Room room) {
        this.southExit = room;

        room.setNorthExit(this);
    }

    public Room getSouthExit() {
        return this.southExit;
    }

    public void setWestExit(Room room) {
        this.westExit = room;

        if (room.eastExit == null) {
            room.setEastExit(this);
        }
    }

    public Room getWestExit() {
        return this.westExit;
    }

    public void setEastExit(Room room) {
        this.eastExit = room;

        if (room.westExit == null) {
            room.setWestExit(this);
        }
    }

    public Room getEastExit() {
        return this.eastExit;
    }

    public void setVerticalExits(Room northExit, Room southExit) {
        this.setNorthExit(northExit);
        this.setSouthExit(southExit);
    }

    public void setHorizontalExits(Room westExit, Room eastExit) {
        this.setEastExit(eastExit);
        this.setWestExit(westExit);
    }

    public void setThreeWay(Room northExit, Room westExit, Room eastExit) {
        this.setNorthExit(northExit);
        this.setWestExit(westExit);
        this.setEastExit(eastExit);
    }*/
}
