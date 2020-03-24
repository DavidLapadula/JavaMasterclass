package com.davidlapadula;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

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
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        // prevent code that calls this function from having access to original object
        return new HashSet<>(satellites);
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    // Restrict type of moon that can be added by specific heavenly body in the instance of that subclass
    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // Note: makes these final so cannot be overridden by instances of this class

    // Careful to override the method and not overload it by changing the object signature
    // Cast compared object to this type and then use properties to see if they are the same
    @Override
    public final boolean equals(Object obj) {
        // Same object in memory will return true
        if (this == obj) return true;

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if (this.name.equals(theObject.getName())) {
                return this.bodyType == theObject.getBodyType();
            }
        }
        return false;
    }

    // String class has hasCode method to generate a hashcode from that specific string, and then add number to guarantee unique
    // Enums have a built in hashcode, to make truly unique
    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    // Object used in toString, java will call toString on that object to display it
    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
