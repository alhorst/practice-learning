package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a file path:");
		String filePath = userInput.nextLine();
		System.out.println("What word are you looking for?");
		String wordToFind = userInput.nextLine();
		System.out.println("Should the search be case sensitive? Y or N?");
		String yesOrNo = userInput.nextLine();
		File aliceFile = new File(filePath);

		try {
			userInput = new Scanner(aliceFile);
			int lineNumber = 1;
			while (userInput.hasNextLine()) {
				String line = userInput.nextLine();

				if (yesOrNo.equals("Y")) {
					if (line.contains(wordToFind)) {
						System.out.println(lineNumber + ") " + line);
					}
				} else if (yesOrNo.equals("N")) {
					if (line.toLowerCase().contains(wordToFind.toLowerCase())){
						System.out.println(lineNumber + ") " + line);
					}
				} lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found or unable to be read from.");
		}
	}
}

