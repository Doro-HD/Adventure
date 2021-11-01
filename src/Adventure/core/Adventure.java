package Adventure.core;

import Adventure.operations.Help;
import Adventure.util.Count;

import java.util.Scanner;


public class Adventure {
    public static void main(String[] args) {
        Map map = new Map(); //Sets the map in a 3x3 grid.
        Count counter = new Count();
        Help help = new Help();

        Controller.startInfo();

        Scanner scanner = new Scanner(System.in);

        //Prompts the user to enter a name
        System.out.print("First, please enter your name: ");
        String userName = scanner.nextLine();
        //Creates the player instance with a name and their starting position
        Player player = new Player(userName, map.getStartRoom());
        Controller control = new Controller(player);

        System.out.println("Well hello " + userName + "! Lets get this game started!");

        help.execute(player);
        System.out.println(help.getOperationExecution());

        System.out.println("I think you are ready now.. Let's go ahead and start this adventure!");
        System.out.println("A mechanical noise is filling your ears and it feels like the ground beneath is moving.. Oh! That's right. " +
                "You are on Mo's Space Station!\nWhy don't you have a look around?");

        String userInput = "";
        boolean continueGame = true;
        counter.start();

        while (continueGame) {
            System.out.println("What would you like to do?");
            //Gets the user's command and makes it lowercase
            userInput = scanner.nextLine().toLowerCase().trim();

            //Creates a command instance and sets the player instance as it's creator for easy reference
            Delegator delegator = new Delegator();
            //Calls the go method in the Command class which evaluates the user's command
            continueGame = delegator.delegate(userInput, player);
            control.endOfStory(map.getEndRoom());
        }

        //Program cannot exit, so we force it to at the end.
        System.exit(0);
    }
}
