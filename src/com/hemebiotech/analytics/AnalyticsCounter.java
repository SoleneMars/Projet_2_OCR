package com.hemebiotech.analytics;

/**
 * Indicates the filepath to SymptomFileReader;
 * Sorts symptoms in an alphabetic order;
 * Create a doc .out;
 * Calculates how many times a symptom appears;
 **
 */

import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        SymptomFileReader f = new SymptomFileReader("symptoms.txt");
		List<String> listeSymptoms = f.getSymptoms();
        Collections.sort(listeSymptoms); /* alphabetic order */
        // next generate output
		FileWriter fw = new FileWriter("result.out");
		SortedSet<String> valeursUniques = new TreeSet<>(listeSymptoms);
		for (String symptom : valeursUniques) {
			fw.append(symptom + "," + Collections.frequency(listeSymptoms, symptom) + "\n");
		}
        fw.close();
    }
}
