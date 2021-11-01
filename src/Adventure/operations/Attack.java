package Adventure.operations;

import Adventure.core.Enemy;
import Adventure.core.Player;

public class Attack extends Operation{

  public boolean execute(Player player) {
    this.playerAttack(player);
    this.enemyAttack();
    return true;
  }
  private void playerAttack(Player player){

  }
  private void enemyAttack(Enemy enemy){

  }
}
