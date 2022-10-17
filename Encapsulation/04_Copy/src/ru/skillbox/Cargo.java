package ru.skillbox;

public class Cargo {

    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean propertyOfTurnOver;
    private final String registrationNumber;
    private final boolean fragility;

    public Cargo(Dimensions dimensions,
                 double weight,
                 String deliveryAddress,
                 boolean propertyOfTurnOver,
                 String registrationNumber,
                 boolean fragility) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.propertyOfTurnOver = propertyOfTurnOver;
        this.registrationNumber = registrationNumber;
        this.fragility = fragility;
    }

    public Dimensions getDimensions() { return dimensions;  }

    public  Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyOfTurnOver, registrationNumber, fragility);
    }

    public double getWeight() {
        return weight;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyOfTurnOver, registrationNumber, fragility);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean getPropertyOfTurnOver() {
        return propertyOfTurnOver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean getFragility() {
        return fragility;
    }

    public String toString() {
        return "Габариты груза - " + dimensions.toString() + " м3" + "\n" +
                "Масса груза - " + weight + " кг" + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Свойство переворачиваться: " + propertyOfTurnOver + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкость: " + fragility;
    }
}
