package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        SymptomFileReader f = new SymptomFileReader("symptoms.txt");
		List<String> listeSymptoms = f.getSymptoms();
        Collections.sort(listeSymptoms);
        // next generate output
		FileWriter fw = new FileWriter("result.out");
		SortedSet<String> valeursUniques = new TreeSet<>(listeSymptoms);
		for (String symptom : valeursUniques) {
			fw.append(symptom + "," + Collections.frequency(listeSymptoms, symptom) + "\n");
		}
        fw.close();
    }
}
