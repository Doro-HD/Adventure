import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Map map = new Map(); //Sets the map in a 3x3 grid.

        Command.startInfo();

        Scanner scanner = new Scanner(System.in);

        //Prompts the user to enter a name
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        //Creates the player instance with a name and their starting position
        Player player = new Player(userName, map.getStartRoom());

        String userInput = "";
        while (!userInput.equals("exit")) {
            //Gets the user's command and makes it lowercase
            userInput = scanner.nextLine().toLowerCase();
            //Removes white space from the beginning and end of the user's input
            userInput = userInput.trim();

            //Creates a command instance and sets the player instance as it's creator for easy reference
            Command command = new Command(player);
            //Calls the go method in the Command class which evaluates the user's command
            command.go(userInput, player.getCurrentRoom(), map.getEndRoom());
        }
    }
}
