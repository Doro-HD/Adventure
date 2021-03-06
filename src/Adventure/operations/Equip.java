package Adventure.operations;

import Adventure.core.Player;

public class Equip extends Operation {
  public boolean execute(Player player) {
    equip(player);
    return true;
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
