package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> quizQuestions = new ArrayList<>();
		List<String> possibleAnswers = new ArrayList<>();
		Map<String, Integer> answers = new HashMap<>();
		int counter = 0;
		int correctAnswerCounter = 0;
		int totalQuestions = 0;
		
		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] questionSplit = line.split("\\|");
				
				quizQuestions.add(questionSplit[0]);
				System.out.println(questionSplit[0]);
				
				possibleAnswers.add(questionSplit[1]);
				possibleAnswers.add(questionSplit[2]);
				possibleAnswers.add(questionSplit[3]);
				possibleAnswers.add(questionSplit[4]);

				
				
				for(String answer : possibleAnswers) {
					
					if(answer.contains("*")) {
						answers.put(answer.substring(0, answer.length() - 1), (possibleAnswers.indexOf(answer)) + 1);
						counter++;
						System.out.println(counter + ") " + answer.substring(0, answer.length() - 1));
					}else {
						counter++;
						System.out.println(counter + ") " + answer);
					}
					
				}
				System.out.println("Your answer: ");
				
				@SuppressWarnings("resource")
				Scanner userResponce = new Scanner(System.in);
				String userAnswer = userResponce.nextLine();
				int number = Integer.parseInt(userAnswer);
				if(answers.containsValue(number)) {
					System.out.println("Correct!");
					correctAnswerCounter++;
					totalQuestions++;
				}else {
					System.out.println("Incorrect");
					totalQuestions++;
				}
				possibleAnswers.clear();
				counter = 0;
			}
			System.out.println("You got " + correctAnswerCounter + " answer(s) correct out of the total " + totalQuestions + " questions asked.");
		}
		
		
	}
		
	//     test_quiz.txt
	
	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("Quiz Maker 1.0");
		System.out.println("******************");
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Where is the quiz file?");
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
			
//	private static List<String> getQuizQuestion(String question) {
//		List<String> quizQuestions = new ArrayList<String>();
//			quizQuestions.add(question);
//			return quizQuestions;
//	}
//	private static String getQuizAnswer(String answerWithAsterick) {
//		String answer = answerWithAsterick.substring(0, answerWithAsterick.length() - 1);
//		return answer;
//	}
//	private static List<String> getPossibleAnswers(String possibleAnswer){
//		List<String> possibleAnswers = new ArrayList<String>();
//		possibleAnswers.add(possibleAnswer);
//		return possibleAnswers;
//	}

	}


