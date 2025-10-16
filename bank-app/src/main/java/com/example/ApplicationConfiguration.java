package com.example;

import com.example.account.AccountService;
import com.example.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public OperationConsooleListener operationConsooleListener(Scanner scanner,
                                                               UserService userService,
                                                               AccountService accountService) {
        return new OperationConsooleListener(scanner, userService, accountService);
    }

    @Bean
    public UserService userService(AccountService accountService) {
        return new UserService(accountService);
    }

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }


}
