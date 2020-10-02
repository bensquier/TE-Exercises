package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NonStartTest {
	
	NonStart nonStart = new NonStart();
	
	@Test
	public void nonStart_returns_two_concated_strings_missing_the_first_charaters() {
		assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
		assertEquals("avaode", nonStart.getPartialString("java", "code"));
		assertEquals("hotlava", nonStart.getPartialString("shotl", "java"));

	}

}
