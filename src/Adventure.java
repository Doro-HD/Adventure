import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Map map = new Map(); //Sets the map in a 3x3 grid.
        Count counter = new Count();


        Item item1 = new Item("screwdriver", "the only screwdriver you will ever need", " ");
        Item item2 = new Item("hammer", "hammer ", " ");
        Item item3 = new Item("flashlight", "small grey flashlight", "eventhough it is smaller than your palm, this flashlight can really light up the room");
        Item item4 = new Item("waterbottle", "a bottle filled with water", "plastic bottle with a washed out logo");
        Item item5 = new Item("ID card","plastic ID card","small card with a picture of a man and the name JAMES PETERSON written with a lot of numbers beneath");
        Item item6 = new Item("knife","pocketknife","small, black knife. The blade is a little rusty");
        Item item7 = new Item("map","map over Mo's Space Station","a black piece of paper, showing how the 9 rooms on the space station is located.");
        Item item8 = new Item("key","small silver key","");
        Item item9 = new Item();
        Item item10 = new Item();

        map.getStartRoom().getItems().add(item1);
        map.getStartRoom().getItems().add(item2);
        map.getStartRoom().getItems().add(item3);
        map.getStartRoom().getItems().add(item4);


        Command.startInfo();

        Scanner scanner = new Scanner(System.in);

        //Prompts the user to enter a name
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        //Creates the player instance with a name and their starting position
        Player player = new Player(userName, map.getStartRoom());
        System.out.println("Well hello "+userName +"! Lets get this game started!");
        System.out.println("A mechanical noise is filling your ears and it feels like the ground beneath is moving.. Oh! That's right. You are on Mo's Space Station!\nWhy don't you have a look around?");

        String userInput = "";
        counter.start();
        while (!userInput.equals("exit")) {
            System.out.println("What would you like to do?");
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
