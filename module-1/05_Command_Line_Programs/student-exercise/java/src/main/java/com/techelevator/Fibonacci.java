package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int t1 = 0;
		int t2 = 1;

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Please enter the Fibonacci number: ");

		String userInput = inputScanner.nextLine();

		int selection = Integer.parseInt(userInput);

		while (t1 <= selection) {
			System.out.print(t1);

			int sum = t1 + t2;

			t1 = t2;

			t2 = sum;

			if (t1 <= selection) {
				System.out.print(", ");
			}
		}
		inputScanner.close();

	}

}
