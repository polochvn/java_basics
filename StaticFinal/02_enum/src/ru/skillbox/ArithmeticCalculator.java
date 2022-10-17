package ru.skillbox;

public class ArithmeticCalculator {

    private final int a;
    private final int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calculate(Operation type) {

        if (type == Operation.ADD) {
            System.out.println("Сумма чисел " + (a + b));
        } else if (type == Operation.SUBTRACT) {
            System.out.println("Разность чисел " + (a - b));
        } else System.out.println("Умножение чисел " + (a * b));
   }
}
