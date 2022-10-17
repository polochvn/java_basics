package ru.skillbox;

public class HardDisc {

    private final HardDiscType type;
    private final int volumeMemory;
    private final double weight;

    public HardDisc(HardDiscType type, int volumeMemory, double weight) {
        this.type = type;
        this.volumeMemory = volumeMemory;
        this.weight = weight;
    }

    public HardDiscType getType() {
        return type;
    }

    public int getVolumeMemory() {
        return volumeMemory;
    }

    public double getWeight() {
        return weight;
    }
}
