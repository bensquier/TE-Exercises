package com.techelevator.command_line_application_lecture;

public class ParrotHelperClass {

	public String talkLikeAParrot(String plainEnglish) {
		
		String result;
		
		result = "Sqwak, " + plainEnglish;
		
		return result;
	}
	
	public String[] talkLikeAnAngryParrot(String plainEnglish) {
		
				
		return plainEnglish.split(" ");
	}
	
}
