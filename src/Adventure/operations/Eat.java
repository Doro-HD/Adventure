package Adventure.operations;

import Adventure.core.Player;
import Adventure.util.Status;

public class Eat extends Operation {

  public boolean execute(Player player) {
    this.eat(player);
    return true;
  }

  private void eat(Player player){
    for (String food: this.operationArguments) {
      Status checkFood = player.consumeFood(food);

      switch (checkFood) {
        case usable:
          this.operationExecution += "You have eaten " + food;
          break;
        case notUsable:
          this.operationExecution += food + " is not edible";
          break;
        case itemNotFound:
          this.operationExecution += "There is no " + food + " in your inventory or room";
          break;
      }

    }
  }
}
