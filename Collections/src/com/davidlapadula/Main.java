package com.davidlapadula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    /*
	        - Collections framework
	            - Static methods work on collections
	            - Interfaces - enforce methods on all collections and allow them to be extended
	            - Allow interoperability between other collections
	            - Algorithms that work on objects that implement Collections interface
            - If use collection for DS, because Collection is an interface can use any of classes that implements it as interface (set, list, queue, deque)
            - BUT to implement needs to be at the same level of the collections hierarchy
            - Comparable interface allows the use of binary search when 'compareTo' method is overridden
                - Ex. String has built in compareTo method
            - Methods
                - BS needs list to be sorted; items in a collection can be sorted with .sort as long as items implement comparable interface
                - Copy list will only copy one into another of the exact same size
                - In array list ArrayList<>(seats) - seats will create a shallow copy of the list passed to the constructor.
                    - Contents are the same objects in each of the lists. NOT distinct items with shallow copy
                    - Separate references (diff array lists) to the same underlying objects

            - Sort and randomize
                - Collections.reverse()
                - Collections.shuffle()
                - Collections.min() & max - contain sort order that is contained by the compareTo method that must be there. Does not need to be sorted
                - Collections.sort(list, compareMethod)
                    - Second argument is compare method

            - Collections copy method
                - Takes destination and source list; destination needs to be of generic type that is superset of source list
                -  Source must be a list
                - Need to have actual objects in the destination, cannot just allocate space they need to be there
                - Destination needs to have been initialized with enough elements first

            - Comparator
                - Interface that defines single method called compare
                - Object that are going to be sorted DO NOT need to implement it
                - Object of TYPE comparator can implement sort method
                -
	     */

	    Theatre theatre = new Theatre("Olympian", 8, 12);

    }

    /*
        Implementation of bubble sort
            - Bubble sort requires far less memory than merge sort
            - Inner loop starts at position outer loop has reached
            - compareTo should return < 0 if object should short less than object compared to, > 0 if sort for more, 0 for even.
                - If compareTo working like this, object implementing it (so containing class) can be sorted
            - String compareTo in built method returns exactly this
     */
    /*
          public static void sortList(List<? extends Theatre.Seat> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size() ; j++){
                    if(list.get(i).compareTo(list.get(j)) > 0) {
                        Collections.swap(list, i, j);
                    }
                }
            }
        }
     */
}
