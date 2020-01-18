package com.company;

import java.util.ArrayList;

public class GroceryList {
    private static ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    };

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items");

        for (int i = 0; i < groceryList.size(); i++ ) {
            System.out.println(groceryList.get(i));
        };
    };


    public void modifyGroceryItem(String newItem, int position) {
       groceryList.set(position, newItem);
    };

    public static ArrayList<String> getGroceryList() {
       return groceryList;
    };

    public void removeGroceryItem(int position) {
        groceryList.remove(position);
    };

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);

        if (position >= 0) {
           return groceryList.get(position);
       };
       return null;
    };

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(getGroceryList());

        String[] myArray = new String[getGroceryList().size()];
        myArray = getGroceryList().toArray(myArray);
    };
}
