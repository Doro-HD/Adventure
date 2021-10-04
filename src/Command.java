public class Command {

    private Player creator;

    public Command(Player creator) {
        this.creator = creator;
    }

    public static void startInfo() {
        System.out.println("Welcome to the adventure game, there is 9 rooms");
        System.out.println("the controls are n, north or go north for going upwards");
        System.out.println("the controls are s, south or go south for going downwards");
        System.out.println("the controls are e, east, or go east for going to the right");
        System.out.println("the controls are w, west, or go west for going to the left");
        System.out.println("write look if you wanna se which room you are in");
        System.out.println("if you forget the controls just write info, i, help or h");
        System.out.println("if you want to quit the game just write q or quit\n");
    }

    public void go(String playerInput, Room currentRoom, Room endRoom) {

        if (playerInput.equals("go north") ||
                playerInput.equals("north") ||
                playerInput.equals("n")) {

            this.creator.setCurrentRoom(currentRoom.getNorthExit());

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
            System.out.println("the controls are n, north or go north for going upwards");
            System.out.println("the controls are s, south or go south for going downwards");
            System.out.println("the controls are e, east, or go east for going to the right");
            System.out.println("the controls are w, west, or go west for going to the left");
            System.out.println("write look if you wanna se which room you are in");
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

