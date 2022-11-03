package com.techelevator.transportation;

public class JavaGreenBusTransportation {

    public static void main(String[] args) {
        //make a new bus
       Bus bussie = new Bus("The Fog");
        Bus busso = new Bus();
        Bus busbo = new Bus("The Rain");
        bussie.setRouteName("The Foggy");
        busso.setRouteName("The Mist");
        System.out.println("Bussie's info: ");
        System.out.println(bussie.getRouteName());
        System.out.println(bussie.getGallonsOfGas());
        System.out.println("It bussie's door open?: " + bussie.isDoorOpen());
        bussie.openDoor();
        System.out.println("It bussie's door open?: " + bussie.isDoorOpen());
        System.out.println(busso.isDoorOpen());
        bussie.board();
        System.out.println("The remaining seats for bussie is: " + bussie.getRemainingNumberOfSeats());
    }
}
