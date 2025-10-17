package com.example.operations.processors;

import com.example.account.Account;
import com.example.account.AccountService;
import com.example.operations.ConsoleOperationType;
import com.example.operations.OperationCommandProcessor;
import com.example.user.User;
import com.example.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CloseAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private AccountService accountService;
    private UserService userService;

    public CloseAccountProcessor(Scanner scanner, AccountService accountService, UserService userService) {
        this.scanner = scanner;
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter account id to close:");
        int accountId = Integer.parseInt(scanner.nextLine());
        Account account = accountService.closeAccount(accountId);
        User user = userService.findUserById(account.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("No such user with id=%s".formatted(account.getUserId())));
        user.getAccountList().remove(account);
        System.out.println("Account closed successfully: id=%s".formatted(accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}
