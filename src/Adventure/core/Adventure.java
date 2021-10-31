package Adventure.core;

import Adventure.util.Count;

import java.util.Scanner;


public class Adventure {
    public static void main(String[] args) {
        Map map = new Map(); //Sets the map in a 3x3 grid.
        Count counter = new Count();

        Controller.startInfo();

        Scanner scanner = new Scanner(System.in);

        //Prompts the user to enter a name
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        //Creates the player instance with a name and their starting position
        Player player = new Player(userName, map.getStartRoom());
        Controller control = new Controller(player);
        System.out.println("Well hello " + userName + "! Lets get this game started!");
        System.out.println("A mechanical noise is filling your ears and it feels like the ground beneath is moving.. Oh! That's right. " +
            "You are on Mo's Space Station!\nWhy don't you have a look around?");

        String userInput = "";
        counter.start();
        while (!userInput.equals("exit")) {
            System.out.println("What would you like to do?");
            //Gets the user's command and makes it lowercase
            userInput = scanner.nextLine().toLowerCase().trim();

            //Creates a command instance and sets the player instance as it's creator for easy reference
            Delegator delegator = new Delegator();
            //Calls the go method in the Command class which evaluates the user's command
            delegator.delegate(userInput, player);
            control.endOfStory(map.getEndRoom());
        }

    }
}
