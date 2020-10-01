package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	protected String name;
	protected String sound;
	private boolean isAsleep;
	
	public void sleep(boolean isAsleep) {
		this.isAsleep = isAsleep;
	}

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	public abstract String eat();

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if(isAsleep) {
			return "zzzZzzz";
		}else {
		return sound;
	}
	}
	
	protected void snoreOn(boolean snoring, String baseSound) {
		if(snoring) {
			this.sound= "zZzZzZzZzZz";
		}else {
			sound = baseSound;
		}
	}
	

}