package com.techelevator.command_line_application_lecture;

import java.util.Scanner; 

public class CommandLineApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner inputScanner = new Scanner(System.in);
			
			ParrotHelperClass polly = new ParrotHelperClass();
			
			printMenu();
			String menuChoice = inputScanner.nextLine();
			
			int selection = Integer.parseInt(menuChoice);
			
			System.out.print("What do you want me to say?:");
			
			String userInput = inputScanner.nextLine();
			
			if(selection == 1) {
				System.out.println(polly.TalkLikeAParrot(userInput));
			}	else if(selection == 2) {
				String[] angryAnswer = polly.TalkLikeAParrot(userInput);
			
				for(int i = 0; i < angryAnswer.length -1; i++) {
				
					System.out.println("Sqwak  " + angryAnswer[i] + "!");
				}
			}
			
			
		
			
			
			//System.out.println("Ok, fine:" + userInput);
			//System.out.println(polly.TalkLikeAParrot(userInput) );
		
				
			
			//Whoa! What is happening here?
			//System.out.println(polly.TalkLikeAAngryParrot(userInput) );
			
			//System.out.println("--------------");
			
			
			}
	}

		public static void printMenu() {
			
			System.out.println("--------------");
			System.out.println("    WELCOME TO PARROT SIM");
			System.out.println("--------------");
			System.out.println("Please make a selection:");
			System.out.println("(1) Friendly Parrot");
			System.out.println("(1) Angry Parrot");
			System.out.println("--------------");
			System.out.print("?");
		}
		
}
