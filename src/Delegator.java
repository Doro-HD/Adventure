import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Delegator {
    //Delegator the only thing it does it redirects the operations and excute them
    // the private methods are there beacuse they shouldnt be run, if its not called by the delegator.
    private HashMap<String, Operation> operationMap;

    public Delegator() {
        this.operationMap = new HashMap<>();
        this.operationMap.put("go", new Move());
        this.operationMap.put("look", new Look());
        this.operationMap.put("inventory", new Inventory());
        this.operationMap.put("take", new Take());
        this.operationMap.put("drop", new Drop());
    }

    //Main method of this class, uses other private methods to delegate task into operations
    public void delegate(String userInput, Player player) {
        ArrayList<String> userInputArray = new ArrayList<>(List.of(userInput.split("\s+"))); //"split it's a way to call a specific"
        //"\s+ - in this context mean 1 space or more"

        ArrayList<Operation> operations = findOperations(userInputArray);

        this.executeOperations(operations, player);
    }

    //returns an arraylist of operation that it finds in the user's input
    //uses other private methods to help set up operations
    private ArrayList<Operation> findOperations(ArrayList<String> userInputArray) { //This returns a arrayslist of operations
        //which means
        ArrayList<Integer> operationIndexes = this.findOperationsIndexes(userInputArray);

        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < operationIndexes.size(); i++) {
            Operation operation = this.operationMap.get(userInputArray.get(operationIndexes.get(i)));

            ArrayList<String> sublist;
            if (operationIndexes.size() <= i + 1) {
                sublist = new ArrayList<>(userInputArray.subList(i + 1, userInputArray.size()));
            } else {
                sublist = new ArrayList<>(userInputArray.subList(i + 1, operationIndexes.get(i + 1)));
            }

            ArrayList<String> operationArguments = this.findOperationArguments(sublist);
            operation.setOperationArguments(operationArguments);

            operations.add(operation);
        }

        return operations;
    }

    //finds the index of any operation keyword and returns them as an arraylist
    private ArrayList<Integer> findOperationsIndexes(ArrayList<String> userInputArray) {
        ArrayList<Integer> operationIndexes = new ArrayList<>();

        for (int i = 0; i < userInputArray.size(); i++) {
            if (this.operationMap.containsKey(userInputArray.get(i))) {
                operationIndexes.add(i);
            }
        }

        return operationIndexes;
    }

    //returns an arraylist of arguments that the user provided after the operation keyword
    //the argument provided in findOperations() is a sublist of the user's input
    //so the method only loops through any argument from the first word after the operation keyword -
    //up til but not including the next operation keyword
    private ArrayList<String> findOperationArguments(ArrayList<String> userInputArray) {
        ArrayList<String> operationArguments = new ArrayList<>();

        for (String argument: userInputArray) {
            operationArguments.add(argument);
        }
        return operationArguments;
    }

    private void executeOperations(ArrayList<Operation> operations, Player player) {
        for (Operation operation: operations) {
            operation.execute(player);
            System.out.println(operation);

            operation.resetAttributes();
        }
    }
}

