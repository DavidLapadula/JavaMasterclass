package com.company;

public class Scope {
    public int publicVar = 0;
    private int varOne = 1;

    /*
        - Way to change access to class, member variable, or member method
        - Java will know to which variable you are referring to based on the scope of the variable
        - Scope can be class level, or method within class level
            - Refers to the variable with the most narrow scope.
            - Java checks current block for variable, if not checks incrementally broader box that encloses each of those code blocks until it finds it then throws an error
            - In inner class can use Outer.this.variable to access class level variable of outer class
        - Use this keyword to use the variable at the class level when using variable with the same name (name shadowed by inner class effects scope)
            - Variable can only shadow one with same name when it is declared within an enclosed block
        - If not the same name, can use just variable name in inner class for variable or method of outer class

        - Inner class has access to all member variables of its containing/parent class
        - Containing class can access fields and methods of contained inner class even if they are private
            - Just need to use instance InnerClass.variableName to get the visibility to extend
            - BUT variable cannot be accessed from class external to containing class when the access is private
            - I.E. private is only allowed in that class or containing class

        - Override in inheritance is very similar; looks for method in class, otherwise looks into superclass
     */

    public Scope() {
        System.out.println("Public var "  + publicVar);
        System.out.println("Private var "  + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int varTwo = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i * varTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();

        System.out.println("Var three from outer class" + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println("Inner class created. Private var is " + varThree);
            System.out.println(varOne);
            System.out.println(Scope.this.varOne);
        }

        public void timesTwo() {
            Scope.this.timesTwo();
            for (int i = 0; i < 10; i++) {
                System.out.println(i * varThree);
            }
        }

    }
}
