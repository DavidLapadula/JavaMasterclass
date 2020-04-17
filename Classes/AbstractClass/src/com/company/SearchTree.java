package com.company;

public class SearchTree implements NodeList {

    /*
        - No reference to where came from in BST
        - Iterative search difficult
        - Definition that includes object in own definition is recursive
        - Any recursive definition can be processed recursively
     */
   private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    };

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    /*
        - With tree always insert at end of tree
        - Set the value of currentItem to see where it should be set in the BT
     */
    @Override
    public boolean addItem(ListItem newItem) {
            if (this.root == null){
                this.root = newItem;
            }

            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = (currentItem.compareTo(newItem));

                if (comparison < 0) {
                    if (currentItem.next() != null) {
                        currentItem = currentItem.next();
                    } else {
                        currentItem.setNext(newItem);
                        return true;
                    }
                } else if (comparison > 0) {
                    if (currentItem.previous() != null) {
                        currentItem = currentItem.previous();
                    } else {
                        currentItem.setPrevious(newItem);
                        return true;
                    }
                } else {
                    System.out.println(newItem.getValue() + " is already present");
                }
            }
            return false;
    }

    /*
        - Move to right sub tree and find smallest value (move left until find node with no left child)
        - Set item to be deleted to that value; everything to the left is already smaller than that (because came from left)
        - And everything to the right is greater because it was the smallest value from that side
        - Smallest item is the one with no right child (traverse down left)
     */

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item" + item.getValue());

            ListItem currentItem = this.root;
            ListItem parentItem = currentItem;

            while(currentItem != null) {
                int comparison = (currentItem.compareTo(item));

                if (comparison < 0) {
                    parentItem = currentItem;
                    currentItem = currentItem.next();
                } else if (comparison > 0) {
                    parentItem = currentItem;
                    currentItem = currentItem.previous();
                } else {
                    performRemoval(currentItem, parentItem);
                    return true; 
                }
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree
            if (parent.next() == item){
                // item is right child of parent
                parent.setNext(item.previous());
            } else if(parent.previous() == item) {
                // item is left child of parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, so looking at the root of the tree
                this.root = item.previous();
            }
        } else if(item.previous() == null) {
            // no left tree, so make parent point to the right tree
            if (parent.next() == item) {
                // item is right child of parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of parent
                parent.setPrevious(item.next());
            }
        } else {
            // left and right are both not null
            ListItem current = item.next();
            ListItem leftmostParent = item;

            // Traverse down right sub tree and find the smallest value
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }

            // put smallest value in node to be deleted
            item.setValue(current.getValue());
            // delete the smallest
            if (leftmostParent == item) {
                // no leftmost node, so current points to the smallest (so delete it)
                item.setNext(current.next());
            } else {
                // set smallest nodes parent to point to smallest nodes right child
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null ) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
};
