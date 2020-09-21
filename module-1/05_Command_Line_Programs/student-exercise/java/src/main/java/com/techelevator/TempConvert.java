package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		double tempatureCelsius;

		double tempatureFahrenheit;

		Scanner inputScanner = new Scanner(System.in);

		System.out.print("Please enter the tempature: ");

		String userInput = inputScanner.nextLine();

		double userTempature = Double.parseDouble(userInput);

		System.out.print("Is the tempature in (C)elsius or (F)ahrenheit: ");

		String celsiusOrFahrenheit = inputScanner.nextLine();

		if (celsiusOrFahrenheit.toUpperCase().equals("C")) {

			tempatureFahrenheit = Math.floor(userTempature * 1.8 + 32);

			System.out.println(userTempature + "C is " + tempatureFahrenheit + "F. ");

		} else if (celsiusOrFahrenheit.toUpperCase().equals("F")) {

			tempatureCelsius = Math.floor((userTempature - 32) / 1.8);

			System.out.println(userTempature + "F is " + tempatureCelsius + "C. ");

		}

		inputScanner.close();
	}

}
