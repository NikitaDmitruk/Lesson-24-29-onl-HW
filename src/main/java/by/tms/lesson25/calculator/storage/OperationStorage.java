package by.tms.lesson25.calculator.storage;


import by.tms.lesson25.calculator.model.Operation;

import java.util.List;

public interface OperationStorage {
    void save(Operation operation);
    List<Operation> findAll();
}
