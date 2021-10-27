package Adventure.core;

import java.util.Scanner;
import Adventure.util.Count;

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

  public boolean goNorth(){     //This referring to the player class, and checks if the northExit!=null, if it is
    if(this.creator.setCurrentRoom(creator.getCurrentRoom().getNorthExit())){
      return true;
    }else
      return false;
  } //This referring to the player class, and checks if the northExit!=null, if it is
  //it changes the currentRoom value to that.

  public boolean goSouth(){
    if(this.creator.setCurrentRoom(creator.getCurrentRoom().getSouthExit())){
      return true;
    }else
      return false;
  }

  public boolean goWest(){
    if (this.creator.setCurrentRoom(creator.getCurrentRoom().getWestExit())){
      return true;
    }else{
      return false;
    }
  }

  public boolean goEast(){
    if (this.creator.setCurrentRoom(creator.getCurrentRoom().getEastExit())){
      return true;
    }else{
      return false;
    }
  }

  public boolean showInventory(){
    if (creator.inventoryIsEmpty()) {
      return false;
    } else
      return true;
  }

  public boolean takeItem(String itemType){
    return creator.takeItem(itemType);
  }

  public boolean dropItem(String itemType){
    return creator.dropItem(itemType);
  }

  public void endOfStory(Room endRoom){
    if (this.creator.getCurrentRoom() == endRoom) { //if the currentRoom = endRoom, then the player has won and the game finishes.
      System.out.println("You fixed the Adventure.operations.core reactor!");
      System.out.println("Time passed: " + count.getSecondsPassed() + " seconds");
      System.out.println("Congratulations!");
      System.exit(0);
    }
  }
}
