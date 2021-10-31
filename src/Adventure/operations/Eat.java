package Adventure.operations;

import Adventure.core.Player;
import Adventure.util.Status;

public class Eat extends Operation {
  public Status execute(Player player) {
    eat(player);
    return Status.nextOp;
  }
  private void eat(Player player){
    for (String food: this.operationArguments) { //lorte udtryk
      boolean checkFood = player.consumeFood(food);
      if(checkFood){
        operationExecution += "You ate: " + food + "\n";
      }else{
        operationExecution += "You cant eat that shit bro \n";
      }

    }
  }
}
