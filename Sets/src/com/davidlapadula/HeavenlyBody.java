package com.davidlapadula;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
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

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // Careful to override the method and not overload it by changing the object signature
    @Override
    public boolean equals(Object obj) {
        // Same object in memory will return true
        if (this == obj) return true;

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        // Cast object to Heavenly body (this class) to get name and then compare it
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    // String class has hasCode method to generate a hashcode from that specific string, and then add number to guarantee unique
    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }
}
