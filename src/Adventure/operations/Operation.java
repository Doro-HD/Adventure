package Adventure.operations;

import java.util.ArrayList;
import Adventure.core.Player;
import Adventure.util.Status;

public abstract class Operation { //This is a abstract class which means, you can not make an object out of it
    //Beacuse you are only meant to use the commands that are extended to this class

    protected ArrayList<String> operationArguments;
    protected String operationExecution = "";

    public abstract Status execute(Player player);

    public void resetAttributes() {
        this.operationArguments = new ArrayList<>();
        this.operationExecution = "";
    }

    public void setOperationArguments(ArrayList<String> operationArguments) {
        this.operationArguments = operationArguments;
    }

    public String toString() {
        return this.operationExecution;
    } //this returns a string which is being modified, beacuse the different methods change
    // the toString return value.
}
