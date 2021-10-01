import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean checkAnswer;
    System.out.println("Welcome to the adventure");
    System.out.println("You are in a room, and you have 4 different options");
    System.out.println("Write north for going north, write east for going east etc.");
    String inputPlayer = input.nextLine();
    do {
      switch (inputPlayer) { //Laver en switch som kontroller brugerens input
        case "go north","north","n":
          System.out.println("Going north!"); //Hvis bruger har skrevet 1 vil den sige dette
          checkAnswer = true;
          break;
        case "go south","south","s":
          System.out.println("Going south!"); // Hvis bruger har skrevet 2 vil den sige dette
          checkAnswer = true;
          break;
        case "go east","east","e":
          System.out.println("Going east!"); // Hvis bruger har skrevet 3 vil den sige dette
          checkAnswer = true;
          break;
        case "go west","west","w":
          System.out.println("Going west!"); //Hvis bruger har skrevet 9 vil den sige dette
          checkAnswer = true;
          break;
        case "look", "l":
          System.out.println("Looking around!");
          checkAnswer = true;
          break;

        case "info", "i":
          System.out.println("Write north for going north, write east for going east etc.");
          inputPlayer =input.nextLine(); //så skal den give player muliged for input igen
          checkAnswer  =false;
          break;

        default: // alt andet er forkert input
          System.out.println("i dont understand!");
          System.out.println("try again");

          inputPlayer =input.nextLine(); //så skal den give player muliged for input igen
          checkAnswer = false; // her er den så false fordi så betyder det man har tastet andet end noth, east, west, south
      }
    } while (!checkAnswer); //Den skal blive ved med at loop så længe den er false altså alt andet end north, east, west, south
  }
}