package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	
	private String name;
	protected String sound;
	private boolean isAsleep;
	protected boolean isSnoring = false;
	
	public String getName( ) {
		return name;
	}
	
	public final String getSound( ) {
		
		if( isAsleep && !isSnoring) {
			return "Zzzzzz";
		}else if (isAsleep && isSnoring){
				return "SNORK! Zzzz";
			}else{
					return sound;
				}
	}
	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	public abstract String eat();

	public void sleep(boolean isAsleep) {
		this.isAsleep = isAsleep;
	}
		
}