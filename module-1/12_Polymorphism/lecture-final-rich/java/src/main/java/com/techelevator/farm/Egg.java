package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable{

	private String name = "Egg";
	private BigDecimal price = new BigDecimal("0.25");
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public Egg() {
		name = "Jumbo Egg";
		
	}
	
}
