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


  public static void startInfo() {
    System.out.println("Welcome to Delusional Space Station Exploration Game! Before we can start the game, I have a little guide just for you, so you know how to play!");
  } //This method calls all the start information for the game

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

  public boolean isInventoryEmpty(){
    if (creator.inventoryIsEmpty()) {
      return true;
    } else
      return false;
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
