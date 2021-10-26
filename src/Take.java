public class Take extends Operation {

    //todo: reconsider if operations need to return a boolean
    public boolean execute(Player player) {
        take(player);
        return true;
    }

    private void take(Player player) {
        Controller controller = new Controller(player);

        for (String argument : this.operationArguments) {
            boolean itemWasTaken = controller.takeItem(argument);

            if (itemWasTaken) {
                this.operationExecution += argument + " was added to your inventory\n";
            } else {
                this.operationExecution += "You could not find any " + argument + "\n";
            }
        }
    }
}
