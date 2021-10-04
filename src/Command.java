public class Command {

    private Player creator; //Making a attribute  called creater from the player class

    public Command(Player creator) {
        this.creator = creator;
    } //This constructor calls on the attribute from the player class as an attribute.

    public static void infoHelp(){
        System.out.println("the controls are n, north or go north for going upwards");
        System.out.println("the controls are s, south or go south for going downwards");
        System.out.println("the controls are e, east, or go east for going to the right");
        System.out.println("the controls are w, west, or go west for going to the left");
        System.out.println("write look if you wanna se which room you are in");
    } //This method prints out the different movements you can make.

    public static void startInfo() {
        System.out.println("Welcome to the adventure game, there is 9 rooms");
    infoHelp();
        System.out.println("if you forget the controls just write info, i, help or h");
        System.out.println("if you want to quit the game just write q or quit\n");
    } //This method calls all the start information for the game, also tells the basis of the story.



    public void go(String playerInput, Room currentRoom, Room endRoom) { //This method is what makes it possible to move around
        // It has 3 parameters, (playerInput, currentRoom(which room the player starts in), endRoom).
        //playerInput = south, north etc.
        // currentRoom = starterRoom.
        // endRoom = the room which the player wins if arrived.

        if (playerInput.equals("go north") || //if input
                playerInput.equals("north") ||
                playerInput.equals("n")) {

            this.creator.setCurrentRoom(currentRoom.getNorthExit()); //This referring to the player class, and checks if the northExit!=null, if it is
            //it changes the currentRoom value to that.

        } else if (playerInput.equals("go south") ||
                playerInput.equals("south") ||
                playerInput.equals("s")) {
            System.out.println("going south");

            this.creator.setCurrentRoom(currentRoom.getSouthExit());

        } else if (playerInput.equals("go west") ||
                playerInput.equals("west") ||
                playerInput.equals("w")) {
            System.out.println("going west");

            this.creator.setCurrentRoom(currentRoom.getWestExit());
        } else if (playerInput.equals("go east") ||
                playerInput.equals("east") ||
                playerInput.equals("e")) {
            System.out.println("going east");

            this.creator.setCurrentRoom(currentRoom.getEastExit());


        } else if (playerInput.equals("look") || playerInput.equals("l")) {
            System.out.println("you are looking around and you are in: " + currentRoom);
        } else if (playerInput.equals("info") || playerInput.equals("i") || playerInput.equals("help") || playerInput.equals("h")) {
            infoHelp();
        } else if (playerInput.equals("quit") || playerInput.equals("q")) {
            System.exit(0);
        }
        if (this.creator.getCurrentRoom() == endRoom) {
            System.out.println("you found the room !");
            System.out.println("congratzzzz");
            System.exit(0);
        }
        this.creator.printLocation();
    }
}

