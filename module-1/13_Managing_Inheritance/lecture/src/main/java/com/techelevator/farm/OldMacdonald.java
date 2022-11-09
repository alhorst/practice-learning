package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals =
				new FarmAnimal[] { new Cow(), new Chicken(),
				new Sheep(), new Pig()};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		System.out.println("****************************************************");
		System.out.println("Let's sing about a tractor as well!");

		// I COULD make Tractor a child of FarmAnimal, but that is BAD PRACTICE
		// need to create a data structure of Singable items
		//							Arrays.asList allows me to add them all at once
		List<Singable> myList = new ArrayList<>(Arrays.asList( new Tractor(),
				new Chicken(), new Pig(), new Cow(), new Sheep()));

		// let's put the singing part in a method!!!
		singMethod(myList);

		System.out.println("Let's buy some stuff");

		Sellable item = new Apple();
		System.out.println("This item sells for " + item.getPrice());

		item = new Tractor();
		System.out.println("New items sells for " + item.getPrice());

		// cannot instantiate a singable object
//		Singable singable = new Singable();
	}

	// write a method, cannot be nested
	// static means the method belongs to the class
	public static void singMethod(List<Singable> singables){
		for (Singable singable: singables){
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
}
