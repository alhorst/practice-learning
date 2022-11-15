package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {


		//make this a method
		System.out.println("Please enter a file path: ");
		Scanner userInput = new Scanner(System.in);
		String fileToFind = userInput.nextLine();
		File inputFile = new File(fileToFind);

		System.out.println("Please enter a word to find: ");
		String wordToFind = userInput.nextLine();





	}

}
