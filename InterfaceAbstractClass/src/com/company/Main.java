package com.company;

public class Main {
    /*
         - Interface: methods that class that implements must implement
                - Abstract: no actual code, just name and parameter. Code still goes in the class
                - Common behaviour for all class that implements them
                - Commitment that method signatures and variables are not going to change
                - Access modifiers in interface are redundant; those are for the class, so in interface do not need them
                - Methods will be overridden in class that implements because making specific behaviour in the class
                - When making a new class that implements I - name of I is the type, but new called on class that implements it
                    - Interface is for which methods are valid (cannot be instantiated)
                    - The implementation is the specific type that implements it

     */

    public static void main(String[] args) {
            ITelephone timsPhone;
            timsPhone = new DeskPhone(123456);
            timsPhone.powerOn();
            timsPhone.callPhone(123456789);
    }
}
