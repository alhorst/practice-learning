package com.techelevator;

public class Bus {
    //member variables
    private String routeName= "";
    private int passengers;
    private double gallonsOfGas = 40.0;
    private boolean isDoorOpen = false;
    private int totalSeats = 50;


    //constructors
    //this constructor is an overloaded constructor because we've passed an argument in and changed it
    public Bus(String routeName) {
        this.routeName = routeName;
    }
    //this constructor takes no arguments so we can create bus w/o routeName
    public Bus(){}


    //getters and setters
    public String getRouteName() {
        return routeName;
    }
    public double getGallonsOfGas() {
        return gallonsOfGas;
    }
    public boolean isDoorOpen() {
        return isDoorOpen;
    }
    //add this. keyword when referring to member variable
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void openDoor() {
        isDoorOpen = true;
    }

    public void closeDoor() {
        isDoorOpen = false;
    }


    //derived property
    public int getRemainingSeats() {
       return totalSeats - passengers;
    }


    //behavior, can have private methods like worker methods
    public boolean board() {
        if(passengers < totalSeats && isDoorOpen) {
            passengers++;
            return true;
        }
        return false;
    }
}

