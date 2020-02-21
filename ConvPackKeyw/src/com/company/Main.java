package com.company;


import javafx.scene.Node;

public class Main {

    public static void main(String[] args) {
	    /*
	        Naming Conventions
                Packages
                   - lower case, domain name reversed
                   - Cannot have dash in package name
                   - Keywords in java in domain should start with _. i.e switch.com --> com._switch
               Class Names
                    - Camel Case, nouns, start with capitol letter
                Interface
                    - Capital, consider what the methods that implement them will be able to do
                Methods
                    - Mixed Case, verb, reflect the function performed OR result returned
                Constants
                    - Screaming snake case, and declared using the final keyword
                Variable Names
                    - mixedCase, with meaningful name
                Type Parameters
                    - single character capital letter --> like 'T' for generic
                    E (Element) K (key) T (Type) V (Value)
            Packages
                - Package mechanism allows grouping like interfaces and classes together
                - Manage namespace and extends access
                - Find functions provided by package are together
                - Own namespace prevents same class and interface name issue
                - Class and interface have access to each other, but still prevent access from other classes
                - Import package so can user everywhere, use inline import when use same name class twice in same class
                - java.lang auto imported because needed - has class object, as well as Integer and String (other fundamental classes)
                - Can also bundle changes in package updates, without having to change the code
	     */

	    Node node = null;

	    MyWindow myWindow = new MyWindow("Complete Java");
	    myWindow.setVisible(true);
    }
}
