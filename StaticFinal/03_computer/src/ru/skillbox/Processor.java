package ru.skillbox;

public class Processor {

    private final double frequency;
    private final int numberCores;
    private final ProcessorManufacturer manufacturer;
    private final double weight;

    public Processor(double frequency, int numberCores, ProcessorManufacturer manufacturer, double weight) {
        this.frequency = frequency;
        this.numberCores = numberCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getNumberCores() {
        return numberCores;
    }

    public ProcessorManufacturer getManufacturer() { return manufacturer; }

    public double getWeight() {
        return weight;
    }
}
