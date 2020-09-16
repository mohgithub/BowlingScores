package com.mohkad.bowl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSonHandler {

	final String POINTS_KEY = "points";
	final String TOKEN_KEY = "token";

	public String getToken(String jsonAsStr) {

		String out;
		JSONObject jsonObj = new JSONObject(jsonAsStr);

		out = (String) jsonObj.get(TOKEN_KEY);

		return out;
	}


	public int[][] getPoints(String jsonAsStr) {

		JSONObject mainJsonObject = new JSONObject(jsonAsStr);
		JSONArray pointsJArray = mainJsonObject.getJSONArray(POINTS_KEY);
		int frameSize = pointsJArray.length();
		int[][] pointsArr = new int[frameSize][2];

		for (int i = 0; i < frameSize; i++) {

			String frameArrStr = pointsJArray.getJSONArray(i).toString();

			//current frame str to array

			JSONArray frameJArr = (JSONArray) new JSONObject(new JSONTokener("{data:"+frameArrStr+"}")).get("data");
			for(int j=0; j<frameJArr.length(); j++) {
				pointsArr[i][j] =  frameJArr.getInt(j);//shot
			}
		}

		return pointsArr;
	}


	public String makeJsonMessage(int[] scoresArr, String token) {
		String jsonMessage = "";

		jsonMessage = new JSONObject().put(TOKEN_KEY,token).put(POINTS_KEY,scoresArr).toString();

		return jsonMessage;
	}

}
