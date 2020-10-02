package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lucky13Test {
	
	Lucky13 lucky13 = new Lucky13();
	
	
	
	@Test
	public void lucky_thirteen_returns_true_if_no_ones_or_threes_in_array() {
		
		int[] array1 = {0, 2, 4};
		int[] array2 = {1, 2, 3};
		int[] array3 = {1, 2, 4};
		
		assertEquals(true, lucky13.getLucky(array1));
		assertEquals(false, lucky13.getLucky(array2));	
		assertEquals(false, lucky13.getLucky(array3));
	}

}
