import java.util.Scanner;

public class Command {

    //Making an attribute  called creater from the player class


    public void go(String playerInput, Room currentRoom, Room endRoom) { //This method is what makes it possible to move around
        //Creates an array that splits the playerInput on each white space
        //It does not matter if there is one or more white spaces
        String[] playerInputArray = playerInput.split("\s+");

        Scanner input = new Scanner(System.in);
        // It has 3 parameters, (playerInput, currentRoom(which room the player starts in), endRoom).
        //playerInput = south, north etc.
        // currentRoom = starterRoom.
        // endRoom = the room which the player wins if arrived.
        switch (playerInput) {






            case "quit", "q" -> {  //if quit is typed the game stops
                System.out.println("You have quitted the game.");
                System.exit(0);
            }
            default -> {
                System.out.println("You have entered an invalid answer!!");
                System.out.println("Try again!");
                playerInput = input.nextLine();
            }
        }

    }
}

