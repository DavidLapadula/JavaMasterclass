package com.company;

public class Motherboard {
    private String Model;
    private String manufacturer;
    private int ramSlots;
    private int carSlots;
    private String bios;

    public Motherboard(String model, String manufacturer, int ramSlots, int carSlots, String bios) {
        Model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.carSlots = carSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program" + programName + " is loading...");
    };

    public String getModel() {
        return Model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCarSlots() {
        return carSlots;
    }

    public String getBios() {
        return bios;
    }

}
