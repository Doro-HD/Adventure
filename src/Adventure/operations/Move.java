package Adventure.operations;

import Adventure.core.Player;
import Adventure.core.Controller;
import Adventure.util.Status;

public class Move extends Operation {

    public Status execute(Player player) {
        this.move(player);
        return Status.nextOp;
    }

    private boolean move(Player player) {
        Controller controller = new Controller(player);
        boolean playerWasMoved = true;

        for (String direction: this.operationArguments) {
            switch (direction) {
                case "n", "north":
                    playerWasMoved = controller.goNorth();
                    break;
                case "s", "south":
                    playerWasMoved = controller.goSouth();
                    break;
                case "w", "west":
                    playerWasMoved = controller.goWest();
                    break;
                case "e", "east":
                    playerWasMoved = controller.goEast();
                    break;
                default:
                    playerWasMoved = false;
            }
            if (playerWasMoved) {
                this.operationExecution += "You moved " + direction + "\n";
            } else {
                this.operationExecution += "You were unable to move " + direction + " \n";
            }
        }
        this.operationExecution += "\nYou are in:\n" + player.getCurrentRoom();
        return playerWasMoved;
    }

}
