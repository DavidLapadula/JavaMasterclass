package com.davidlapadula;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    // Enum is a type, so can validate against it. Error at compile time if type is invalid
    // Nested enum automatically static, can refer to without instance
    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        // prevent code that calls this function from having access to original object
        return new HashSet<>(satellites);
    }


    // Restrict type of moon that can be added by specific heavenly body in the instance of that subclass
    public boolean addSatellite(HeavenlyBody moon) {

        return this.satellites.add(moon);
    }

    public Key getKey() {
        return key;
    }

    // Note: makes these final so cannot be overridden by instances of this class, but can be overidden by inner class
    // Careful to override the method and not overload it by changing the object signature
    // Cast compared object to this type and then use properties to see if they are the same
    @Override
    public final boolean equals(Object obj) {
        // Same object in memory will return true
        if (this == obj) return true;

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    // String class has hasCode method to generate a hashcode from that specific string, and then add number to guarantee unique
    // Enums have a built in hashcode, to make truly unique
    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    // Object used in toString, java will call toString on that object to display it
    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    // Static so can get key without needing instance of it
    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key (name, bodyType);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
