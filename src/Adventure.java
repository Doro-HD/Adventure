import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Map map = new Map(); //Sets the map in a 3x3 grid.
        Player player = new Player("Bob", map.getStartRoom());

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().toLowerCase();
            userInput = userInput.trim();

            Command command = new Command(player);
            command.go(userInput, player.getCurrentRoom(), map.getEndRoom());
        }
        while (!userInput.equals("exit"));
    }
}
