package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;
import Adventure.util.Status;

public class Inventory extends Operation {

    public Status execute(Player player) {
        this.inventory(player);
        return Status.nextOp;
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
