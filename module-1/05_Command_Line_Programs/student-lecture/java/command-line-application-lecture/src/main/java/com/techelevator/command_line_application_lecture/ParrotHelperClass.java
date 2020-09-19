package com.techelevator.command_line_application_lecture;

public class ParrotHelperClass {

	public String TalkLikeAParrot(String plainEnglish) {
		
		String result;
		
		result = "Sqwak, " + plainEnglish;
		
		return result;
	}
	
	public String[] TalkLikeAAngryParrot(String plainEnglish) {	
		 
		
		return plainEnglish.split(" ");
	}
	
}
