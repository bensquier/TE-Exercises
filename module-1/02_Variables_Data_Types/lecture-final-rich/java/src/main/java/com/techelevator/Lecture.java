package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("Hi");
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		
		int numberOfExercises;
		numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		
		double half = 0.5D;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String companyName = "TechElevator";
		
		System.out.println(companyName);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		int seasonsOfFirefly = 1;
		
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage = "Java";
		
		System.out.println(myFavoriteLanguage);
		
		//JUMP
		System.out.println("JUMPING TO OPERATORS");

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

		//System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		
		int diff121And27;
		int oneTwentyOne = 121;
		int twentySeven = 27;
		
		//Parenthesis
		
		diff121And27 = (oneTwentyOne - twentySeven) * 2;
		
		System.out.println(diff121And27);
		
		//PEMDAS - Order of Operations
		
		diff121And27 = oneTwentyOne - twentySeven * 2;
		
		System.out.println(diff121And27);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/

		
		
		/*
		12. Create a String that holds your full name.
		*/
		
		String fullName = "Rich Seeds";
		
		System.out.println(fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		
		String greeting = "Hello";
		
		String formalGreet = greeting + " " + fullName;
		
		System.out.println(formalGreet);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		
		String employeeName = fullName;
		
		employeeName += companyName;
		
		System.out.println(employeeName);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		String movie = "Saw";
		
		movie += 2;
		
		System.out.println(movie);
		
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		movie += 0;
		
		System.out.println(movie);
		
		/*
		18. What is 4.4 divided by 2.2?
		*/

		System.out.println( 4.4/2.2 );
		
		/*
		19. What is 5.4 divided by 2?
		*/

		System.out.println( 5.4/2 );
		
		/*
		20. What is 5 divided by 2?
		*/
		
		System.out.println( 5/2 );

		/*
		21. What is 5.0 divided by 2?
		*/

		System.out.println( 5.0/2 );
		
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		System.out.println( 66.6/100 );
		
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		System.out.println( 5%2 );
		
		/*
		24. What is 1,000,000,000 * 3?
		*/
		
		System.out.println(1000000000 * 3);
		
		
		byte rollOver = Byte.MAX_VALUE;
		
		System.out.println(rollOver);
		
		rollOver++;
		
		System.out.println(rollOver);

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/

		boolean doneWithExercises = false;
		
		System.out.println(doneWithExercises);
		
		/*
		26. Now set doneWithExercise to true.
		*/
		
		doneWithExercises = true;
		
		System.out.println(doneWithExercises);
		
	}

}
