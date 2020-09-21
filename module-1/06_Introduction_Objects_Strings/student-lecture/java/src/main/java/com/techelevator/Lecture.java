package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		
		String myString = "Hello, World!"; // instantiating with a literal
		System.out.println("Greeting is: " + myString);
		
		// Creating a new string instance using traditional/ full Object syntx
		String myString2 = new String ("Hello World!"); // instantiating with a literal
		System.out.println("Second greeting is: " + myString2);
		
		// Why we always use .equals when comparing strings
		//System.out.print("Are they the same?: ");
		//System.out.println(myString == myString2);

		System.out.print("Are they have the same content?: ");
		System.out.println(myString.contentEquals(myString2));

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length <- very common
		 * substring <- very common
		 * toLowerCase <- very common
		 * toUpperCase <- very common
		 * trim
		 */
		
		System.out.println("Let's evaluate myString - 'Hello, World!");
		// Does it end in ! ?
		System.out.println(myString.endsWith("!"));
		System.out.println(myString.startsWith("G"));
		System.out.println(myString.startsWith("h")); //Does it start with h
		System.out.println(myString.toLowerCase().startsWith("h")); // How about now
		System.out.println(myString.toUpperCase());
		System.out.println(myString.length());
		
		int myStringLength = myString.length();
		String firstHalf = myString.substring(0, myStringLength/2);
		String firstHalf2 = myString.substring(5);

		System.out.println(firstHalf);
		System.out.println(firstHalf2);
		
		//What if we wanted just the last 3 of any string?
		String lastThree = myString.substring(myString.length() - 3);
		System.out.println(lastThree);

		//What about the index of a character?
		System.out.println(myString.toUpperCase().indexOf("L"));
		System.out.println(myString.lastIndexOf("l"));
		//Lets create a substring between the first and last "l"
		System.out.println(myString.substring(myString.indexOf("l"), myString.lastIndexOf("l")));
		// opps, starting at index is inclusive so.
		//System.out.println(myString.substring(myString.indexOf("l" + 1), myString.lastIndexOf("l")));
		//An easier reading code would be
		//int firstLowerL = myString.indexOf("l") + 1;
		//int lastLowerL = myString.lastIndexOf("l");
		//System.out.println(myString.substring(firstLowerL, lastLowerL));
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();


		String hello1 = "Hello PHL[2]";
		String hello2 = "Hello PHL[2]";
		
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
		

		// Let's compare them when the literal is the same through concatenation.
		if (hello1 == hello4) {
			System.out.println("hello1 is the same reference as hello4");
		}else {
			System.out.println(hello4 + "Is not the same reference as " + hello1 + "even through the literal match");
		}
		
		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello4)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
