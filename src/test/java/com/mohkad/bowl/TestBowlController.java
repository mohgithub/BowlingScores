package com.mohkad.bowl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowlController {

	/**
	 * Test method for {@link com.mohkad.bowl.BowlController#calculateBowlingGameScores()}.
	 * 
	 * End-to-end test for the whole process.
	 * 
	 */
	@Test
	public void testCalculateBowlingGameScores() {
		
		BowlController bc = new BowlController();
		boolean successResponse = bc.calculateBowlingGameScores();

		assertTrue(successResponse);
	}

}
