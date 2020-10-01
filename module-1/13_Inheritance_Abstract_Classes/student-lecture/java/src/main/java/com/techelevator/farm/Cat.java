package com.techelevator.farm;

public class Cat extends FarmAnimal{

	public Cat() {
		super("Kitty", "Meow");
		this.snoreOn(true, "Meow");
	}

	@Override
	public String eat() {
		return "nom nom nom";
	}
	
//	@Override
//	public String getSound() {
//		return "Hisss!";
//	}
	
	
}
