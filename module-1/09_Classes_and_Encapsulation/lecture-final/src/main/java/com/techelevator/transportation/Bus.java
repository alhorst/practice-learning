package com.techelevator.transportation;

public class Bus {

    //member variables
    private String routeName = "";
    private int passengers;
    private double gallonsOfGas = 40.0;
    private boolean isDoorOpen;
    private int totalSeats = 50;

    //bus constructor with argument
    public Bus(String routeName){
        this.routeName = routeName;
    }
    //no argument constructor - have to add since we overrode the other default constructor
    public Bus(){}

    //getter and setters
    public String getRouteName(){
        return routeName;
    }
    public double getGallonsOfGas(){
        return gallonsOfGas;
    }
    public boolean isDoorOpen(){
        return isDoorOpen;
    }
    //make sure to talk about this keyword
    public void setRouteName(String routeName){
        this.routeName = routeName.toUpperCase();
    }

    public void openDoor(){
        isDoorOpen = true;
    }

    public void closeDoor(){
        isDoorOpen = false;
    }

    //write a derived property to determine number of remaining seats
    public int getRemainingNumberOfSeats(){
        return totalSeats - passengers;
    }

    //behavior - what it can do
    public boolean board(){
        if((passengers < totalSeats) && (isDoorOpen == true)){
            passengers++;
            return true;
        }
        return false;
    }

}
