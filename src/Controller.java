import java.util.Scanner;

public class Controller {
  Scanner input = new Scanner(System.in);
  private final Player creator; //Making an attribute  called creater from the player class
  Count count = new Count();


  public Controller(Player creator){
    this.creator = creator;
  }//This constructor calls on the attribute from the player class as an attribute.

  public static void infoHelp() {
    System.out.println("Type 'go north', 'north' or simply 'n' to go upwards.");
    System.out.println("Type 'go south', 'south' or simply 's' to go downwards.");
    System.out.println("Type 'go east', 'east' or simply 'e' to go right.");
    System.out.println("Type 'go west', 'west' or simply 'w' to go left.");
    System.out.println("Not sure which room you are in? Just type 'look' or 'l' and have a look around!");
  }//This method prints out the different movements you can make.

  public static void startInfo() {
    System.out.println("Welcome to this adventure game! Before we can start the game, I have a little guide just for you, so you know how to play!");
    infoHelp();
    System.out.println("Forgot how to walk around? You can write 'info', 'i', 'help' or 'h' to get this guide again!");
    System.out.println("Tired of playing? Just type 'quit' or 'q' and I will close the game for you!\n");
  } //This method calls all the start information for the game, also tells the basis of the story.

  public boolean goNorth(Room currentRoom){     //This referring to the player class, and checks if the northExit!=null, if it is
    if(this.creator.setCurrentRoom(currentRoom.getNorthExit(), "north", true)){
      return true;
    }else
      return false;
  } //This referring to the player class, and checks if the northExit!=null, if it is
  //it changes the currentRoom value to that.

  public boolean goSouth(Room currentRoom){
    if(this.creator.setCurrentRoom(currentRoom.getSouthExit(), "south", true)){
      return true;
    }else
      return false;
  }

  public boolean goWest(Room currentRoom){
    if (this.creator.setCurrentRoom(currentRoom.getWestExit(), "west", true)){
      return true;
    }else{
      return false;
    }
  }

  public boolean goEast(Room currentRoom){
    if (this.creator.setCurrentRoom(currentRoom.getEastExit(), "east", true)){
      return true;
    }else{
      return false;
    }
  }

  public void showInventory(){
    if (creator.inventoryIsEmpty()) {
      System.out.println("You don't have anything like … in your inventory");
    } else
      System.out.println(creator.getInventory());
  }

  public void takeItem(){
    System.out.println("Write the item you want to take");
    String inventoryTake = input.nextLine();
    boolean itemFound = creator.takeItem(inventoryTake);
    if (itemFound) {
      System.out.println("You have taken a " + inventoryTake);
    } else {
      System.out.println("There is nothing like … to take around here!!");
    }
  }

  public void dropItem(){
    System.out.println("Write the item you want to drop");
    String inventoryDrop = input.nextLine();
    boolean itemDrop = creator.dropItem(inventoryDrop);
    if (itemDrop) {
      System.out.println("You have dropped " + inventoryDrop);
    } else {
      System.out.println("There is no such item in your inventory!!");
    }
  }

  public void lookRoom(Room currentRoom){
    System.out.println("You are looking around and you are in " + currentRoom);
  }

  public void endOfStory(Room currentRoom, Room endRoom){
    if (this.creator.getCurrentRoom() == endRoom) { //if the currentRoom = endRoom, then the player has won and the game finishes.
      System.out.println("You fixed the core reactor!");
      System.out.println("Time passed: " + count.secondsPassed + " seconds");
      System.out.println("Congratulations!");
      System.exit(0);
    }
  }
}
