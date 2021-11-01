package Adventure.operations;

import Adventure.core.Player;

public class Help extends Operation{

    public boolean execute(Player player) {
        return true;
    }

    private void help() {
        this.operationExecution += """
                Here are the following command:
                \tgo:
                \t\tUsed to move around. For example type, 'go east', to move east.
                
                \tlook:
                \t\tUsed to get information about the room you are currently in.
                
                \ttake:
                \t\tUsed to take items of all kinds from the room you are currently in and add them to your inventory.
                \t\tFor example type, 'take hammer', to take a hammer.
                
                \tdrop:
                \t\tUsed to remove items from your inventory and leaves them in the current room.
                \t\tFor example type, 'drop hammer', to drop the hammer.
                
                \teat:
                \t\tUsed to eat food items from your inventory. For example type, 'eat apple' to eat an apple.
                \t\tThe food must be in your inventory before you can eat it.
                
                \tequip:
                \t\tUsed to equip a weapon from your inventory to yourself. For example type, 'equip dagger', to equip a dagger to yourself.
                \t\tThe Weapon must be in your inventory before you can equip it
                
                \thealth:
                \t\tUsed to check your current HP. Simply type, 'health', to get information about your current health.
                
                \tinventory:
                \t\tUsed to check which items are in your possession. Simply type, 'inventory', to get information about your items.
                """;
    }

}
