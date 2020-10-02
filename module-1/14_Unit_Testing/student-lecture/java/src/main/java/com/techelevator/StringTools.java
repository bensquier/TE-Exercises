package com.techelevator;

public class StringTools {
	
	public int numberOfCharaters(String inputString, String charaterMatch) {
		int result = 0;
		
		for(int i = 0; i < inputString.length(); i++) {
			if(inputString.substring(i, i + 1).equals(charaterMatch)) {
				result++;
			}
			
		}
		
		return result;
	}

}
