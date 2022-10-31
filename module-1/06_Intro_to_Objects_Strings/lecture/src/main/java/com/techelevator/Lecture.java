package com.techelevator;

import java.util.Arrays;

public class Lecture {

	public static void main(String[] args) {

		int [] myArray = new int[10]; //declare an array integer
		System.out.println(myArray); //prints a hexadecimal address

		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]); //all values initialized to zero
		}

		Arrays.fill(myArray, 56); //replace all values in array with 56

		System.out.println(Arrays.toString(myArray)); //converts the array of ints to a string representation
		System.out.println("Replaced all values with 56");

		int lengthOfNewArray = 5;
		int[] newArray = Arrays.copyOf(myArray, lengthOfNewArray); //take first five values of old array and put in new array
		System.out.println(Arrays.toString(newArray)); //now we can see new array has a length of five with values copied from old array

		newArray[1] = 3; //reassigning values stored in newArray
		newArray[2] = 13;
		newArray[3] = 91;
		newArray[4] = 5; //will now print [56, 3, 13, 91, 5]

		System.out.println("After reassigning, values are: " + Arrays.toString(newArray));

		Arrays.sort(newArray); //this is an in-memory sort, do not have to reassign
		System.out.println("The sorted array is: " + Arrays.toString(newArray));

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* create an new instance of String using a literal */
		String greeting = "Hello, hello, can anybody hear me?"; //strings do not need to be declared with 'new'
		System.out.println(greeting);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		System.out.println("Length of greeting is: " + greeting.length());
		char first = greeting.charAt(0); //first character in position zero
		char last = greeting.charAt(greeting.length() - 1);

		int count = 0;
		for (int i = 0; i < greeting.length(); i++) {
			if (greeting.charAt(i) == 'o') {
				count++;
			}
		}
		System.out.println("There are " + count + " 'o's in our greeting.");


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
		if (hello1 == hello2) {
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
