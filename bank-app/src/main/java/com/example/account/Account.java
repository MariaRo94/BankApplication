package com.example.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private final int id;
    private int moneyAmount;
    private final int userId;

    public Account(int id, int userId, int moneyAmount) {
        this.id = id;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", moneyAmount=" + moneyAmount +
                ", userId=" + userId +
                '}';
    }
}
