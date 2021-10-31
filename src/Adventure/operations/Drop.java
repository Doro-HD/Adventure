package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;
import Adventure.util.Status;

public class Drop extends Operation {

    public Status execute(Player player) {
        this.drop(player);
        return Status.nextOp;
    }

    private void drop(Player player) {
        Controller controller = new Controller(player);

        for (String argument: this.operationArguments) {
            boolean itemWasDropped = controller.dropItem(argument);

            if (itemWasDropped) {
                this.operationExecution += argument + " was dropped.\n";
            } else {
                this.operationExecution += "Your inventory contains no such thing as a " + argument + "\n";
            }
        }
    }
}
