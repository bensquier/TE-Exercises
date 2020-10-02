package com.techelevator;

import org.junit.Test;

import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before;

public class StringToolsTest {
	
	private StringTools st = new StringTools();
	private String inputString;
	
	@Before
	public void setup() {
		inputString = "abacab";
	}
	
	@Test
	public void abacab_find_a_returns_two() {
	
		String charaterMatch = "a";
		
		Assert.assertEquals(3, st.numberOfCharaters(inputString, charaterMatch));
	}
	
	@Test
	public void abacab_find_z_returns_zero() {
		
		String charaterMatch = "z";
		
		Assert.assertEquals(0, st.numberOfCharaters(inputString, charaterMatch));
	}

}
