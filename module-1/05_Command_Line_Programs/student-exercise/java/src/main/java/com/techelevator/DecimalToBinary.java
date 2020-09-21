package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");

		String userDecimals = inputScanner.nextLine();

		String[] decimalsSplitArray = userDecimalsSplit(userDecimals);

		for (int i = 0; i < decimalsSplitArray.length; i++) {

			int decimal = Integer.parseInt(decimalsSplitArray[i]);

			String binary = "";

			while (decimal > 0) {
				int nextDigit = decimal % 2;
				binary = nextDigit + binary;
				decimal /= 2;
			}

			System.out.println(decimalsSplitArray[i] + " in binary is " + binary);
		}
		inputScanner.close();
	}

	public static String[] userDecimalsSplit(String userDecimals) {
		return userDecimals.split(" ");
	}
}