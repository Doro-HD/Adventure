import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Delegator {
    private HashMap<String, Operation> operationMap;

    public Delegator() {
        this.operationMap = new HashMap<>();
        this.operationMap.put("go", new Move());
        this.operationMap.put("look", new Look());
        this.operationMap.put("take", new Take());
        this.operationMap.put("drop", new Drop());
    }

    public void delegate(String userInput, Player player) {
        ArrayList<String> userInputArray = new ArrayList<>(List.of(userInput.split("\s+")));

        ArrayList<Operation> operations = findOperations(userInputArray);

        this.executeOperations(operations, player);
    }

    private ArrayList<Operation> findOperations(ArrayList<String> userInputArray) {
        ArrayList<Integer> operationIndexes = this.findOperationsIndexes(userInputArray);

        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < operationIndexes.size(); i++) {
            Operation operation = this.operationMap.get(userInputArray.get(operationIndexes.get(i)));

            ArrayList<String> sublist;
            if (operationIndexes.size() < i + 1) {
                sublist = new ArrayList<>(userInputArray.subList(i + 1, userInputArray.size()));
            } else {
                sublist = new ArrayList<>(userInputArray.subList(i + 1, operationIndexes.get(i + 1)));
            }

            ArrayList<String> operationArguments = this.findOperationArguments(sublist);
            operation.setOperationArguments(operationArguments);
        }

        return operations;
    }

    private ArrayList<Integer> findOperationsIndexes(ArrayList<String> userInputArray) {
        ArrayList<Integer> operationIndexes = new ArrayList<>();

        for (int i = 0; i < userInputArray.size(); i++) {
            if (this.operationMap.containsKey(userInputArray.get(i))) {
                operationIndexes.add(i);
            }
        }

        return operationIndexes;
    }

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

