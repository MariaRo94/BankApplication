package com.example.operations.processors;

import com.example.account.AccountService;
import com.example.operations.ConsoleOperationType;
import com.example.operations.OperationCommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountTransferProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final AccountService accountService;

    @Autowired
    public AccountTransferProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    public AccountTransferProcessor(Scanner scanner) {
        this.scanner = scanner;
        this.accountService = null;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter source account id: ");
        int fromAccountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter destination account id: ");
        int toAccountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to transfer: ");
        int amountToTransfer = Integer.parseInt(scanner.nextLine());
        accountService.transfer(fromAccountId, toAccountId, amountToTransfer);
        System.out.println("Sucessfully %s transfered from accountId= %s to accountId%s"
                .formatted(amountToTransfer, fromAccountId, toAccountId));

    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }
}
