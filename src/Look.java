public class Look extends Operation{

    public boolean execute(Player player) {
        this.look(player);
        return true;
    }

    private void look(Player player) {
        this.operationExecution += "You are in:\n" + player.getCurrentRoom();
    }
}
