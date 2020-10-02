package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SameFirstLastTest {
	
	SameFirstLast sameFirstLast = new SameFirstLast();
	
	@Test
	public void sameFirstLast_returns_true_if_first_and_last_index_are_equal() {
		int[] array1 = {1, 2, 3};
		int[] array2 = {1, 2, 3, 1};
		int[] array3 = {1, 2, 1};
		assertEquals(false, sameFirstLast.isItTheSame(array1));
		assertEquals(true, sameFirstLast.isItTheSame(array2));
		assertEquals(true, sameFirstLast.isItTheSame(array3));
	}

}
