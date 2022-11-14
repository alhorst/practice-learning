package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) {

		printApplicationBanner();
		try {
			File inputFile = getInputFileFromUser();
//			Scanner fileScanner = new Scanner(inputFile);  // because we are already catching the FNFE
			try (Scanner fileScanner = new Scanner(inputFile)){ // try with resources -- closes file
				// while there is content in the file
				while (fileScanner.hasNextLine()){
					// pick up content one line at a time
					String line = fileScanner.nextLine();
					line = line.trim();  // removes any extra spaces
					if (!checksumIsValid(line)) { // invalid checksum!
						System.out.println("Invalid checksum: " + line);
					}
				}

			}
			   // send each line to our method checkSumIsValid
			// close the file
//			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found or unable to be read from");
		}

	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() throws FileNotFoundException{
		System.out.print("What is path to file >>> ");
		Scanner userInput = new Scanner(System.in);  // connect to keyboard
		String path = userInput.nextLine();
		File inputFile = new File(path); // what if invalid file name entered?
		return inputFile;
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
