/**
 * 
 */
package com.mohkad.bowl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestScoresCalculator {

	/**
	 * Test methods for {@link com.mohkad.bowl.ScoresCalculator#calculateScores(int[][])}.
	 */

	@Test
	public void testCalculateScoresSingleStrike() {

		int[] actualScoresArr = null;
		int[][] pointsArr = {{5,1},{3,1},{5,3},{6,1},{10,0},{6,3}};
		int[] expectedScoresArr = {6,10,18,25,44,53};

		ScoresCalculator sc = new ScoresCalculator();
		actualScoresArr = sc.calculateScores(pointsArr);

		assertArrayEquals(expectedScoresArr, actualScoresArr);
	}

	@Test
	public void testCalculateScoresAllStrikes() {

		int[] actualScoresArr = null;
		int[][] pointsArr = {{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,10}};
		int[] expectedScoresArr = {20,40,60,80,100,120,140,160,180,210,230};

		ScoresCalculator sc = new ScoresCalculator();
		actualScoresArr = sc.calculateScores(pointsArr);

		assertArrayEquals(expectedScoresArr, actualScoresArr);
	}

	@Test
	public void testCalculateScoresSpareNoStrikes() {

		int[] actualScoresArr = null;
		int[][] pointsArr = {{7,1},{1,6},{9,1},{0,9},{6,1},{1,1},{4,2},{4,3},{7,2},{8,2},{0,0}};
		int[] expectedScoresArr = {8,15,25,34,41,43,49,56,65,75,75};

		ScoresCalculator sc = new ScoresCalculator();
		actualScoresArr = sc.calculateScores(pointsArr);

		assertArrayEquals(expectedScoresArr, actualScoresArr);
	}

	@Test
	public void testCalculateScoresNoSpareNoStrikes() {

		int[] actualScoresArr = null;
		int[][] pointsArr = {{1,4},{0,4},{6,4},{2,7},{8,1},{7,1},{1,2}};
		int[] expectedScoresArr = {5,9,21,30,39,47,50};

		ScoresCalculator sc = new ScoresCalculator();
		actualScoresArr = sc.calculateScores(pointsArr);

		assertArrayEquals(expectedScoresArr, actualScoresArr);
	}

	@Test
	public void testCalculateScoresSpareAndStrike() {

		int[] actualScoresArr = null;
		int[][] pointsArr = {{9,1},{6,3},{10,0},{4,4},{9,0},{4,3},{5,5},{4,4},{8,2}};
		int[] expectedScoresArr = {16,25,43,51,60,67,81,89,99};

		ScoresCalculator sc = new ScoresCalculator();
		actualScoresArr = sc.calculateScores(pointsArr);

		assertArrayEquals(expectedScoresArr, actualScoresArr);
	}

	
	
}
