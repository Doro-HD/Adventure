package Adventure.operations;
import Adventure.core.Player;

public class Eat extends Operation {
  enum status{notFound, usable, nonUsable}
  public boolean execute(Player player) {
    eat(player);
    return true;
  }
  private void eat(Player player){
    for (String food: this.operationArguments) {
      boolean checkFood = player.consumeFood(food);
      if(checkFood){
        operationExecution += "You ate: " + food + "\n";
      }else{
        operationExecution += "You cant eat that shit bro \n";
      }

    }
  }
}
