package com.davidlapadula;

import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
	    /*
	        - List: ordered without duplicates
	        - Set: is a generic interface, NO DUPLICATES
	            - Add, remove, clear, size, isEmpty, contains, methods
	            - Cannot key from index; need to loop over it
	            - Set cannot contain element of itself
	            - Hashset: uses hashes to store items. Uses implementation of Hashmap by using key (element added to set) and dummy object as value)
	            - Operations are very fast
	            - Has iteration capability
	            - Set theory
	                - Union is set containing all elements from combining sets; because sets have no duplicates each element only appears once even if present in both sets, this is possible with Set interface
	                - addAll() method can create set union
                - Only REFERENCES to objects stored in the set, could appear in many sets/maps with only 1 instance
                    - Reference to any data type (String, or Class ...) is the same size in memory. So only storing name instead of class adds complexity with no gain because need to retrieve it after
                - If use own class for Key or Value, need to override equal() or else will allow duplicates because not evaluating as equal. If two objects compare equal must also override hashCode because equal objects must have the same hash
                    - Base classes only use basic referential equality that only checks if reference is the same
                    - When object generates hashcode that exists, uses compare to see if it is already thee, which is why it must be overridden
                - In hashed collection, two equal objects must have same hashcode, but unequal objects do not need to have different hashes
                    - Added object must generate same hashcode as others that are equal to it (hasCode method), and this hasCode will be used to find where to put object, and compare will test what is already there
                - Performance of hashing found in the use of different 'buckets' for each hash. If not using hash for each bucket, and is only 1 bucket, need to compare for every element and the performance drops off
	     */

	    HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
	    solarSystem.put(temp.getName(), temp);
	    planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        System.out.println("Planets");
        for (HeavenlyBody planet: planets) {
            System.out.println("\t" +  planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Earth");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" +  jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet: planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon: moons) {
            System.out.println("\t" +  moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
    }
}
