package com.example;

import com.example.account.AccountService;
import com.example.user.User;
import com.example.user.UserService;

import java.util.List;
import java.util.Scanner;

public class OperationConsooleListener {

    private final Scanner scanner;
    private final UserService userService;
    private final AccountService accountService;

    public OperationConsooleListener(Scanner scanner, UserService userService, AccountService accountService) {
        this.scanner = scanner;
        this.userService = userService;
        this.accountService = accountService;

    }


    public void listenUpdate() {
        System.out.println("Please type operations");
        while (true) {
            try {
                var operationType = listenNextOperation();
                processNextOperation(operationType);
            } catch (Exception e) {
                System.out.println("Error executing command" + e.getMessage());
            }
        }
    }

    private String listenNextOperation() {
        System.out.println("Please type next operation: \n");
        return scanner.nextLine();
    }

    public void processNextOperation(String operation) {

        if (operation.equals("USER_CREATE")) {
            System.out.println("Enter login for new user:");
            String login = scanner.nextLine();
            User user = userService.createUser(login);
            System.out.println("User created: "+ user.toString());
        }
        else if (operation.equals("SHOW_ALL_USERS")) {
            List<User> users = userService.getAllUsers();
            System.out.println("List of all users");
            users.forEach(System.out::println);
        }
        else if(operation.equals("ACCOUNT_CREATE")){
            System.out.println("Enter the user id for which to create account:");
            int userId = Integer.parseInt(scanner.nextLine());
            var user = userService.findUserById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("No such user with id=%s".formatted(userId)));

            var account = accountService.createAccount(user);
            user.getAccountList().add(account);
            System.out.println("New account created with id=%s for user=%s".formatted(account.getId(), user.getLogin()));


        }
        else {
            System.out.println("Not found operation");

        }
    }

}
