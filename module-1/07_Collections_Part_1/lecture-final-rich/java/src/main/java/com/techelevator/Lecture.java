package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {
	
	public static boolean debugOn = true;

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();
		names.add("Jen");
		names.add("Bob");
		names.add("Mary");
		names.add("Frank");
		
		
		System.out.println("There are " + names.size() + " names in my list");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for(String name : names) {
			System.out.println(name);
		}
		

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		
		Collections.sort(names);
		for(String name : names) {
			System.out.println(name);
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Bob");
		
		for(String name : names) {
			System.out.println(name);
		}



		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2, "Barry");
		for(String name : names) {
			System.out.println(name);
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3);
		for(String name : names) {
			System.out.println(name);
		}

		//Let's put Jen back
		
		names.add("Jen");
		
		
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean inList = names.contains("Jen");
		System.out.println("Is Jen back? " + inList);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int jenIndex = names.indexOf("Jen");
		System.out.println("Jen's index is: " + jenIndex);
		
		//How does that help for removing by index?
		
		System.out.println("-- I can combine an indexOf and remove to remove something by its value: ");
		
		names.remove(names.indexOf("Jen"));
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("-- What about the Bobs?");
		
		names.remove("Bob");
		for(String name : names) {
			System.out.println(name);
		}
		
		//Let's put the second Bob back
		
		names.add(2, "Bob");
		
		System.out.println("-- putting bob #2 back");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("-- What could you do to remove all the Bobs?");
		
		
		// NOPE, CAN'T DO IT THIS WAY
		/*
		 * String nameToRemove = "Bob";
		 * 
		 * int counter = 0;
		 * 
		 * for(String name : names) {
		 * 
		 * counter++; System.out.println("Iteration: " + counter);
		 * 
		 * if(name.equals(nameToRemove)) { names.remove(nameToRemove); } }
		 * 
		 * for(String name : names) { System.out.println(name); }
		 */
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] listToArray = names.toArray(new String[0]);
		
		System.out.println(listToArray.length);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		
		
		int reverseCounter = 0;
		for(String name : names) {
			
			reverseCounter++;
			
			System.out.println(reverseCounter + ":" + name );
		}
		
		reverseCounter = 0;
		
		System.out.println("-- Let's reverse it and see the new order of items");
		
		Collections.reverse(names);
		
		for(String name : names) {
			
			reverseCounter++;
			
			System.out.println(reverseCounter + ":" + name );
		}

		// Example of using debug print statements to conditionally display information
		if(debugOn) {
			System.out.println("I reversed " + reverseCounter + " items.");
		}
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


		// Let's loop through names using a for-each loop
		
		// for each name in names
		for (String name : names) {
			// print the name
			System.out.println(name);

			}
		
		
		
	}
}
