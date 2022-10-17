package ru.skillbox;

public class RAM {

    private final RandomAccessMemoryType type;
    private final int volumeMemory;
    private final double weight;

    public RAM(RandomAccessMemoryType type, int volume, double weight) {
        this.type = type;
        this.volumeMemory = volume;
        this.weight = weight;
    }

    public RandomAccessMemoryType getType() {  return type;    }

    public int getVolumeMemory() {
        return volumeMemory;
    }

    public double getWeight() {
        return weight;
    }
}
