package com.mohkad.bowl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTClient {

	//GET
	public String getScoresResponse() {

		String message = new String();

		try {

			URL url = new URL("http://13.74.31.101/api/points");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new java.io.InputStreamReader(
					(connection.getInputStream())));

			String output;
			System.out.println("Output from Server, for GET call ....");
			while ((output = br.readLine()) != null) {
				message += output;
			}

			System.out.println(message + "\n");

			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return message;

	}


	//POST
	public boolean postScores(String postMessage) {
		boolean successResponse = false;

		try {

			URL url = new URL("http://13.74.31.101/api/points");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");

			//TODO
			System.out.println("the JSON message being POSTed=" + postMessage);

			OutputStream os = connection.getOutputStream();
			os.write(postMessage.getBytes());
			os.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			} else {
				successResponse = true;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));

			String broutp;
			String outputStr="";
			System.out.println("Output from Server, for POST call ....");
			while ((broutp = br.readLine()) != null) {
				outputStr += broutp;
			}

			System.out.println(outputStr);

			successResponse = successResponse && outputStr.contains("\"success\":true");
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return successResponse;
	}

}
