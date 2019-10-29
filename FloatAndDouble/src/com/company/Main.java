package com.company;

public class Main {

    public static void main(String[] args) {
	    float minFloatValue = Float.MIN_VALUE;
	    float maxFloatValue = Float.MAX_VALUE;

        System.out.println("FLoat min " + minFloatValue);
        System.out.println("FLoat max " + maxFloatValue);

        double minDoubleValue = Double.MIN_VALUE;
	    double maxDoubleValue = Double.MAX_VALUE;

        System.out.println("Double min " + minDoubleValue);
        System.out.println("Double max " + maxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;

        System.out.println("My int Value " + myIntValue);
        System.out.println("My float Value " + myFloatValue);
        System.out.println("My double Value " + myDoubleValue);

        // Pounds to kilos
        double pounds = 200d;
        double kilos = pounds * 0.45359237d;
        System.out.println("Pounds to Kilos " + kilos);
    }
}
