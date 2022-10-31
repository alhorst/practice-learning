package com.techelevator;
import java.util.Scanner;

//conversion is tempCel = (tempFaren - 32) / 1.8 or tempFaren = tempCel * 1.8 + 32
public class TempConvert {
	public static void convertFarenToCel(double tempDouble) {
		double tempCel = (tempDouble - 32) / 1.8;
		System.out.printf("%.1fF is %.1fC", tempDouble, tempCel);
	}

	public static void convertCelToFaren(double tempDouble) {
		double tempFaren = tempDouble * 1.8 + 32;
		System.out.printf("%.1fC is %.1fF", tempDouble, tempFaren);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String tempString = input.nextLine();
		double tempDouble = Double.parseDouble(tempString);

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String yourChoiceString = input.nextLine();

		if (yourChoiceString.equals("F")) {
			convertFarenToCel(tempDouble);
		} else if (yourChoiceString.equals ("C")) {
			convertCelToFaren(tempDouble);
		} else {
			System.out.println("Please enter F or C!");
		}
	}

}
