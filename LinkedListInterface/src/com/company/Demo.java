package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Montreal");
        placesToVisit.add("Ottawa");
        placesToVisit.add("Toronto");
        placesToVisit.add("Vancouver");

        printList(placesToVisit);

        // LL still uses indexing to CRUD
        placesToVisit.add(1, "Calgary");
        printList(placesToVisit);

        placesToVisit.remove(4);
    }

    private static void printList(LinkedList<String> linkedList) {
        // Iterator is native class, and LL has iterator to traverse the LL
        Iterator<String> i = linkedList.iterator();

        while (i.hasNext()) {
            System.out.println("Now visting" + i.next());
        };
    }

    /*
        String list iterator has compare to function, similar to sort that will
        return 0 if same, > 0 if greater than, and < 0 if less than
        Need to use next to go to the next entry
        Iterator will hover between items in LL that would be next/previous to prevent infinite loop
        - (tortiose and hare algo) to detect loop problems in LL

     */
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            // next will automatically move to the next entry
            int comparison = stringListIterator.next().compareTo(newCity);

            // Equal so do not add
            if (comparison == 0) {
                System.out.println(newCity + " is already included");
                return false;
            } else if (comparison > 0) {
                // new city appears before that one
                // List iterator allows to go back; already used next in compare to
                // Add will put it in that index and reassign items
                stringListIterator.previous();
                stringListIterator.add(newCity);
            } else if (comparison < 0) {
                // move on to the next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    /*
        Additional boolean to point the iterator in the direction you want to go
        Because pointer floats between next and previous (how it gets next() and previous())
        Need to check which direction currently travelling to reassign the next or previous value
        Ex. If going forward, but travelling back need to point next() to the item after where you just came from
     */
    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities itinerary");
        } else {
            System.out.println("Now visting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println(
                    "0 - to quit\n" +
                    "1 - go to next city\n" +
                    "2 - go  to previous city\n" +
                    "3 - print menu options\n"
                );
    }
}
