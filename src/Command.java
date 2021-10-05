public class Command {

    private Player creator; //Making an attribute  called creater from the player class

    public Command(Player creator) {
        this.creator = creator;
    } //This constructor calls on the attribute from the player class as an attribute.

    public static void infoHelp(){
        System.out.println("Type 'go north', 'north' or simply 'n' to go upwards.");
        System.out.println("Type 'go south', 'south' or simply 's' to go downwards.");
        System.out.println("Type 'go east', 'east' or simply 'e' to go right");
        System.out.println("Type 'go west', 'west' or simply 'w' to go left");
        System.out.println("Not sure which room you are in? Just type 'look' or 'l' and have a look around!");
    } //This method prints out the different movements you can make.

    public static void startInfo() {
        System.out.println("Welcome to this adventure game! Before we can start the game, I have a little guide just for you, so you know how to play!");
    infoHelp();
        System.out.println("Forgot how to walk around? You can write 'info', 'i', 'help' or 'h' to get this guide again!");
        System.out.println("Tired of playing? Just type 'quit' or 'q' and I will close the game for you!\n");
    } //This method calls all the start information for the game, also tells the basis of the story.



    public void go(String playerInput, Room currentRoom, Room endRoom) { //This method is what makes it possible to move around
        // It has 3 parameters, (playerInput, currentRoom(which room the player starts in), endRoom).
        //playerInput = south, north etc.
        // currentRoom = starterRoom.
        // endRoom = the room which the player wins if arrived.

        if (playerInput.equals("go north") || //if input
                playerInput.equals("north") ||
                playerInput.equals("n")) {
            System.out.println("going north");

            this.creator.setCurrentRoom(currentRoom.getNorthExit(), true); //This referring to the player class, and checks if the northExit!=null, if it is
            //it changes the currentRoom value to that.

        } else if (playerInput.equals("go south") || //Same thing happens here
                playerInput.equals("south") ||
                playerInput.equals("s")) {
            System.out.println("going south");

            this.creator.setCurrentRoom(currentRoom.getSouthExit(), true);

        } else if (playerInput.equals("go west") ||
                playerInput.equals("west") ||
                playerInput.equals("w")) {
            System.out.println("going west");

            this.creator.setCurrentRoom(currentRoom.getWestExit(), true);
        } else if (playerInput.equals("go east") ||
                playerInput.equals("east") ||
                playerInput.equals("e")) {
            System.out.println("going east");

            this.creator.setCurrentRoom(currentRoom.getEastExit(), true);

        } else if (playerInput.equals("look") || playerInput.equals("l")) { //if player enters info
            System.out.println("you are looking around and you are in: " + currentRoom); //this gets printed out
        }
        else if (playerInput.equals("info") || playerInput.equals("i") || playerInput.equals("help") || playerInput.equals("h")) { //if info or help is typed
            infoHelp(); //this method gets printed out
        }
        else if (playerInput.equals("quit") || playerInput.equals("q")) { //if quit is typed the game stops
            System.out.println("You have quitted the game");
            System.exit(0);
        }
        if (this.creator.getCurrentRoom() == endRoom) { //if the currentRoom = endRoom, then the player has won and the game finishes.
            System.out.println("you found the room !");
            System.out.println("congratzzzz");
            System.exit(0);
        }
    }
}

