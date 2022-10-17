package ru.skillbox;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions();
        Cargo cargo = new Cargo(dimensions, 47.87, "", true, "", true);
        System.out.println(cargo);
    }
}
