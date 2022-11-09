package com.techelevator.farm;
//abstract at class level says you cannot create an object of this class
//so no one can create a FarmAnimal farmAnimal; we only want children of this class
//to be created, because farmAnimal doesn't exist, only animals on farms so
//create CHILDREN of this class, not a new object of this class >
//create FarmAnimal farmAnimal = new Cow ...etc
public abstract class FarmAnimal implements Singable{
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.isAsleep = false;
	}

	//in an abstract class, if specifying abstract method, no body, no implementation
	//all children must provide an implementation
	public abstract String eat();

	@Override
	public String getName() {
		return name;
	}
	@Override
	public final String getSound() {
		return sound;
	}

	public void sleep() {
		isAsleep = true;
		sound = "zzzzzz";
	}

}
