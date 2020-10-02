package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrontTimesTest {
	
	FrontTimes times = new FrontTimes();
	
	@Test
	public void front_times_returns_ChoCho() {
		assertEquals("ChoCho", times.generateString("Chocolate", 2));
	}
	@Test
	public void front_times_returns_ChoChoCho() {
		assertEquals("ChoChoCho", times.generateString("Chocolate", 3));
	}
	@Test
	public void front_times_returns_AbcAbcAbc() {
		assertEquals("AbcAbcAbc", times.generateString("Abc", 3));
	}
		
	

}
