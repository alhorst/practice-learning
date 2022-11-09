package com.techelevator.farm;

// final at the class level means no inheritance
// no children of the Cat class allowed!
public final class Cat extends FarmAnimal{

    public Cat(){
        super("Cat", "meow");
    }

    // because the getSound method in the parent class is marked final
    // we cannot override it!
//    public String getSound() {
//        return "meow";
//    }
}
