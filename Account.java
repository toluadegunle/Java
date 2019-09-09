package com.atm.project;

public class Account {
public static Account account;
private static int balance = 1000;
private static Client client;

private Account() {
}

public static Account getAccount(Client c) {
    if (account == null) {
        account = new Account();
    }
    Account.client = c;
    return account;
}

public static int getBal() {
    return balance;
}

public synchronized void withdraw(int bal) {
    try {

        if (balance >= bal) {
            System.out.println(client.getName() + " " + "intends to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance = balance - bal;
            System.out.println(client.getName() + " " + "has completed the withdrawal");
        } else {
            System.out.println(client.getName() + " " + "has insufficient money to withdraw ");
        }
        System.out.println(client.getName() + " " + " withdrew £" + balance);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public synchronized void deposit(int bal) {
    try {
        if (bal > 0) {
            System.out.println(client.getName() + " " + "intends to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance = balance + bal;
            System.out.println(client.getName() + " " + "has completed the deposit");
        } else {
            System.out.println(client.getName() + " " + "has insufficient money to deposit");
        }
        System.out.println(client.getName() + " " + " deposit £" + balance);
    } catch (Exception e) {
        e.printStackTrace();
    }
}}
