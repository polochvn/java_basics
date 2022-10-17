package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(-23,72);
        calculator.calculate(Operation.ADD);
        calculator.calculate(Operation.MULTIPLY);
        calculator.calculate(Operation.SUBTRACT);
    }
}
