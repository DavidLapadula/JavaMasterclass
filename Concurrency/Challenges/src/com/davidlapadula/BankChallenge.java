package com.davidlapadula;

public class BankChallenge {
    public static void main(String[] args) {
        final BankAccount account1 = new BankAccount("123-456", 1000);
        final BankAccount account2 = new BankAccount("456-123", 1000);
        final ReentrantBankAccount account3 = new ReentrantBankAccount("456-123", 1000);

        Thread t1 = new Thread() {
            public void run() {
                account1.deposit(300.00);
                account1.withdraw(50.00);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                account1.deposit(203.75);
                account1.withdraw(100.00);
            }
        };

        t1.start();
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                account2.deposit(300.00);
                account2.withdraw(50.00);
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                account2.deposit(203.75);
                account2.withdraw(100.00);
            }
        });

        t3.start();
        t4.start();

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                account3.deposit(300.00);
                account3.withdraw(50.00);
            }
        });

        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                account3.deposit(203.75);
                account3.withdraw(100.00);
            }
        });

        t5.start();
        t6.start();




    }
}
