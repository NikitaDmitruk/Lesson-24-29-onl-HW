package by.tms.lesson25.calculator.service;


import by.tms.lesson25.calculator.model.Operation;
import by.tms.lesson25.calculator.storage.JsonFileOperationStorage;
import by.tms.lesson25.calculator.storage.OperationStorage;

import java.util.List;

public class OperationService {

    private final OperationStorage operationStorage = new JsonFileOperationStorage();

    public Operation execute(Operation operation) {
        switch (operation.getType()) {
            case "SUM":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "SUB":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "MUL":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "DIV":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.save(operation);
                return operation;
        }
        throw new IllegalArgumentException("by.tms.lesson25.calculator.model.Operation type not supported");
    }

    public List<Operation> getAllOperations() {
        return operationStorage.findAll();
    }
}
