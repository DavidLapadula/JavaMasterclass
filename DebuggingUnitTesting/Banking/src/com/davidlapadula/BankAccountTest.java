package com.davidlapadula;

import static org.junit.Assert.*;

public class BankAccountTest {

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Starting tests...");
    }

    private BankAccount account;
    @org.junit.Before
    public void setup() {
        account = new BankAccount("David", "Smith", 1000, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);

    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, false);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_atm() throws Exception {
        double balance = account.withdraw(600.00, false);
        fail("Should throw Illegal argument exception");
    }

    @org.junit.Test
    public void getBalance_deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("Not a checking acct", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("Tests completed");
    }

}