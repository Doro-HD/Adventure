package Adventure.operations;

import Adventure.core.Player;
import Adventure.util.Status;

public class Equip extends Operation {
  public Status execute(Player player) {
    equip(player);
    return Status.nextOp;
  }

  private void equip(Player player){
    for (String argument: this.operationArguments) {
      boolean weaponIsEquipped = player.equipWeapon(argument);
      if (weaponIsEquipped) {
        this.operationExecution += argument + " was equipped" + "\n";
      } else {
        this.operationExecution += "You could not equip " + argument + "\n";
      }
    }

  }
}
