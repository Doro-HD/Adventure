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
      case enemyNotFound:
        this.operationExecution += "There is no enemy in the room";
        break;
      case itemNotFound:
        this.operationExecution += "You must equip a weapon before trying to attack an enemy";
        break;
      case notUsable:
        this.operationExecution += "You have no ammo left for your weapon";
        break;
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
