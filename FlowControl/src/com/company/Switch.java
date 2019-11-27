package com.company;

public class Switch {
    public static void basicSwitch() {
            int switchValue = 1;

            switch (switchValue) {
                case 1:
                    System.out.println("Case is 1");
                    break;
                case 2:
                    System.out.println("Case is 2");
                    break;
                default:
                    System.out.println("Not anything");
                    break;
            }
    }

    public static void charSwitch() {
        char switchValue = 'A';

        switch (switchValue) {
            case 'A':
                System.out.println("Case is A");
                break;
            case 'B':
                System.out.println("Case is B");
                break;
            default:
                System.out.println("Neither A nor B");
                break;
        }
    }
}
