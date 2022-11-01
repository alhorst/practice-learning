package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();
		names.add("Bilbo"); //0
		names.add("Frodo");  //1
		names.add("Gandalf");  //2
		names.add("Sauron");  //3

		System.out.println("Size of list: " + names.size());  // size for Collection size of data structure

//		names.add(49, "Pippen"); // Runtime exception -- can't just add elements in any position
		names.add(2, "Sam");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		System.out.println(names); // uses a format from Java to print out the values
		for (int i = 0; i < names.size(); i++) {
			System.out.println((i+1) + ") " + names.get(i) );
		}



		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Bilbo");
		printList(names);

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(3, "Merry");  // Merry goes in position 3 and everyone else moves down
		names.add(3, "Gollum"); // Merry ends up in position 4 after this add
		printList(names);

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3);
		System.out.println("removed index 3:");
		printList(names);

		names.remove("Bilbo"); // removes first occurence of the name
		System.out.println("remove first Bilbo");
		printList(names);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (names.contains("Gandalf")){
			System.out.println("Gandalf is found!");
		} else {
			System.out.println("no gandalf in the list!");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Sauron is in index: " + names.indexOf("Sauron"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String [] namesArray = new String[names.size()]; // arrays are fixed length
		for (int i = 0; i < names.size(); i++) {
			namesArray[i] = names.get(i);	// copy each element one at a time from list to array
		}

		// SHORTCUT ON HOW TO DO THIS!!!!
		String[] namesArray2 = names.toArray(new String[names.size()]);
		System.out.println(namesArray2);
		System.out.println(Arrays.toString(namesArray2));

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);  // in memory sort --
		printList(names);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);  // reverses the order in the list
		printList(names);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (int i = 0; i < names.size(); i++) {
			String item = names.get(i);
			System.out.println(item);
		}
		System.out.println("FOR EACH LOOP:");
		for (String item: names) { // shorthand for printing out the list
			System.out.println(item);
		}
	}

	public static void printList(List<String> names){  // we wrote a reusable block of code!
		for (int i = 0; i < names.size(); i++) {
			System.out.println((i+1) + ") " + names.get(i) );
		}
	}
}
