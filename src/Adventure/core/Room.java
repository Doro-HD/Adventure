package Adventure.core;

import Adventure.items.Item;

import java.util.ArrayList;

public class Room {

    private String name;
    private String description;
    private ArrayList<Item> items;

    //Each exit is either a reference to another room or is null
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String name, String description) {
        this.setName(name);
        this.setDescription(description);
        this.items = new ArrayList<>();
    }

    public String itemsToString() {
        String itemsString = "";
        for (Item item : this.items) {
            itemsString += item.toString() + "\n";
        }
        return itemsString;
    }

    public String toString() {
        return "the " + this.name + "\n" +
                this.description + "\n" +
                this.itemsToString();
    }

    public Item givePlayerItem(String itemName) {
        Item playerItem = this.findItem(itemName);
        this.items.remove(playerItem);

        return playerItem;
    }

    public void recievePlayerItem(Item item) {
        this.items.add(item);
    }

    public Item findItem(String itemName) {
        for (Item item : this.items) {
            if (item.isSameType(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addToItems(Item item) {
        this.items.add(item);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Each method that sets a room exit checks if the room parameters opposite exit, north and south, east and west, is null
    //If the room parameters opposite exit is null the method automatically sets the room parameters opposite exit as this
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

        if (room.northExit == null) {
            room.setNorthExit(this);
        }

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

    //Sets the vertical exits, north and south
    //The parameters represents the room that calls this method exits to the north and south cardinal directions
    public void setVerticalExits(Room northExit, Room southExit) {
        this.setNorthExit(northExit);
        this.setSouthExit(southExit);
    }

    //Sets the horizontal exits, west and east
    public void setHorizontalExits(Room westExit, Room eastExit) {
        this.setEastExit(eastExit);
        this.setWestExit(westExit);
    }

    //Sets this north, west and east exits to the given parameters
    public void setThreeWay(Room northExit, Room westExit, Room eastExit) {
        this.setNorthExit(northExit);
        this.setWestExit(westExit);
        this.setEastExit(eastExit);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }
}
