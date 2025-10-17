package com.example.operations;

public interface OperationCommandProcessor {
    void processOperation();
    ConsoleOperationType getOperationType();
}
