package com.techelevator.command_line_application_lecture;

import java.util.Scanner;

public class CommandLineApplicationComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a new instance of the Scanner Class to Watch the System.in input stream
		Scanner inputScanner = new Scanner(System.in);
		
		//Create a new instance of the ParrotHelperClass to work with
		ParrotHelperClass polly = new ParrotHelperClass();
		
		boolean running = true;
		
		while(running) {
			printMenu();		
			String menuChoice = inputScanner.nextLine();
			
			int selection = Integer.parseInt(menuChoice);
			
			if(selection == 1) {
				//Give the response from a friendly parrot
				System.out.println( polly.talkLikeAParrot(getUserInput(inputScanner)) );
				
			}
				else if(selection == 2) {							
					//Give the response from an angry parrot
					String[] angryAnswer = polly.talkLikeAnAngryParrot(getUserInput(inputScanner));
					
					for(int i = 0; i < angryAnswer.length; i++) {
						
						System.out.println( "Sqwak! " + angryAnswer[i] + "!");
					}
				
				}
					else {
							running = false;
					}
		}// END OF WHILE LOOP
		
		printFarewell();
		
  		// **IMPORTANT** Scanners MUST be closed when you are done working with them
  		inputScanner.close();
		
	}
	
	//These method are OK to be in the Command Line Application because they are
	//  directly related to it's behavior
	
	public static void printMenu() {
		
		System.out.println("----------------------------");
		System.out.println("   WELCOME TO PARROT SIM");
		System.out.println("----------------------------");
		System.out.println("Please make a selection:");
		System.out.println("(1) Friendly Parrot");
		System.out.println("(2) Angry Parrot");
		System.out.println("(0) EXIT");
		System.out.println("----------------------------");
		System.out.print("?");
	}
	
	public static void printFarewell() {
		
		System.out.println("----------------------------");
		System.out.println("          GOOD BYE");
		System.out.println("----------------------------");

	}
	
	public static String getUserInput(Scanner appScanner) {
		System.out.print("What do you want me to say?:");
		return appScanner.nextLine();
	}

}
