package com.company;

public class ValuesReference {
    /*
        Value types hold a value. Single space in memory allocated to store value. And variable holds value
        Reassignment will make a copy that occurs independently

        Reference types are held by reference; hold reference to address but not he object itself
        Cannot access object directly, but only reference to memory
        Copies will just copy the reference
        Only 1 item in memory that both reference are point to

        Method cannot modify a reference itself but it cannot. Can only re initialize with new keyword
        This will make a new item in memory and de-reference the initial reference variable from its previous pos. in memory

     */

    public void valueReference() {
        // value type so both independant
        int myIntValue = 10;
        int anotherValue = myIntValue;

        // both will be modified
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        modifyArray(anotherArray);

    };

    private static void modifyArray(int[] array) {
       array[0] = 2;
       array = new int[] {1, 2, 3, 4, 5};
    };

}
