package com.company;


import com.example.game.ISaveable;

import java.util.ArrayList;
import java.util.Scanner;

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
             - Use domain for package name when making package
             	- Package name has to correspond to folder path of where it is located: com.test.david  = com>test>david>main.java
			- If make new class but use package name, will make the package with that class in the package already

	     */

//		Series.fibonacci(5);

		String varFour = "private to main";

		Scope scopeInstance = new Scope();
		System.out.println("scope instance is " + scopeInstance.getVarOne());
		System.out.println(varFour);
		scopeInstance.timesTwo();

		/*
			- Making inner class instance type is Outer.Inner for the name
			- Instantiated by instanceOfOuter.new NameOfInner()
			- Need instance of outer before making instance of inner
		 */
		Scope.InnerClass innerClass = scopeInstance.new InnerClass();
		innerClass.timesTwo();


		X x = new X(new Scanner(System.in));
		x.x();
    }

	public static ArrayList<String> readValues() {
		ArrayList<String> values = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		boolean quit = false;
		int index = 0;
		System.out.println("Choose \n" +
				"1 to enter a string \n" +
				"0 to quit"
		);

		while (!quit) {
			System.out.println("Choose an option");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
				case 0:
					quit = true;
					break;
				case 1:
					System.out.println("Enter a string: ");
					String stringInput = scanner.nextLine();
					values.add(index, stringInput);
					break;
			}
		}
		return values;
	}

	/*
    Passing interface as parameter, can use any object that implements the interface
 	*/
	public static void saveObject(ISaveable objectToSave) {
		for (int i = 0; i < objectToSave.write().size(); i++) {
			System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
		}
	}

	public static void loadObject(ISaveable objectToLoad) {
		ArrayList<String> values = readValues();
		objectToLoad.read(values);
	}
}
