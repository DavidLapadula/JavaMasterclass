package com.davidlapadula;

public class Main {

    public static void main(String[] args) {
	  /*
	        - Maps keys to values
	            - Is a collection interface; no duplicate values. Each key can only map to a single value
	                - Put the same key and the old value gets re-written
                - They are generic, take 2 types; one of key and one of value
                - Map key is mutable, so be careful with things that are immutable like Strings
                - Methods
                    - put() and get() will return value or null if it is there
                    - containsKey(): check if exists
                    - keySet(): return all the keys
                    - remove(): returns boolean. pass in key and take it out. Can also pass in key and value and both key/pair has to be there in order to be removed
                    - replace(): replace entry of a key if it already mapped to a value. Pass in third optional argument, 2nd is old value to make sure the right value was updated from the old one
	   */
    }
}
