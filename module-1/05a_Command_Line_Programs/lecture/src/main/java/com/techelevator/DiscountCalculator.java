package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {
    public static double calculateDiscount(double price, double discount) {
        double dollarsOff = price * discount;
        double discountPrice = price - dollarsOff;

        return discountPrice;
    }
    //write your calculation method here and call it later
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountString = input.nextLine();
        double discountDouble = Double.parseDouble(discountString);
        double discount = discountDouble / 100;

        System.out.print("Please provide a series of prices (space separated): ");
        String priceString = input.nextLine();
        String[] priceArray = priceString.split(" ");

        for (int i = 0; i < priceArray.length; i++) {
            double price = Double.parseDouble(priceArray[i]);
            double result = calculateDiscount(price, discount);
            System.out.printf("Price was: %.2f Discount: %.2f Final price: %.2f\n", price, discount, result);

        }
    }

}
