package hw2.oop.induction;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("Starting electricity");
    }

    private void startCommand() {
        System.out.println("Starting command");
    }

    private void startFuelSystem() {
        System.out.println("Starting fuel system");
    }
}
