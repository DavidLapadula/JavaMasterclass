package com.davidlapadula;

// Package private access: so all classes in this package
interface Accessible {
    // Interface -variables- are -public static final- by default
    int SOME_CONSTANT = 100;
    // available anywhere
    public void methodA();
    // Interface -methods- are public, because whole point of interface is to implement methods
    // If interface is package-private, methods will have the same access modifier because interface will not be visible
    void methodB();
    boolean methodC();
}
