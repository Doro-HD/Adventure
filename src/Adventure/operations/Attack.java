package Adventure.operations;

import Adventure.core.Player;
import Adventure.util.Status;

public class Attack extends Operation{

  public boolean execute(Player player) {
    boolean continueGame = this.attack(player);
    return continueGame;
  }

  private boolean attack(Player player){
    boolean continueGame = true;
    Status status = player.checkAttack();

    switch (status) {
      case enemyIsDead:
        this.operationExecution += "Congratulations you killed the enemy.";
        break;
      case enemyIsStillAlive:
        this.operationExecution += "The enemy is still alive.";
        break;
      case playerIsDead:
        this.operationExecution += "You Died!\nGAME OVER";
        continueGame = false;
        break;
    }
    return continueGame;
  }

}
