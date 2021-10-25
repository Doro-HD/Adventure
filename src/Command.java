import java.util.Scanner;

public class Command {

    private final Player creator; //Making an attribute  called creater from the player class

    public Command(Player creator) {
        this.creator = creator;
    } //This constructor calls on the attribute from the player class as an attribute.

    public static void infoHelp(){
        System.out.println("Type 'go north', 'north' or simply 'n' to go upwards.");
        System.out.println("Type 'go south', 'south' or simply 's' to go downwards.");
        System.out.println("Type 'go east', 'east' or simply 'e' to go right.");
        System.out.println("Type 'go west', 'west' or simply 'w' to go left.");
        System.out.println("Not sure which room you are in? Just type 'look' or 'l' and have a look around!");
    } //This method prints out the different movements you can make.

    public static void startInfo() {
        System.out.println("Welcome to this adventure game! Before we can start the game, I have a little guide just for you, so you know how to play!");
        infoHelp();
        System.out.println("Forgot how to walk around? You can write 'info', 'i', 'help' or 'h' to get this guide again!");
        System.out.println("Tired of playing? Just type 'quit' or 'q' and I will close the game for you!\n");
    } //This method calls all the start information for the game, also tells the basis of the story.



    public void go(String playerInput, Room currentRoom, Room endRoom) { //This method is what makes it possible to move around
       Scanner input = new Scanner(System.in);
        // It has 3 parameters, (playerInput, currentRoom(which room the player starts in), endRoom).
        //playerInput = south, north etc.
        // currentRoom = starterRoom.
        // endRoom = the room which the player wins if arrived.

        switch (playerInput) {

            case "go north", "north", "n" -> {
                this.creator.setCurrentRoom(currentRoom.getNorthExit(), "north", true); //This referring to the player class, and checks if the northExit!=null, if it is
            }
            //it changes the currentRoom value to that.

            case "go south", "south", "s" -> {
                this.creator.setCurrentRoom(currentRoom.getSouthExit(), "south", true);
            }
            case "go west", "west", "w" -> {
                this.creator.setCurrentRoom(currentRoom.getWestExit(), "west", true);
            }
            case "go east", "east", "e" -> {
                this.creator.setCurrentRoom(currentRoom.getEastExit(), "east", true);
            }
            case "inventory","inv"-> {
                if(creator.getInventory()==null){
                    System.out.println("You don't have anything like … in your inventory");
                }else
                System.out.println(creator.getInventory());
            }
            case "take", "t"->{
                System.out.println("Write the item you want to take");
                String inventoryTake = input.nextLine();
                creator.takeItem(inventoryTake);
            }
            case "drop","d"->{
                System.out.println("Write the item you want to drop");
                String inventoryDrop = input.nextLine();
                creator.dropItem(inventoryDrop);
            }

            case "look", "l" ->  //if player enters info
                System.out.println("You are looking around and you are in " + currentRoom); //this gets printed out
            case "info", "i", "help", "h" ->  //if info or help is typed
                infoHelp(); //this method gets printed out
            case "quit", "q" -> {  //if quit is typed the game stops
                System.out.println("You have quitted the game.");
                System.exit(0);
            }
        }
        if (this.creator.getCurrentRoom() == endRoom) { //if the currentRoom = endRoom, then the player has won and the game finishes.
            System.out.println("You fixed the core reactor!");
            System.out.println("Time passed: " + Count.secondsPassed+" seconds");
            System.out.println("Congratulations!");
            System.exit(0);
        }
    }
}

