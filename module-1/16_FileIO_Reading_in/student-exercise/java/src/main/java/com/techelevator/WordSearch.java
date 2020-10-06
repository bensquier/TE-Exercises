package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		int lineCounter = 0;
		
		File inputFile = getInputFileFromUser();
		
		Scanner inputByUser = new Scanner(System.in);
		System.out.print("What is the search word you are looking for?");
		String searchWord = inputByUser.nextLine();
		System.out.println("Will this search be case sensitive?  (Y)es or (N)o");
		String caseSensitive = inputByUser.nextLine();
		
		
		try(Scanner fileScanner = new Scanner(inputFile)){
			
			while(fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				String[] words = line.split(" ");
				lineCounter++;
				
				for(String word : words) {
					if(caseSensitive.contains("Y")) {
						if(word.equals(searchWord)) { 
							System.out.println(lineCounter + ") " + line);
						}
					}
					else if(word.equalsIgnoreCase(searchWord)) { 
						System.out.println(lineCounter + ") " + line);
					}
				
					
				}
			}
		}

	}
	
	
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("What is the file that should be searched?");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { 
			System.out.println(path + " does not exist");
			System.exit(1); 
		} else if(inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
			System.exit(1); 
		}
		return inputFile;
	}
}
	
	
