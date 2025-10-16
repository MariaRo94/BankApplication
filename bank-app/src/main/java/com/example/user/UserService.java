package com.example.user;

import com.example.account.AccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UserService {

    private final Map<Integer, User> userMap;
    private Set<String> takenLogins;
    private int idCounter;
    private final AccountService accountService;

    public UserService(AccountService accountService) {
        this.accountService = accountService;
        this.userMap = new HashMap<>();
        this.idCounter = 0;
        takenLogins = new HashSet<>();
    }

    public User createUser(String login) {
        if (takenLogins.contains(login)){
            throw new IllegalArgumentException("User already exists, login=%s".formatted(login));
        }
        takenLogins.add(login);

        idCounter++;
        var newUser = new User(idCounter, login, new ArrayList<>());

        var newAccount = accountService.createAccount(newUser);
        newUser.getAccountList().add(newAccount);

        userMap.put(newUser.getId(), newUser);
        return newUser;
    }

    public Optional<User> findUserById(int userId) {
        return Optional.ofNullable(userMap.get(idCounter));
    }

    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }
}
