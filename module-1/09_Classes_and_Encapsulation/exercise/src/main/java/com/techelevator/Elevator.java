package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen = false;

    public Elevator(int numberOfFloors) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor(){
        if (doorOpen == false) {
            doorOpen = true;
        }
    }

    public void closeDoor() {
        if (doorOpen == true) {
            doorOpen = false;
        }
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen) {
            if (desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
                this.currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen) {
            if (desiredFloor >= 1 && desiredFloor < currentFloor) {
                this.currentFloor = desiredFloor;
            }
        }
    }
}
