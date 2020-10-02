package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringBitsTest {
	
	StringBits stringBits = new StringBits();
	
	@Test
	public void stringbits_returns_a_substring_with_every_other_letter() {
		assertEquals("Hlo", stringBits.getBits("Hello"));
		assertEquals("H", stringBits.getBits("Hi"));
		assertEquals("Hello", stringBits.getBits("Heeololeo"));
	}

}
