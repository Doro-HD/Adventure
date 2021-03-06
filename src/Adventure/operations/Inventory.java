package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;

public class Inventory extends Operation {

    public boolean execute(Player player) {
        this.inventory(player);
        return true;
    }

    private void inventory(Player player) {
        Controller controller = new Controller(player);

        boolean inventoryIsEmpty = controller.isInventoryEmpty();
        if (inventoryIsEmpty) {
            this.operationExecution += "Your inventory is empty";
        } else {
            this.operationExecution += "Your inventory:\n" + player.inventoryToString();
        }
        this.operationExecution += "\n";
    }
}
