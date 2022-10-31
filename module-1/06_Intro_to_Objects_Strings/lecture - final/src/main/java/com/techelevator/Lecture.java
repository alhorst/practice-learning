package com.techelevator;

import java.util.Arrays;

public class Lecture {

	public static void main(String[] args) {

		int [] myArray = new int[10]; // declare an array integer
		System.out.println(myArray); // prints a hexadecimal address

		for (int i = 0; i < myArray.length; i++){
			System.out.println(myArray[i]); // all values were initialized to zero
		}

		Arrays.fill(myArray, 42);  // replace all values in the array with the number 42
		System.out.println("Replaced all values with 42");
		System.out.println(Arrays.toString(myArray));  // converts the array of ints to a string representation

		int lengthOfNewArray = 5;
		int[] newArray = Arrays.copyOf(myArray, lengthOfNewArray); // copyOf initializes the newArray
		System.out.println(Arrays.toString(newArray));

		newArray[1] = 3; // reassigning the values stored in newArray
		newArray[2] = 13;
		newArray[3] = 91;
		newArray[4] = 5;  //[42, 3, 13, 91, 5]

		System.out.println("After reassigning, values are: " + Arrays.toString(newArray));

		Arrays.sort(newArray);  // this is an in memory sort
		System.out.println("The sorted array is: " + Arrays.toString(newArray));

		char[] myCharArray = { 'd', 't', 'a', 'b', 'e'};
		String[] myStringArray = {"Bob", "Ann", "Cathy"};
		Arrays.sort(myStringArray);
		System.out.println(Arrays.toString(myStringArray));


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greeting = "Hi there!"; // do not have to use the new keyword for String class objects

		String newGreeting = new String("Goodbye Everyone!");// using the new keyword
		System.out.println(greeting);
		System.out.println(newGreeting);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		System.out.println("Length of newGreeting is: " + newGreeting.length());  // 17

		char first = newGreeting.charAt(0);  // first character which is in index 0
		char last = newGreeting.charAt(newGreeting.length() - 1);

		System.out.println("first holds: " + first + " and last holds: " + last);

		// count how many 'o's are in the string newGreeting
		// create a variable to hold the count
		int count = 0;

		for (int i = 0; i < newGreeting.length(); i++){
			// when I have an 'o', increment count
			if (newGreeting.charAt(i) == 'o'){
				count++;
			}
		}
		System.out.println("There are " + count + " 'o's in the newGreeting String");


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);


		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) { // don't use == comparison on String, or any reference types!
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
