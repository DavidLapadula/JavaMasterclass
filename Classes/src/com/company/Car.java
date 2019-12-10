package com.company;

public class Car {
     private int doors;
     private int wheels;
     private String model;
     private String engine;
     private String colour;

     public void setModel(String model) {
         String validModel = model.toLowerCase();
         if(validModel.equals("carerra")) {
             this.model = model;
         } else {
             this.model = "unknown";
         }
     }

     public String getModel() {
         return this.model;
     }
}
