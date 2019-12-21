package com.company;

public class Outlander extends Car {

    private int roadService;

    public Outlander (int roadService) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadService = roadService;
    }
}
