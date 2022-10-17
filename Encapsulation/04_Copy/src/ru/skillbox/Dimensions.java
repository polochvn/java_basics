package ru.skillbox;

public class Dimensions {
    private final double width;
    private final double length;
    private final double height;
    private double volume;

    public Dimensions(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Dimensions() {
        width = 5.6;
        length = 7.8;
        height = 2.1;

    }

    public Dimensions setWidth(double width) {
        return new Dimensions(width, length, height);
    }

    public double getWidth() {
        return width;
    }

    public Dimensions setLength(double length) { return new Dimensions(width, length, height); }

    public double getLength() {
        return length;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(width, length, height);
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "V = " + (volume = width * length * height);
    }
}
