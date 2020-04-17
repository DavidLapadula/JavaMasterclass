package com.company;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2; // 3
        System.out.println("1 + 2 = " +  result);

        int prevResult = result - 1;
        System.out.println("Prev result - 1 = " +  prevResult);

        result = result - 2;

        System.out.println("New result = " + result);

        // Modulus operator
        int modulusVal = 21;
        System.out.println("Modulus test should be one " + modulusVal % 4);

        // Abbreviations
        int abbreviatedValue = 10;
        System.out.println("Add " + abbreviatedValue++ );
        System.out.println("Subtract " + abbreviatedValue--);
        System.out.println("Add 2 " + (abbreviatedValue += 2));
        System.out.println("Subtract 2 " + (abbreviatedValue -= 2));
        System.out.println("Divide " + (abbreviatedValue *= 2));
        System.out.println("Multiply " + ( abbreviatedValue /+ 2));

        // If then statement
        boolean isCool = false;
            if (isCool == false)
            {
                System.out.println("Is Cool");
            }

        // And operator
        int bottomScore = 50;
        int topScore = 100;

        if (topScore == 100 && bottomScore == 50 )
        {
            System.out.println("Top and bottom score right");
        }

        if (topScore >= bottomScore) {
            System.out.println("Top and bottom in right order");
        }

        // Operator precedence
        double twenty = 20.00d;
        double eighty = 80.00d;
        double expression = (twenty + eighty) * 100d;
        double remainder = expression % 40;
        boolean zeroRemainder = remainder == 0 ? true : false;

        System.out.println("Is zero remainder = " + zeroRemainder);

        if (!zeroRemainder)
        {
            System.out.println("Got some remainder");
        }


    }
}
