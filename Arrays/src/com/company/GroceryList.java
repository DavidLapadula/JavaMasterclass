package com.company;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

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

    public void removeGroceryItem(int position) {
        groceryList.remove(position);
    };
}
