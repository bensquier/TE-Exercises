package com.techelevator.command_line_application_lecture;

import java.util.Scanner;

public class CommandLineApplicationBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create a new instance of the Scanner Class to Watch the System.in input stream
		Scanner inputScanner = new Scanner(System.in);
		
		//Create a new instance of the ParrotHelperClass to work with
		ParrotHelperClass polly = new ParrotHelperClass();
		
		//Display a welcome banner
		System.out.println("----------------------------");
		System.out.println("   WELCOME TO PARROT SIM");
		System.out.println("----------------------------");
		
		//Start Interacting with the user
		
		System.out.print("What do you want me to say?:"); 
		String userInput = inputScanner.nextLine();
		
		//Give the response from a friendly parrot using the Method from ParrotHelperClass
		// NOTE: Extra spaces in the method parameter are just for readability
	    System.out.println( polly.talkLikeAParrot(userInput) );
		
	    //Q: Whoa! What is happening here? 
	    //A: This demonstrates that the string representation 
	    //    of a reference type is its' actual reference
	    //-------------------------------------------------------
	  	//System.out.println( polly.TalkLikeAnAngryParrot(userInput) );
	  		
  		//Let's try again
  		
  		System.out.println("-------------");
  		
  		//Give the response from an angry parrot using the Method from ParrotHelperClass
  		
  		String[] angryAnswer = polly.talkLikeAnAngryParrot(userInput);
  		  
  		for(int i = 0; i < angryAnswer.length; i++) {
  		  
  			System.out.println( "Sqwak! " + angryAnswer[i] + "!"); 
		}
		
  		// **IMPORTANT** Scanners MUST be closed when you are done working with them
  		inputScanner.close();
  		
	}

}
