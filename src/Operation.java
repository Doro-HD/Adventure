import java.util.ArrayList;

public abstract class Operation {
    protected ArrayList<String> operationArguments;
    protected String operationExecution = "";

    public abstract boolean execute(Player player);

    public void resetAttributes() {
        this.operationArguments = new ArrayList<>();
        this.operationExecution = "";
    }

    public void setOperationArguments(ArrayList<String> operationArguments) {
        this.operationArguments = operationArguments;
    }

    public String toString() {
        return this.operationExecution;
    }
}
