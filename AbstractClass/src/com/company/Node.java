package com.company;

public class Node extends ListItem {

    /*
        Node is instance of list item
     */
    public Node(Object value) {
        super(value);
    };

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    // String has compareTo built in
    @Override
    int compareTo(ListItem item) {
        if (item != null) {
           return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
};
