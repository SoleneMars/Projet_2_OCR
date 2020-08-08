package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Symptoms text file reader. Reads a text file and return a list of read lines
 */
public class SymptomFileReader implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomFileReader(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();
		
		if (filepath != null) {
			BufferedReader reader = null;
			try {
				FileReader fileReader = new FileReader(filepath);
				reader = new BufferedReader(fileReader);
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally
			{
				reader.close();
			}

		}
		
		return result;
	}

}
