package com.techelevator;

import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);  // System.in -- means connect to keyboard

        System.out.print("Enter your name: ");
        String name = userInput.nextLine();

        System.out.print("Enter your height: ");
        String heightInput = userInput.nextLine(); // .nextLine() returns a String

        int inches = Integer.parseInt(heightInput); // Integer.parseInt - turn the string into an int
        double feet = inches / 12.0;

        System.out.println("Hello, " + name + ", you are " + feet + " feet tall");

    }
}
