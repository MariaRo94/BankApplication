package com.example.operations.processors;

import com.example.operations.OperationCommandProcessor;
import com.example.user.User;
import com.example.user.UserService;

import java.util.Scanner;

public class CreateUserProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final UserService userService;

    public CreateUserProcessor(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter login for new user:");
        String login = scanner.nextLine();
        User user = userService.createUser(login);
        System.out.println("User created: "+ user.toString());
    }
}
