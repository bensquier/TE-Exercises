package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Less20Test {
	
	Less20 less20 = new Less20();
	
	@Test
	public void less_twenty_returns_true_if_number_is_one_or_two_less_than_a_multiple_of_twenty() {
		
		assertEquals(true, less20.isLessThanMultipleOf20(18));
		assertEquals(true, less20.isLessThanMultipleOf20(19));
		assertEquals(false, less20.isLessThanMultipleOf20(20));
		assertEquals(false, less20.isLessThanMultipleOf20(21));
		
	}

}
