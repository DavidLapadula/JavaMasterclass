package com.company;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        // setNext and setPrevious return item being set so can use that to insert into the list

        while(currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            // New item greater, so move right
            if (comparison < 0) {
               if (currentItem.next() != null) {
                   currentItem = currentItem.next();
               } else {
                   // no next so insert at the end of the list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
               }
            } else if (comparison > 0) {
                // new item is less so insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // node with previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present and not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item" + item.getValue());
            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = currentItem.compareTo(item);

                if (comparison == 0) {
                    if (currentItem == this.root) {
                        // Set the new root to the current 2nd item in the list
                        this.root = currentItem.next();
                    } else {
                        // Point previous element to next prior to deletion
                        currentItem.previous().setNext(currentItem.next());
                        if (currentItem.next() != null) {
                            // Point next items previous value to deleted items previous value
                            currentItem.next().setPrevious(currentItem.previous());
                        };
                    };
                    // Item should be deleted from memory here, even though java does own garbage collection
                    return true;
                } else if (comparison < 0) {
                    currentItem = currentItem.next();
                } else {
                   // Item is not in the list
                   return false;
                };
            };
        };
        return false;
    };

    @Override
    public void traverse(ListItem root) {
        if (root == null ){
            System.out.println("Empty list");
        } else {
            while (root != null){
                System.out.println(root.getValue());
                root = root.next();
            };
        };
    }
}
