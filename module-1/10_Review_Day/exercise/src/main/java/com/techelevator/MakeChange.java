package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the total amount of the bill: ");
		String userInput = scanner.nextLine();
		double totalBill=Double.parseDouble(userInput);


		System.out.print("Enter the amount tendered: ");
		String userInputAmountTendered = scanner.nextLine();
		double amountTendered=Double.parseDouble(userInputAmountTendered);

		double change=amountTendered-totalBill;

		System.out.println("The amount of change is: "+change);



		





	}

}
