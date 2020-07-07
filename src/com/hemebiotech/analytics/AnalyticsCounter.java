package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		SymptomFileReader fileReader = new SymptomFileReader("t");
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		int feverCount = 0;
		while (line != null) {
			int count = 0;
			i++;	// increment i
			if (line.equals("headache")) {
				headCount++;
			}
			if (line.equals("fever")) {
				feverCount++;
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		System.out.println("Headaches," + headCount);
		System.out.println("Fever," + feverCount);
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
