package com.company;

import java.util.*;

public class Main {
    /*
        Linked List with interfaces
         - Can switch between interfaces as long as they support the same methods
         - So can switch between Linked List and list easily because the LL implements base list interface
         - All types of list implement the base List class
            - So use generic list as data type, and the variable is the type of list that you need
        - Object of final class to object it is extending or implementing (decide between extending ir implementing)
        - Can-do is relationship of class to object that is being extended or implemented. So a mobile phone can-telephone, and a deskphone can-telephone
            so both should extend class interface
        - NO multiple inheritance from base class, but class can implement multiple interfaces
     */

    public static void main(String[] args) {

        Customer customer = new Customer("David", 55.96);
        Customer anotherCustomer;
        // Reassignment doesnt create a second class. The memory address is just pointed to the first class
        // Cannot point to new object directly
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        // Add at the first index to insert, requires moving all the other entries down
        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }


    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner (System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing" + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("we have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we have reached the end of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("At the beginning of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("At the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        // When delete, make sure there is a nex
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println(
                "0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current\n" +
                "4 - list the songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist\n"
        );
    }

    /*
        Iterator can only go forward through the list like a regular iterator
        List iterator allows us to go forward and back
     */
    private static void printList(List<Song> playList) {
        Iterator iterator = playList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
