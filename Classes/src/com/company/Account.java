package com.company;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    public Account() {
        this("456789", 0.00, "John", "john@email.com", "4165569985");
    };

    public Account(String number, double balance, String customerName, String customerEmailAddress, String customerPhoneNumber) {
            this.number = number;
            this.balance = balance;
            this.customerName = customerName;
            this.customerEmailAddress = customerEmailAddress;
            this.customerPhoneNumber = customerPhoneNumber;
    }

    public void deposit(double depositAmount) {
        System.out.println("Deposit Processed");
       this.balance += depositAmount;
    };

    public void withDrawal(double withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0)  {
            System.out.println("Insufficient funds. Only " + this.balance + " available");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal processed");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
