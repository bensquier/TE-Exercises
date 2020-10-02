package com.techelevator.farm;

public class Cat extends FarmAnimal{
	
	public Cat() {
		super("Kitty", "Meow");
		// THERE'S A 50% CHANCE THAT ANY GIVEN CAT SNORES
		isSnoring = ( ( (Math.random() * 9) + 1 ) > 5 );
		
	}

	@Override
	public String eat() {
		return "nom nom nom";
	}

	
	
}
