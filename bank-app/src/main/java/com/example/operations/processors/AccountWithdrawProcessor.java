package com.example.operations.processors;

import com.example.account.AccountService;
import com.example.operations.ConsoleOperationType;
import com.example.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountWithdrawProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private AccountService accountService;

    public AccountWithdrawProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter account id:");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to withdraw id=%s: ".formatted(accountId));
        int amountToWithdraw = Integer.parseInt(scanner.nextLine());
        accountService.withDrawFromAccounts(accountId, amountToWithdraw);
        System.out.println("Succesfully withdraw amount=%s to account id=%s".formatted(amountToWithdraw, accountId));


    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
    }
}
