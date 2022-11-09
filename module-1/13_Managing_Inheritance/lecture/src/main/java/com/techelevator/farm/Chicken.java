package com.techelevator.farm;

public class Chicken extends FarmAnimal{

    public Chicken() {
        super("Chicken", "Cluck");
    }

    @Override
    public String eat() {
        return "skritch skratch";
    }
}
