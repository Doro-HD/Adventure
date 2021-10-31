package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;
import Adventure.util.Status;

public class Look extends Operation {

    public Status execute(Player player) {
        this.look(player);
        return Status.nextOp;
    }

    private void look(Player player) {
        this.operationExecution += "You are in:\n" + player.getCurrentRoom();
    }
}
