package com.techelevator.farm;

public class Sheep extends FarmAnimal{

    public Sheep() {
        super("Sheep", "Baa");
    }

    @Override
    public String eat() {
        return "chews quietly";
    }
}
