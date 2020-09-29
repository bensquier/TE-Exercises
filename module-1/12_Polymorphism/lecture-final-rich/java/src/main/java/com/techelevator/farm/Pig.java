package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable{

	private BigDecimal price;
	
	public Pig() {
		super("Porky", "Oink");
		price = new BigDecimal("300.00");
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
}
