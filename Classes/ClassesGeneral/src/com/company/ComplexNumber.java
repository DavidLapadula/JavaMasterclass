package com.company;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        double number = (this.real + real) + (this.imaginary + imaginary);
    }

    public void add(ComplexNumber complexnumber) {
        double real = complexnumber.getReal();
        double imaginary = complexnumber.getImaginary();

        double number = (this.real + real) + (this.imaginary + imaginary);
    }

    public void subtract(double real, double imaginary) {
        double number = (this.real - real) + (this.imaginary - imaginary);
    }

    public void subtract(ComplexNumber complexnumber) {
        double real = complexnumber.getReal();
        double imaginary = complexnumber.getImaginary();

        double number = (this.real - real) + (this.imaginary - imaginary);
    }

}
