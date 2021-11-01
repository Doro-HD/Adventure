package Adventure.operations;

import Adventure.core.Enemy;
import Adventure.core.Player;

public class Attack extends Operation{
  public boolean execute(Player player) {
    this.attack(player);
    return true;
  }
  private void attack(Player player){

  }
}
