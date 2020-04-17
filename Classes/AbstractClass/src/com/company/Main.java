package com.company;

public class Main {

    /*
        Abstract Class
        - Abstraction: functionality without implementing. How it works without worrying about how (that is for what implements the interface)
        - Class needs to be abstract to have abstract method
        - Leave rules of implementation to instances. Leave implementation as open as possible
        - Inherent from abstract class forces inheriting class to implement method
        - Abstract class allows you to have some implementation while methods being abstract
        	- Some functionality for sub classes to override and inherit (member values); Interface only allows stating functionality
        	- Class can only extend 1 abstract class, but multiple interfaces. And all variables are public static final
        		- Non-static needs instance to instantiate
		- Exist on all instances, then should be inherited from base class
		- Abstract classes can methods with varying visibility, interface are all public
		- Use when:
			- share code amongst related classes
			- classes that extend to have many common methods
			- base class has default implementation, but other methods can be overridden
			- COMMON DEFINITION of a base class that can be shared

     */

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        String stringData = "Toronto Ottawa Montreal Calgary Vancouver";
        String[] data = stringData.split(" ");
        for (String s: data){
                list.addItem(new Node(s));
        };

        list.traverse(list.getRoot());
    };
};
