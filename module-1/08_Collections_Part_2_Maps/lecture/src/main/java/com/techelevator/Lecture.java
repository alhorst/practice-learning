package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Map is the interface, HashMap is the concrete class
		Map<String, Integer> nameToZipCode = new HashMap<>();

		nameToZipCode.put("Bob", 34232);
		nameToZipCode.put("Ann", 23434);
		nameToZipCode.put("Sue", 45656);
		nameToZipCode.put("Tom", 22343);
		nameToZipCode.put("Tim", 66232);

		//if you know the key, you can get the value
		//KEYS MUST BE UNIQUE!!!
		System.out.println("Ann lives in " + nameToZipCode.get("Ann"));

		//get user input
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a name: ");
		String name = input.nextLine();
		//take in user input to grab the name from the HashMap

		//this makes it so if the user enters tom, it makes it Tom
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		System.out.println(name + "lives in" + nameToZipCode.get(name));

		for (Map.Entry<String, Integer> item : nameToZipCode.entrySet()) {
			//item holds each individual key value pair in the loop
			System.out.println(item.getKey() + " lives at " + item.getValue());
		}

		if (!nameToZipCode.containsKey("Jim")) { //if map doesn't contain key, add it
			nameToZipCode.put("Jim", 77766);

		}
	}

}
