package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateFashionTest {
	
	DateFashion dateFashion = new DateFashion();
	
	@Test
	public void date_fashion_returns_two_if_either_person_has_a_score_over_eight_of_over() {
		
		assertEquals(2, dateFashion.getATable(5, 10));
	}
	@Test
	public void date_fashion_returns_zero_if_either_person_has_a_score_of_2_or_lower() {
		
		assertEquals(0, dateFashion.getATable(5, 2));
	}
	@Test
	public void date_fashion_returns_one_if_both_people_have_scores_between_two_and_eight() {
		
		assertEquals(1, dateFashion.getATable(5, 5));
	}

}
