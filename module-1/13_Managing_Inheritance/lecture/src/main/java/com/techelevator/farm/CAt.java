package com.techelevator.farm;

public final class CAt extends FarmAnimal{

    public CAt() {
        super("Cat", "meow");
    }

    @Override
    public String eat() {
        return "nom nom nom";
    }
    //because getSound in parent class is final we cannot override it
   /* public String getSound() {
        return "meow";
    }*/
}
