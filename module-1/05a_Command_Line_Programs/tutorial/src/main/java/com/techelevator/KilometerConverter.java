package com.techelevator;

import java.util.Scanner;

public class KilometerConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please kilometer value to start at: ");
        String value = input.nextLine();
        int kilometerStart = Integer.parseInt(value);

        System.out.println("Please kilometer value to end with: ");
        value = input.nextLine();
        int kilometerEnd = Integer.parseInt(value);

        System.out.println("Please kilometer value to increment by: ");
        value = input.nextLine();
        int kilometerIncrement = Integer.parseInt(value);

        System.out.println("Going from " + kilometerStart + "km to " + kilometerEnd +
                "km in increments of " + kilometerIncrement + "km.");
    }


    
}
