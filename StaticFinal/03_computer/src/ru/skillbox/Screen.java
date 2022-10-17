package ru.skillbox;

public class Screen {

    private final int diagonal;
    private final ScreenType type;
    private final double weight;

    public Screen(int diagonal, ScreenType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public ScreenType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }
}
