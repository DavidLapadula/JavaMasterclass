package com.company;

public class Point {
    private int X;
    private int Y;

    public Point () {

    }

    public Point (int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public double distance() {
        return calculateDistance(this.X, this.Y, 0, 0);
    }

    public double distance(int x, int y) {
        return calculateDistance(this.X, this.Y, x, y);
    }

    public double distance(Point point) {
        int x2 = point.getX();
        int y2 = point.getY();
        return calculateDistance(this.X, this.Y, x2, y2);
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        double calculation = (x2 - x1) * (x2 - x1) +  (y2 - y1) * (y2 - y1);
        return Math.sqrt(calculation);
    }
}
