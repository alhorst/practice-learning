package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is your destination file path?");
		String filePath = userInput.nextLine();

		File fileDestination = new File(filePath);

		try (PrintWriter dataOutput = new PrintWriter(fileDestination)) {
				for (int n = 1; n <= 300; n++) {
					if (n % 3 == 0 && n % 5 == 0) {
						dataOutput.println("FizzBuzz");
					} else if (n % 5 == 0) {
						dataOutput.println("Buzz");
					} else if (n % 3 == 0) {
						dataOutput.println("Fizz");
					} else
						dataOutput.println(n);
				}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the file for writing.");
		}
	}
}
