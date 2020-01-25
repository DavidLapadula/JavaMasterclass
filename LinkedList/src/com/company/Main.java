package com.company;

import java.util.ArrayList;

public class Main {
    /*
        Linked List Notes
        - Store link to next element and the data
        - 4 Bytes of memory for each int in an array
        - 8 bytes of memory for each double
        - Index --> address --> holds value
        - Calculate address: Index + (100 x memory allocated)
        - With String because can be variable length
        - Index --> Address --> StringAddress (point in memory with variable amount of data)
        - Garbage collection: frees up memory when values in address are out of scope
        - the addresses do not need to be contiguous. The indexes are for the array, but the memory spaces they point to are not
        - With array need to shift all up when add, or shift down when one is removed
        - Object not being used in LL with be auto destroyed by garbage collection
        - Java has native impl of LL. More efficient for add/remove because do not need to shift items
        - Methods shouldnt return a value AND modify object it was passed
        - Double LL - store reference to previous and next
     */

    public static void main(String[] args) {

        Customer customer = new Customer("David", 55.96);
        Customer anotherCustomer;
        // Reassignment doesnt create a second class. The memory address is just pointed to the first class
        // Cannot point to new object directly
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        // Add at the first index to insert, requires moving all the other entries down
        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }


    }
}
