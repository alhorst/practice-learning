package com.techelevator.farm;

public class Pig extends FarmAnimal{
    public Pig() {
        super("Pig", "Oink");
    }

    @Override
    public String eat() {
        return "snuffle snuffle";
    }
}
