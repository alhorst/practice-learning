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

		// Map is the interface (NEXT WEEK!) -- HashMap is the concrete class (start tomorrow!!!)
		Map<String, Integer> nameToZipCode = new HashMap<>();

		nameToZipCode.put("Bob", 34232);
		nameToZipCode.put("Ann", 23434);
		nameToZipCode.put("Sue", 45656);
		nameToZipCode.put("Tom", 22343);
		nameToZipCode.put("Tim", 66232);

		// if I know the key, I can get the value
		System.out.println("Ann lives at " + nameToZipCode.get("Ann"));  // "Ann" is the key, returns the value

		// keys MUST BE UNIQUE!
		nameToZipCode.put("Bob", 67675);
		System.out.println("Bob lives at " + nameToZipCode.get("Bob"));  //34232 is overwritten and replaced with 67675

		// get user input
		Scanner input = new Scanner(System.in);  //System.in connects us to the keyboard

		// ask user to enter name
		System.out.println("Enter a name: ");
		String name = input.nextLine();  // store in the variable name what the user typed
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);  // capitalizes the first character
		System.out.println(name + " lives at " + nameToZipCode.get(name)); // use what the user typed

		System.out.println(nameToZipCode); // unordered data structure!

		for (Map.Entry<String, Integer> item : nameToZipCode.entrySet()){
			// item holds each individual k,v pair in the loop here
			System.out.println(item.getKey() + " lives at " + item.getValue());
		}

		if (!nameToZipCode.containsKey("Jim")){ // if map doesn't contain key
			nameToZipCode.put("Jim", 77766);  // add the new k,v pairing
		}
		System.out.println(nameToZipCode);
	}

}
