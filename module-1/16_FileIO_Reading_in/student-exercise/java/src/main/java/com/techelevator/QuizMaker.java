package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		
			
		File testQuiz = getInputFileFromUser();
		Scanner userResponse = new Scanner(System.in);
		String guessAnswer = "";
		int correctAnswers = 0;
		int questionsAsked = 0;
		
		try(Scanner fileScanner = new Scanner(testQuiz)){
		
			while(fileScanner.hasNextLine()) {
			
			String line = fileScanner.nextLine();
			
			String[] questionsWithAnswers = line.split("\\|");
			
			for(String parts : questionsWithAnswers) {
				if(parts.substring(parts.length()-1).contains("*"));
					parts = parts.replace("*", "");
					
				
			}
			
			
			
		}
		}
	}
			
		@SuppressWarnings("resource")
		private static File getInputFileFromUser() {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Where in the quiz file?");
			String path = userInput.nextLine();

			File inputFile = new File(path);
			if (inputFile.exists() == false) {
				System.out.println(path + " does not exist");
				System.exit(1);
			} else if (inputFile.isFile() == false) {
				System.out.println(path + " is not a file");
				System.exit(1);
			}
			return inputFile;
		}
			
		
		

	}


