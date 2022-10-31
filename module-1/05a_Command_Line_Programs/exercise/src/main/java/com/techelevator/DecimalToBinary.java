package com.techelevator;

import java.util.Scanner;
public class DecimalToBinary {
		public static void main (String[]args) {

			Scanner input = new Scanner(System.in);

			System.out.println("Please enter in a series of decimal values (separated by spaces): ");
			String decString = input.nextLine();
			String[] decimalArray = decString.split(" ");

			for (int i = 0; i < decimalArray.length; i++) {
				int decimalValue = Integer.parseInt(decimalArray[i]);
				convertDecimalToBinary(decimalValue);

			}

		}
		public static void convertDecimalToBinary(int decimalValue) {
			String decimalToBinary = decimalValue + " is ";
			int[] decimalArray = new int[0];
			int count = 0;
				while (decimalValue > 0) {
					int[] tempArray = new int[decimalArray.length + 1];

					for (int i = 0; i < count; i++) {
						tempArray[i] = decimalArray[i]; //using temp array because length is unknown
					}
					tempArray[count] = decimalValue % 2;
					decimalValue = decimalValue / 2;
					count++;
					decimalArray = tempArray;
				}

			for (int i = decimalArray.length - 1; i > 0 ; i--) { //go through in reverse, add to my string
				decimalToBinary += decimalArray[i];
			}
			System.out.println(decimalToBinary + " in binary");
		}

	}


