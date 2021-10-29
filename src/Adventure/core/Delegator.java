package Adventure.core;

import Adventure.operations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Adventure.operations.core.Delegator the only thing it does it redirects the Adventure.operations and excute them
// the private methods are there beacuse they shouldnt be run, if its not called by the delegator.
public class Delegator {
    //operationMap is used to identify which operation the user wants to execute
    //for example. If the user typed "go north", go will be mapped to an instance -
    //of a class that inherits from Adventure.operations.Operation
    private HashMap<String, Operation> operationMap;

    //The constructor sets up the operationMap with the propper keys
    //The keys are the keywords that the user will enter to execute Adventure.operations
    public Delegator() {
        this.operationMap = new HashMap<>();
        this.operationMap.put("go", new Move());
        this.operationMap.put("look", new Look());
        this.operationMap.put("inventory", new Inventory());
        this.operationMap.put("health",new HpStatus());
        this.operationMap.put("eat",new Eat());
        this.operationMap.put("take", new Take());
        this.operationMap.put("drop", new Drop());
        this.operationMap.put("equip", new Equip());
    }

    //Main method of this class, uses other private methods to delegate task into Adventure.operations
    public void delegate(String userInput, Player player) {
        ArrayList<String> userInputArray = new ArrayList<>(List.of(userInput.split("\s+"))); //"split it's a way to call a specific"
        //"\s+ - in this context mean 1 space or more"

        //this is the arraylist that contains the Adventure.operations that will be executed once they have been found
        ArrayList<Operation> operations = findOperations(userInputArray);

        this.executeOperations(operations, player);
    }

    //returns an arraylist of operation that it finds in the user's input
    //uses other private methods to help set up Adventure.operations
    private ArrayList<Operation> findOperations(ArrayList<String> userInputArray) { //This returns a arrayslist of Adventure.operations
        //which means
        //this arraylist contains integers which represents the index of any keyword that the user entered
        ArrayList<Integer> operationIndexes = this.findOperationsIndexes(userInputArray);

        //Instantiates a new arraylist that will be populated with Adventure.operations if any is found
        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < operationIndexes.size(); i++) {
            //this.operationMap.get() will return an instance of a class that inherits from Adventure.operations.Operation
            Operation operation = this.operationMap.get(userInputArray.get(operationIndexes.get(i)));

            //sublist is an arraylist that will contain any arguments that the user provide to an operation
            //for example. If the user typed "go north". go is an operation and north is an argument to go
            ArrayList<String> sublist;
            //if the current iteration is the last iteration of the for loop the if statement is true
            if (operationIndexes.size() <= i + 1) {
                //if the current iteration is the last iteration -
                //then the sublist will range from the current operation keyword index + 1, to the end of the user's input
                sublist = new ArrayList<>(userInputArray.subList(operationIndexes.get(i) + 1, userInputArray.size()));
            } else {
                //if the current iteration is not the last iteration -
                //then the sublist will range from the current operation keyword index + 1, -
                //up to but not including the next operation keyword
                sublist = new ArrayList<>(userInputArray.subList(operationIndexes.get(i) + 1, operationIndexes.get(i + 1)));
            }

            //this arraylist will contain all arguments that are typed after the last operation keyword
            ArrayList<String> operationArguments = this.findOperationArguments(sublist);
            //this method sets the operationArguments of the instance
            operation.setOperationArguments(operationArguments);

            //Adds the operation to the arraylist that will be returned at the end of this method
            operations.add(operation);
        }

        return operations;
    }

    //finds the index of any operation keyword and returns them as an arraylist
    private ArrayList<Integer> findOperationsIndexes(ArrayList<String> userInputArray) {
        //this operation
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

    //Executes each operation in the arraylist passed to this method
    private void executeOperations(ArrayList<Operation> operations, Player player) {
        //Loops through each operation in the arraylist passed to this method and executes it
        for (Operation operation: operations) {
            //Executes the operation and gives the player as an argument to the execute method
            operation.execute(player);
            //prints out the operation, Operation has a toString() that returns an attribute that is modified -
            //class that inherits from Operation
            System.out.println(operation);

            //resets all attribute of the operation
            //the operationArgument arraylist is set to a new empty arraylist
            //the string that is returned from the toString() method of Operation is set to an empty string
            operation.resetAttributes();
        }
    }
}

