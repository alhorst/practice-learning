package com.techelevator;

import java.util.Scanner;

public class LinearConvert {
	public static void convertMeterToFeet(double lengthDouble) {
		double feet = lengthDouble * 3.2808399;
		System.out.printf("%.1f meters is %.1f feet.", lengthDouble, feet);
	}

	public static void convertFeetToMeter(double lengthDouble) {
		double meter = lengthDouble * 0.3048;
		System.out.printf("%.1f feet is %.1f meters.", lengthDouble, meter);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length: ");
		String lengthString = input.nextLine();
		double lengthDouble = Double.parseDouble(lengthString);

		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		String yourChoiceString = input.nextLine();

		if (yourChoiceString.equals("m")) {
			convertMeterToFeet(lengthDouble);
		} else if (yourChoiceString.equals ("f")) {
			convertFeetToMeter(lengthDouble);
		} else {
			System.out.println("Please enter f or m!");
		}
	}
}
