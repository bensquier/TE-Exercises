package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalGroupNameTest {
	
	
	@Test
	public void animalName_Returns_HerdName() {
		
		AnimalGroupName animal = new AnimalGroupName();
		
		
		assertEquals("Tower", animal.getHerd("giraffe"));
		assertEquals("unknown", animal.getHerd(""));
		assertEquals("unknown", animal.getHerd("walrus"));
		assertEquals("Crash", animal.getHerd("Rhino"));
		assertEquals("Crash", animal.getHerd("rhino"));
		assertEquals("unknown", animal.getHerd("elephants"));
	}
	}


