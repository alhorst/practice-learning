package com.techelevator.farm;

// abstract at class level says you cannot
// create an object of this class
public abstract class FarmAnimal implements Singable{
	private String name;
	private String sound;
	// new attribute -- to help animals sleep at night
	private boolean isAsleep;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;

		// this is explicit, default value is already to be false
		this.isAsleep = false; // by default animals are awake
	}

	// abstract method - no body, no implementation
	// all children must provide an implementation
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
		sound = "Zzzzzzzz";
	}

}
