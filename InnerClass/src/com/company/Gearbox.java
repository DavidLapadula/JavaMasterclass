package com.company;

import java.util.ArrayList;

    /*
         - User an inner class because does not make sense to have gear as a standalone class outside of a gearbox
         - Should only exist in a gearbox so it is nested
         - Doesnt make sense to refer to something unless it is together with it
         - Inner class has access to all fields of parent class, BUT 'this' refers to the context of the inner class
         - When variable is the same as outer class, the declaration is shadowed. Need to user Outerclass.value to access
         - When making instance of inner class, need to use instance of outer class. Instance of outer class is required
            - Use Outer.inner for type, and then instanceOfOuter.new to make the outer class
     -
     */

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        /*
            Initialized instances of inner class in constructor
         */
        for (int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    /*
        How to access inner private class without exposing it
     */
    public void addGear(int number, double ratio) {
        if ((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if ((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Scream");
            return 0.0;
        }
        return revs * this.gears.get(currentGear).getRatio();
    }

    private class Gear {
        int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        }

        public double getRatio() {
            return ratio;
        }
    }
}
