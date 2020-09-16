package com.mohkad.bowl;

public class ScoresCalculator {

	public int[] calculateScores(int[][] points) {

		int frameScore = 0;
		boolean currentFrameDone;
		int[] scoresArr = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			currentFrameDone = false;
			for (int j = 0; j < points[i].length; j++) {

				if (!currentFrameDone) {

					frameScore += points[i][j];

					/**
					 * Rule: spare/strike in last frame does not give any bonus.
					 */

					// Strike? (and not last frame)
					if (isStrike(points[i]) && i < points.length - 1) {

						frameScore += points[i + 1][0] + points[i + 1][1]; // bonus
						currentFrameDone = true;

						// Spare?
					} else if (isSpare(points[i]) && j == 1 && i < points.length - 1) {
						frameScore += points[i + 1][0]; // bonus

					}

				}

			}

			// frame score
			scoresArr[i] = frameScore;
		}

		return scoresArr;
	}

	private boolean isSpare(int[] frame) {
		boolean isSpare = false;
		isSpare = frame[0] + frame[1] == 10;
		return isSpare;
	}

	private boolean isStrike(int[] frame) {
		boolean isStrike = false;
		isStrike = frame[0] == 10;
		return isStrike;
	}
}
