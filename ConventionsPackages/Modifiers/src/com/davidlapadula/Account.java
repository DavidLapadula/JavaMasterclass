package com.davidlapadula;

import java.util.ArrayList;

public class Account {
    public String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName, ArrayList<Integer> transactions) {
        this.accountName = accountName;
        this.transactions = transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            balance += amount;
            System.out.println("Deposited and amount" + amount + balance);
        } else {
            System.out.println("not enough");
        }
    }

    // Just put minus infront to make it a negative
    public void withdrawal(int amount) {
        int withdrawal = -amount;

        if (withdrawal < 0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println("Withdrawal" + amount);
        } else {
            System.out.println("Cannot withdraw negative sums");
        }
    }

    public void calculateBalance() {
        int balance = 0;

        for (int i : this.transactions) {
            this.balance += i;
        }

        System.out.println("Balance" + balance);
    }
}
