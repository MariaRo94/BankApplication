package com.example.operations.processors;

import com.example.operations.OperationCommandProcessor;
import com.example.user.User;
import com.example.user.UserService;

import java.util.List;

public class ShowAllUsersProcessor implements OperationCommandProcessor {

    private final UserService userService;

    public ShowAllUsersProcessor(UserService userService) {
        this.userService = userService;
    }

    public void processOperation() {
        List<User> users = userService.getAllUsers();
        System.out.println("List of all users:");
        users.forEach(System.out::println);
    }
}
