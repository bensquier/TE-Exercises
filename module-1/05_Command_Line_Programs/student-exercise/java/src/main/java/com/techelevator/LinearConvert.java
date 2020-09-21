package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		double feet;

		double meters;

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");

		String userInput = inputScanner.nextLine();

		int measurement = Integer.parseInt(userInput);

		System.out.print("Is the measurement in 1 Meters or 2 Feet: ");

		String metersOrFeet = inputScanner.nextLine();

		if (metersOrFeet.toUpperCase().equals("M")) {

			feet = Math.floor(measurement * 3.2808399D);

			System.out.println(measurement + "m is" + feet + "f.");
		} else if (metersOrFeet.toUpperCase().equals("F")) {

			meters = Math.floor(measurement * 0.3048D);

			System.out.println(measurement + "f is " + meters + "m.");

		}

		inputScanner.close();
	}

}
