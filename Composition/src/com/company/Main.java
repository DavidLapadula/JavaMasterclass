package com.company;

public class Main {

    public static void main(String[] args) {
            // Classes for new PC
                Dimensions dimensions = new Dimensions(20, 20, 5);
                Case theCase = new Case("220B", "Dell", "240", dimensions);
                Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
                Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

            // Compose the PC
                PC thePC = new PC(theCase, theMonitor, theMotherboard);
                thePC.powerUp();

            // Classes for new room
                Wall wall1 = new Wall("West");
                Wall wall2 = new Wall("South");
                Wall wall3 = new Wall("East");
                Wall wall4 = new Wall("North");
                Ceiling ceiling = new Ceiling(12, 55);
                Bed bed = new Bed("Modern", 4, 3, 2, 1);
                Lamp lamp = new Lamp("Classic", false, 75);

            // Compose the bedroom
                Bedroom bedroom = new Bedroom("David's", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
                bedroom.makeBed();
                bedroom.getLamp().turnOn();

    }
}
