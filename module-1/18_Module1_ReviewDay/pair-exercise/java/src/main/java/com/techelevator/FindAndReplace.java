package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws FileNotFoundException {
		
		printApplicationBanner();
		
		System.out.print("What word would you like to find? >>> ");
		Scanner userInput = new Scanner(System.in);
		
		String wordToSearchFor = userInput.nextLine();
		
		System.out.print("What word would like to replace it with? >>> ");
		String replacementWord = userInput.nextLine();
		
		File inputFile = getInputFileFromUser();
		
		File outputFile = getOutputFileFromUser();
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			PrintWriter writer = new PrintWriter(outputFile);
			
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
					if(line.contains(wordToSearchFor)) {
						line = line.replace(wordToSearchFor, replacementWord);
						writer.println(line);
					}else {
						writer.println(line);
				}
				}
			
			
			
			}
		System.out.println("Program has ended. PLease refresh your ");
		}
		
		
		
		
		

	
	
	private static void printApplicationBanner() {
		System.out.println("****************************");
		System.out.println("Word Finder and Replacer 1.0");
		System.out.println("****************************");
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { 
			System.out.println(path+" does not exist");
			System.exit(1); 
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); 
		}
		return inputFile;
	}
	
	@SuppressWarnings("resource")
	private static File getOutputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to output file >>> ");
		String outputPath = userInput.nextLine();
		
		File outputFile = new File(outputPath);
		if(outputFile.exists() == false) { 
			System.out.println(outputPath+" does not exist");
			System.out.println("Please create file.");
			System.exit(1); 
		} 
			
		return outputFile;
	}
}
