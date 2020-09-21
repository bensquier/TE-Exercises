package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		String hello1 = "Hello PHL[2]";
		String hello2 = "Hello PHL[2]";

				

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		
		String myString = "Hello, World!"; //Instantiating with a literal
		System.out.println("Greeting is: " + myString);
		
		
		/* creating a new string instance using traditional/full Object syntax */
		String myString2 = new String("Hello, World!"); //Instantiating with a literal
		System.out.println("Second Greeting is: " + myString2);
		
		/* Why we always use .equals when comparing strings */
		System.out.print("Are they the same?: ");
		System.out.println( myString==myString2);
		
		System.out.print("Do they have the same content?: ");
		System.out.println( myString.equals(myString2));

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * x endsWith
		 * x startsWith
		 * x indexOf
		 * x lastIndexOf
		 * x length <- Very Common
		 * x substring <- Very Common
		 * x toLowerCase <- Very Common
		 * x toUpperCase <- Very Common
		 * trim <- Very Common ( and handy )
		 */
		
		System.out.println("Let's evaluate myString - 'Hello, World!'\n");
		
		/* Does it end in ! ? */
		System.out.println("endWith() and startsWith()");
		System.out.println("---------------------------");
		
		System.out.println("Ends with \"!\": " + myString.endsWith("!"));
		System.out.println("Starts with \"G\": " + myString.startsWith("G"));
		
		/* Does it start with "h"? */
		System.out.println("Starts with \"h\": " + myString.startsWith("h"));
		/* How about now? */
		System.out.println("... what is startsWith(\"h\") is chained off of toLowerCase(): " + myString.toLowerCase().startsWith("h") );

		System.out.println("Converted to all Upper Case with toUpperCase(): " + myString.toUpperCase());
		/*REMEMBER IMMUTABILITY!*/
		System.out.println("Even though we called toUpperCase, Strings are immutable, myString is still: " + myString);
		
		
		System.out.println("\nmyString has " + myString.length() + " elements in its collection.\n");
		
		int myStringLength = myString.length();
		String firstHalf = myString.substring(5);
		String firstHalf2 = myString.substring(0, myStringLength/2);
		
		System.out.println("Combining length() with substring() methods has some useful applications: ");
		System.out.println("|"+firstHalf+"|");
		System.out.println("|"+firstHalf2+"|");
		
		/*What if I wanted the last 3 of any string? */
		String lastThree = myString.substring(myString.length() -3);
		System.out.println(lastThree);
		
		/*What about the index of a character? */
		System.out.println(myString.indexOf("l"));
		System.out.println(myString.lastIndexOf("l"));
		
		/* Let's get the characters between the first and last "l" */
		System.out.println(myString.substring(myString.indexOf("l"), myString.lastIndexOf("l")));
		/* Oops, starting index is INCLUSIVE. So ... */
		
		int firstLowerL = myString.indexOf("l") + 1;
		int lastLowerL = myString.lastIndexOf("l");
		
		System.out.println(myString.substring(firstLowerL, lastLowerL));
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* -- DECLARED BACK UP TOP, HERE FOR REFERENCE ONLY -- */
		// String hello1 = "Hello PHL[2]";
		// String hello2 = "Hello PHL[2]";

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
		
		String part1 = "Hello ";
		String part2 = "PHL[2]";
		
		String hello4 = part1 + part2;
		

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("Because hello1 is the same reference as hello3");
		}
		
		/* Let's compare them when the literal is the same through concatenation */
		if (hello1 == hello4) {
			System.out.println("Because hello1 is the same reference as hello4");
		}else {
			System.out.println("hello4: \"" + hello4 + "\" IS NOT the same reference as hello1: \"" +hello1 + "\" even though the literals match");
		}
		
		/* But what if they are not declared as equal references because of concatenation (see hello4, above)? */

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello4)) {
			System.out.println("... but, they are equal in their VALUE using .equals()!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello4);
		}
		
		/* BUT, They are not the same reference (see line 128)*/
		

	}
}
