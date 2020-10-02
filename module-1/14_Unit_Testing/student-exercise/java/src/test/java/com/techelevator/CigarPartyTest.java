package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CigarPartyTest {
	
	CigarParty party = new CigarParty();
	
	@Test
	public void cigarParty_returns_false_if_cigars_smoked_is_thirty() {
		
		assertEquals(false, party.haveParty(30, false));
	}
	
	@Test
	public void cigarParty_returns_true_if_cigars_smoked_is_between_forty_and_sixty_and_not_weekend() {
		
		assertEquals(true, party.haveParty(50, false));
	}

	@Test
	public void cigarParty_returns_true_if_cigars_smoked_is_seventy_and_weekend() {
		
		assertEquals(true, party.haveParty(70, true));
	}


}
