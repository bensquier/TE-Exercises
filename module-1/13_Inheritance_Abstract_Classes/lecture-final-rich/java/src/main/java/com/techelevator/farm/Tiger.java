package com.techelevator.farm;

public class Tiger extends Cat{
	
	public Tiger() {
		
		//TIGERS ARE ALWAYS NAMED THE SAME AS A CAT BECAUSE THEY EXTEND CAT AND ONLY HAVE
		// ACCESS TO THE CAT CONSTRUCTOR
		super();
		// SOUND PROPERTY IS SET TO PROTECTED IN THE FARMANIMAL CLASS SO IT CAN BE MODIFIED BY
		//	CHILDREN
		this.sound = "Roar";
		
	}

}
