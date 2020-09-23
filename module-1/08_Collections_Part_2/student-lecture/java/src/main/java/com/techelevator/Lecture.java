package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Declaring and initializing a Map
		
		Map<String, String> nameToZipCode = new HashMap<String, String>();
		
		//Adding items to a Map
		
		nameToZipCode.put("Bob", "19001");
		nameToZipCode.put("Mary", "19003");
		nameToZipCode.put("Frank", "19002");

		//Retrieve items from the Map
		
		System.out.println("Mary live in: " + nameToZipCode.get("Mary"));
		System.out.println("Bob live in: " + nameToZipCode.get("Bob"));
		System.out.println("Frank live in: " + nameToZipCode.get("Frank"));
		
		//We can also retrieve the values from a Map using a for...each loop! NO HARD CODING!!
		
		System.out.println("----For Each used to retreieve values from a map----");
		
		Set<String> names = nameToZipCode.keySet();
		for(String name : names) {
			
			System.out.println(name + " lives in: " + nameToZipCode.get(name));
		}
		
		//Let's check to see if a key exists
		
		System.out.println("---Adding a new entry and checking for existence---");
		
		String newKey = "David";
		String newValue = "19001";
		
		if(nameToZipCode.containsKey(newKey)) {
			System.out.println(newKey + " already exists!");
		}else
		{
			System.out.println("Adding value for " + newKey);
			nameToZipCode.put(newKey, newValue);
		}
		//Second Run
		System.out.println("---Trying to add the same entry with the same key and checking for existence---");
		
		newKey = "David";
		newValue = "19107";
		
		if(nameToZipCode.containsKey(newKey)) {
			System.out.println(newKey + " already exists!");
		}else
		{
			System.out.println("Adding value for " + newKey);
			nameToZipCode.put(newKey, newValue);
		}
		System.out.println();
		System.out.println("---Checking the contents of my Map");
		System.out.println();
		names = nameToZipCode.keySet();
		for(String name : names) {
			
			System.out.println(name + " lives in: " + nameToZipCode.get(name));
		}
		System.out.println();
		System.out.println("---Let's take the \"contains\" condition back out of the put()---");
		System.out.println();
		System.out.println("Adding value for " + newKey);
		nameToZipCode.put(newKey, newValue);
		
		names = nameToZipCode.keySet();
		for(String name : names) {
			
			System.out.println(name + " lives in: " + nameToZipCode.get(name));
		}
		
		//Let's remove David
		System.out.println();
		System.out.println("---Let's remove David---");
		
		nameToZipCode.remove("David");
		if(!nameToZipCode.containsKey("David")) {
			System.out.println();
			System.out.println("David has been removed");
		}else {
			System.out.println("Something went wrong");
		}
		names = nameToZipCode.keySet();
		for(String name : names) {
			
			System.out.println(name + " lives in: " + nameToZipCode.get(name));
		}
		
		//Maps can also be iterated through over the KVP.
		
		System.out.println("\n---Iterating over the Entry Set---");
		
		
		for(Map.Entry<String, String> nameZipEntry : nameToZipCode.entrySet()) {
			System.out.println(nameZipEntry.getKey() + " lives in zip code " + nameZipEntry.getValue());
		}
		//
		//BONUS OF DEMO//
		//
		System.out.println("\nHello\nWorld");
		
	}

}
