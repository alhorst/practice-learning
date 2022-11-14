package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args)  {

		printApplicationBanner();
		try {
			File inputFile = getInputFileFromUser();
			try (Scanner inputScanner = new Scanner(inputFile)) {
				while (inputScanner.hasNextLine()) {
					String lineInput = inputScanner.nextLine();
					lineInput = lineInput.trim(); //can use trim or can use substring

					if(!checksumIsValid(lineInput)) {
						System.out.println("Invalid checksum: " + lineInput);
					} 
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found or unable to be read from.");;
		}


	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() throws FileNotFoundException {
		System.out.print("What is the file path?");
		Scanner userInput = new Scanner(System.in);
		return new File(String.valueOf(userInput));
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
