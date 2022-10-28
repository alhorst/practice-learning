package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        String discountString = scanner.nextLine();
//        int discountInt = Integer.parseInt(discountString);
        double discountDouble = Double.parseDouble(discountString);
        double discount = discountDouble / 100;

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String priceString = scanner.nextLine();

        String [] priceArray = priceString.split(" ");

        for (int i = 0; i < priceArray.length; i++){
            double price = Double.parseDouble(priceArray[i]);
            double discountAmount = price * discount;
            double discountPrice = price - discountAmount;
//            System.out.println("Price: " + price + " Discount: " + discountAmount + " Total: " + discountPrice);
            System.out.printf("Price: %.2f Discount: %.2f Total: %.2f\n", price, discountAmount, discountPrice);
        }


    }

}
