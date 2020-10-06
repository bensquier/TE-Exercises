package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		
		String fileName = "FizzBuzz.txt";
		
		File fizzWriter = new File(fileName);
		
		fizzWriter.createNewFile();
		
		try(PrintWriter writer = new PrintWriter(fizzWriter)) {
			for(int i = 1; i <= 300; i++) {
				
			String numberAsString = new Integer(i).toString();
			
				if(i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				}
				else if(i % 5 == 0) {
					writer.println("Buzz");
				}
				else if(i % 3 == 0) {
					writer.println("Fizz");
				}
				else if(numberAsString.contains("5")) {
					writer.println("Buzz");
				}
				else if(numberAsString.contains("3")) {
					writer.println("Fizz");
				}
				else {
					writer.println(i);
				}
			}
			System.out.println("FizzBuzz.txt has been created");
		}

	}

}
