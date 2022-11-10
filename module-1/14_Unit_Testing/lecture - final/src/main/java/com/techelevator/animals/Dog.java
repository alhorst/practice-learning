package com.techelevator.animals;

public class Dog {

    private String name;
    private String breed;
    private int age;


    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    /*
        Given a Dog creates a new Dog with the same values and returns it
         */
    public Dog returnOurDog(Dog dog){
        return new Dog(dog.getName(), dog.getBreed(),dog.getAge());
    }

    public void increaseAge(int amountToAdd){
        this.age += amountToAdd;
    }
}
