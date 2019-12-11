package com.company;

public class Main {

    public static void main(String[] args) {

        // Using test class
	    Car porsche = new Car();
	    porsche.setModel("Carrera");

	    // Test account features
        Account davidAccount = new Account();
        davidAccount.withDrawal(100);

        Account otherAccount = new Account("123456", 0.00, "David", "david@email.com", "4165569985");

        System.out.println(otherAccount.getCustomerName());

        Account nextAccount = new Account();

        System.out.println(nextAccount.getCustomerName());


    }
}
