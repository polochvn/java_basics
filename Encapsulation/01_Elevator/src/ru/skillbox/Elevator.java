package ru.skillbox;

public class Elevator {
    private int currentFloor;
    private int maxFloor;
    private int minFloor;

    Elevator (int minFloor, int maxFloor) {
        currentFloor = 1;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() { return currentFloor;    }

    public void moveUp () {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void moveDown () {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void move (int floor) {
        if (floor >= currentFloor && floor <= maxFloor) {
            while (floor > currentFloor) {
                moveUp();
                System.out.println("Текущий этаж " + currentFloor);
            }
            } else if (floor <= currentFloor && floor >= minFloor) {
                while (floor < currentFloor) {
                    moveDown();
                    System.out.println("Текущий этаж " + currentFloor);
                }
            } else {
            System.out.println("Неверный этаж!");
        }
    }
}
