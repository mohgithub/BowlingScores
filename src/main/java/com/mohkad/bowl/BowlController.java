package com.mohkad.bowl;

import java.util.Arrays;

public class BowlController {

	
	public boolean calculateBowlingGameScores() {
		String restGetResponse = "";
		String tokenValue = "";

		// 1) Get points as JSON 
		RESTClient rc = new RESTClient();
		restGetResponse = rc.getScoresResponse();

		// 2a) Get token
		JSonHandler jh = new JSonHandler();
		tokenValue = jh.getToken(restGetResponse);

		// 2b) get points as 2D array
		int[][] pointsArr = null;
		pointsArr = jh.getPoints(restGetResponse);

		// 3) Calculate scores
		int[] scoresArr = null;
		ScoresCalculator sc = new ScoresCalculator();
		scoresArr = sc.calculateScores(pointsArr);
		System.out.println("Calculated scores=" + Arrays.toString(scoresArr));
		
		// 4) Post calculated scores
		String jsonMessage = "";
		jsonMessage = jh.makeJsonMessage(scoresArr, tokenValue);

		boolean successResponse = false;
		successResponse = rc.postScores(jsonMessage);
		return successResponse;
	}

	
}
