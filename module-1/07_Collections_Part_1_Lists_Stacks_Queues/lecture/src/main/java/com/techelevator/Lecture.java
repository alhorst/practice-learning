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

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		names.add("Bilbo");
		names.add("Frodo");
		names.add("Sam");
		names.add("Merry");
		names.add("Gandalf");

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Bilbo");
		printList(names);


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(3, "Pippin");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(0);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		names.contains("Bilbo");

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Frodo is at index " + names.indexOf("Frodo"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray2 = names.toArray(new String[0]); //what data type is passed in and what index
		//can also use names.size() if you don't know List size
		System.out.println(Arrays.toString(namesArray2));

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names); //in memory sort, can't go back


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names); //in memory reverse, can't go back

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(String item : names ) {
			System.out.println("Character: " + item);
		}


	}

	public static void printList(List<String> names) {
		for (int i = 0; i < names.size(); i++) {
			System.out.println((i + 1) + ") " + names.get(i));

		}
	}
}
