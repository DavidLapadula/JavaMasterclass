package com.davidlapadula;

public class Main {
    /*
        If do not restrict access, any user of the class can modify
         - Use getters and setters instead

     - Granted at top level: cannot have private class at top level
       - public: available to all classes everywhere, whether in the same package or an imported package (member or package level)
       - package-private: only available within its own package and available to all classes in that package (default) even if do not put public in front of class name NOT external packages
            - no access modifier will still work
            - no access from classes in external packages
       - private: ONLY in class declared, not even in subclasses of that class
       - protected: anywhere in its own package, also in subclasses instantiated in another package

       - Static field
            - Class variable
            - Class variable - associated with class and not instance; only ever 1 instance because 1 copy in memory
                 - All instances of class share the same copy of that item
            - If method is static, can access method WITHOUT instance of the class, just reference the class name
            - This is why psvm is static; before program runs, no instances, so needs to call method which does not require instance to work
                - Can run from command line with java com.davidlapadula.Main - Main does not have to be entry point with psvm but is convention for ease
            - Non static method or field cannot be referenced from non-static context BECAUSE static fields do not need class instance to be referenced - so non-static fields referenced there might not exist yet
     */
    public static int multiplier = 7;

    public static void main(String[] args) {

//        StaticTest firstInstance = new StaticTest("First");
//        System.out.println(firstInstance.getName() + " instance number " + StaticTest.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("Second");
//        System.out.println(secondInstance.getName() + " instance number " + StaticTest.getNumInstances());

        int answer = multiply(6);
        System.out.println(multiplier);

    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
