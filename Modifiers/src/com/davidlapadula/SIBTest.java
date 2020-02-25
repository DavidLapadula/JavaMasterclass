package com.davidlapadula;

public class SIBTest {
    public static final String owner;

    static {
        owner = "David";
        System.out.println("SIB Initialization");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
