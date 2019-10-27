package com.company;

public class Main {

    public static void main(String[] args) {
	 int myValue = 10000;

	    int myMinIntValue = Integer.MIN_VALUE;
	    int myMaxIntValue = Integer.MAX_VALUE + 1;

		System.out.println("Integer min "  + myMinIntValue);
		System.out.println("Integer max "  + myMaxIntValue);
		System.out.println("Max overload" + (myMaxIntValue + 1));
		System.out.println("Min overload" + (myMinIntValue - 1 ));

		byte myMinByteValue = Byte.MIN_VALUE;
		byte myMaxByteValue = Byte.MAX_VALUE;

		System.out.println("Byte min value " + myMinByteValue);
		System.out.println("Byte max value " + myMaxByteValue);

		short myMinShortValue = Short.MIN_VALUE;
		short myMaxShortValue = Short.MAX_VALUE;

		System.out.println("Short min value " + myMinShortValue);
		System.out.println("Short max value " + myMaxShortValue);

		long myLongValue = 100L;

		long myMinLongValue = Long.MIN_VALUE;
		long myMaxLongValue = Long.MAX_VALUE;

		System.out.println("Long min value " + myMinLongValue);
		System.out.println("Long max value " + myMaxLongValue);

		int myTotal = (myMinIntValue / 2);
		byte myNewByteValue = (byte) (myMinByteValue / 2);

		short myNewShortValue = (short) (myMinShortValue / 2);

		// Arithmetic Challenge
            byte testByteVal = 10;
            short testShortVal = 20;
            int testIntVal = 50;

            long result = 50000L + (10L * ( testByteVal + testShortVal + testIntVal));

        System.out.println(result);


    }
}
