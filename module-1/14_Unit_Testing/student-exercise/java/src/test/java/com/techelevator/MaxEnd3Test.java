package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxEnd3Test {
	
	MaxEnd3 maxEnd3 = new MaxEnd3();
	
	@Test
	public void max_end_three_returns_an_array_with_all_values_set_to_largest_number() {
		
		int[] array1 = {1, 2, 3};
		int[] array2 = {11, 5, 9};
		int[] array3 = {2, 11, 3};
		
		int[] resultArray1 = {3, 3, 3};
		int[] resultArray2 = {11, 11, 11};
		int[] resultArray3 = {3, 3, 3};
		
		assertEquals(resultArray1, maxEnd3.makeArray(resultArray1));
		assertEquals(resultArray2, maxEnd3.makeArray(resultArray2));
		assertEquals(resultArray3, maxEnd3.makeArray(resultArray3));
	}

}
