package com.atm.project;

import java.util.logging.Level;
import java.util.logging.Logger;

//public class ATMThread 

public class ATMThread extends Thread implements Runnable {

private Client client;

public ATMThread(Client c) {
    this.client = c;
}

public static void main(String[] args) {

    ATMThread ts1 = new ATMThread(new Client("client 1"));
    ts1.start();
    ATMThread ts2 = new ATMThread(new Client("client 2"));
    ts2.start();
    ATMThread ts3 = new ATMThread(new Client("client 3"));
    ts3.start();

}

@Override
public void run() {
    for (int i = 0; i < 3; i++) {
        try {
            Account acc = Account.getAccount(client);
            acc.withdraw(100);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ATMThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (acc.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            acc.deposit(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    System.out.println("Final Acc balance is £." + Account.getBal());
}}
