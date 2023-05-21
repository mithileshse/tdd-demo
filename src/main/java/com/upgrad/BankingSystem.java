package com.upgrad;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankingSystem {

//    db -> account number -> account

    // key value

    // put ("123" ,account)

    // get("123")

    // account
    private static Map<String, Account> accounts = new HashMap<>();

    public String createAccount(String accountHolderName) {
        String accountNumber = generateAccountNumber();
        Account account = new Account();
        accounts.put(accountNumber, account);
        return accountNumber;
    }
    public double deposit(String accountNumber, double amount) {
        if (!accountExists(accountNumber)) {
            throw new IllegalArgumentException("Invalid account number");
        }

        Account account = accounts.get(accountNumber);
        double updatedAmount= account.deposit(amount);
        return updatedAmount;
    }

    public double withdraw(String accountNumber, double amount) {
        if (!accountExists(accountNumber)) {
            throw new IllegalArgumentException("Invalid account number");
        }

        Account account = accounts.get(accountNumber);
        double updatedAmount=account.withdraw(amount);
        return updatedAmount;
    }
    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public double getBalance(String accountNumber) {
        if (!accountExists(accountNumber)) {
            throw new IllegalArgumentException("Invalid account number");
        }

        Account account = accounts.get(accountNumber);
        return account.getBalance();
    }


    private String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }

    public static class Account {
        private static double balance;

        public Account() {
            this.balance = 0.0;
        }

        public double deposit(double amount) {

            // service call deposit

            // db call to deposit
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid deposit amount");
            }
            balance += amount;

            return balance;
        }

        public double withdraw(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
            return balance;
        }

        public double getBalance() {
            return balance;
        }
    }

}
