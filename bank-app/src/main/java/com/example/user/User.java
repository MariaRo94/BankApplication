package com.example.user;

import com.example.account.Account;
import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private int id;
    private String login;
    private List<Account> accountList;

    public User(int id, String login, List<Account> accountList) {
        this.id = id;
        this.login = login;
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
