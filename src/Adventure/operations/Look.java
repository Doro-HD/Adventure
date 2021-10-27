package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;

public class Look extends Operation {

    public boolean execute(Player player) {
        this.look(player);
        return true;
    }

    private void look(Player player) {
        this.operationExecution += "You are in:\n" + player.getCurrentRoom();
    }
}
