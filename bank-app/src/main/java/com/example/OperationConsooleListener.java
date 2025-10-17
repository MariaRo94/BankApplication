package com.example;

import com.example.account.AccountService;
import com.example.operations.ConsoleOperationType;
import com.example.operations.OperationCommandProcessor;
import com.example.user.User;
import com.example.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class OperationConsooleListener {

    private final Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommandProcessor> processorMap;
    List<OperationCommandProcessor> processorList;

    public OperationConsooleListener(
            Scanner scanner, List<OperationCommandProcessor> processorList

    ) {
        this.scanner = scanner;
        this.processorMap = processorList
                .stream()
                .collect(Collectors.toMap(OperationCommandProcessor::getOperationType, processor -> processor)
                );

    }

    public void start() {
        System.out.println("Console listener started");

    }

    public void end() {
        System.out.println("Console listener end listen");

    }


    public void listenUpdates() {
        while (!Thread.currentThread().isInterrupted()) {
            var operationType = listenNextOperation();
            if(operationType == null){
                return;
            }
            processNextOperation(operationType);
        }
    }

    private ConsoleOperationType listenNextOperation() {
        System.out.println("Please type next operation: \n");
        printAllAvailableOperations();
        System.out.println();
        while (!Thread.currentThread().isInterrupted()) {
            var nextOperation = scanner.nextLine();
            try {
                return ConsoleOperationType.valueOf(nextOperation);

            } catch (IllegalArgumentException e) {
                System.out.println("No such command found: " + nextOperation);

            }
        }
        return null;
    }

    private void printAllAvailableOperations() {
        processorMap.keySet().forEach(System.out::println);
    }


    public void processNextOperation(ConsoleOperationType operation) {
        try {
            var processor = processorMap.get(operation);
            processor.processOperation();
        } catch (Exception e) {
            System.out.println("Error executing command" + e.getMessage());
        }
    }

}
