package com.company;

public class Main {

    /*
        Abstract Class
        - Abstraction: functionality without implementing. How it works without worrying about how (that is for what implements the interface
        - Class needs to be abstract to have abstract method
        - Leave rules of implementation to instances. Leave implementation as open as possible
        - Inherent from abstract class forces inheriting class to implement method
        - With interface, the whole thing is abstract without any implementation.
        - Abstract class allows you to have some implementation while methods being abstract
        	- Some functionality for sub classes to override; Interface only allows stating functionality
        	- Class can only extend 1 abstract class, but multiple interfaces
     */

    public static void main(String[] args) {
	    Dog dog = new Dog("Yorkie");
	    dog.breathe();
	    dog.eat();

		Toucan toucan = new Toucan("Toucan");
		toucan.breathe();
		toucan.eat();
		toucan.fly();
    }
}
