package com.techelevator.farm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {
//array created at parent class level so you can easily add animals to array
		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep(),
			new Pig()};

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
		System.out.println("***********************************************************");
		System.out.println("Let's sing about my tractor as well!");
		//Arrays.asList allows to add all at once
		List<Singable> myList = new ArrayList<>(Arrays.asList(new Tractor(), new Chicken(),
				new Pig(), new Cow(), new Sheep()));

		singSong(myList);

		System.out.println("Let's buy some stuff!");
		Sellable item = new Apple();
		System.out.println("This item sells for " + item.getPrice());

		item = new Tractor();
		System.out.println("This item sells for " + item.getPrice());

	}

	//write a method, cannot be nested, should be in class
	//static means the METHOD BELONGS TO THE CLASS
	public static void singSong(List<Singable> singables) {
		for (Singable singable : singables) {
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
