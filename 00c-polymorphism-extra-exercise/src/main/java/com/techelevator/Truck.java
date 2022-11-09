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
        if (numberOfAxles == 4) {
            toll = 0.040 / distance;
        } else if (numberOfAxles == 6) {
            toll = 0.045 / distance;
        } else if (numberOfAxles >= 8) {
            toll = 0.048 / distance;
        }
        return toll;
    }
}
