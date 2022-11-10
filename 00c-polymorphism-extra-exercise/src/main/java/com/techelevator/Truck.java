package com.techelevator;

public class Truck implements Vehicle{

    private int numberOfAxles;

    public Truck(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    public double calculateToll(int distance) {
        double toll = 0;
        if (getNumberOfAxles() == 4) {
            toll = 0.040 / distance;
        } else if (getNumberOfAxles() == 6) {
            toll = 0.045 / distance;
        } else if (getNumberOfAxles() >= 8) {
            toll = 0.048 / distance;
        }
        return toll;
    }
}
