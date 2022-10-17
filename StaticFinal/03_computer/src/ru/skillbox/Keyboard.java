package ru.skillbox;

public class Keyboard {

    private final KeyboardType type;
    private final boolean isBacklight;
    private final double weight;

    public Keyboard(KeyboardType type, boolean isBacklight, double weight) {
        this.type = type;
        this.isBacklight = isBacklight;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean getIsBacklight() {
        return isBacklight;
    }

    public double getWeight() {
        return weight;
    }
}
