package com.mohkad.bowl;

public class BowlMain {
		
	public static void main(String[] args) {
		BowlController bc = new BowlController();
		System.out.println("Begin ... \n");
		boolean successResponse = bc.calculateBowlingGameScores();
		System.out.println("\n"+"End.");

	}

}