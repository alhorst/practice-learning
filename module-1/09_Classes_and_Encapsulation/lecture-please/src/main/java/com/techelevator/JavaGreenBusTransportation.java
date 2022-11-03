package com.techelevator;

public class JavaGreenBusTransportation {

    public static void main(String[] args) {
        //make new bus
        Bus bus = new Bus("The Fog");
        System.out.println("Welcome to Bus 1!");
        System.out.println(bus.getRouteName());
        System.out.println(bus.isDoorOpen());

        Bus bus1 = new Bus("The Mist");
        System.out.println("Welcome to Bus 2!");
        System.out.println(bus1.getRouteName());
        System.out.println(bus1.isDoorOpen());
        bus1.openDoor();
        System.out.println(bus1.isDoorOpen());
        bus1.board();
        System.out.println("The seats remaining are: " + bus1.getRemainingSeats());

    }
}
