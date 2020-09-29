package com.techelevator.farm;

public class Tractor implements Singable{
	
	private String name;
	private String sound;
	
	public Tractor() {
		name = "Big Green";
		sound = "Vroom";
	}
	@Override
	public String getName() {
		return "The Mighty " + name;
	}
	@Override
	public String getSound() {
		return sound + " " + sound;
	}

}
