package com.techelevator;

import java.util.Scanner;
public class Fibonacci {
	public static void calculateFibo(int num) {
		//sum(n-1)+sum(n-2)+sum(n-3)...sum(0)=0 and sum(1)=1
		//0 1 1 2 3 5 8...
		int firstNum = 0; //start sequence
		int secondNum = 1;

		while (firstNum <= num) {
			System.out.print(firstNum + " ");
			int nextNum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = nextNum;

		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a number: ");
		int num = input.nextInt();

		if (num <= 0){
			System.out.println("0, 1");
		} else {
			calculateFibo(num);//run my method
		}

	}

}

