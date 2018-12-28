package com.underplex.conwife;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Utility class for loading seed files for games like Conway's Game of Life.
 * <p>
 * The seed values are expected to be in an array of x by y dimensions with no missing values. Missing values will be filled in by the <tt>DEFAULT_VALUE</tt> String.
 * @author Brandon Irvine, brandon@underplex.com
 *
 */
public class FileLoader {
	
	public static final String DEFAULT_VALUE = "undefined";
	private final int width;
	private final int height;
	private final String[][] array;
		
	/**
	 * Constructor that loads a file.
	 * <p>
	 * Generally, the file is expected to be a simple .txt file with single characters (no space separator) representing states in a cell in the row and column the character is in. Each row should have the same number of characters in it. The only exception to this is
	 * are the rows that will be skipped. 
	 * <p>
	 * If a character is not in the list of keys for the <tt>statusMap</tt> parameter, the character won't be read and will be replaced by the value given in this class's <tt>DEFAULT_VALUE</tt> String.
	 * <p>
	 * 
	 * @param fileName String that is full path of the file to be loaded
	 * @param statusMap map of String values expected in the file to the values needed for the actual game simulation
	 * @param skipRows number of rows to skip in the file
	 */
	public FileLoader(String fileName, Map<String,String> statusMap, int skipRows, String defaultValue){
		List<String> lines = makeLinesList(fileName);
		
		skipRows = Math.min(skipRows, lines.size());
		for (int i = 1; i <= skipRows; i++){
			lines.remove(0);
		}
		
		List<List<String>> temp = new ArrayList<List<String>>();
		int greatestHeight = 0; // value of longest y coordinate yet encountered
		
		for (int i = 0; i < lines.size(); i++){
			List<String> list = new ArrayList<>();
			
			String line = lines.get(i);
			greatestHeight = Math.max(line.length(), greatestHeight);
			for (int j = 0; j < line.length(); j++){
				list.add(String.valueOf(line.charAt(j)));
			}
			temp.add(list);
		}
		
		// now safely transfer the temp array of values to an actual array, being careful to fill in default values
		String[][] rString = new String[greatestHeight][lines.size()];
		for (int i = 0; i < lines.size(); i++){
			List<String> line = temp.get(i);
			
			for (int j = 0; j < greatestHeight; j++){
				String cell = null;
				if (j < line.size()){
					cell = statusMap.get(line.get(j));
				}
				// protect against null/illegal values surrounded by legal values
				if (cell == null){
					cell = defaultValue;
				}					
				rString[j][i] = cell;
			}			
		}
		this.array = rString;
		this.width = greatestHeight;
		this.height = temp.size();
	}
	
	public FileLoader(String fileName, Map<String,String> statusMap, int skipRows){
		this(fileName,statusMap,skipRows,"undefined");
	}
		
	private static List<String> makeLinesList(String fileName){
	
		List<String> lines = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()){
				lines.add(scanner.nextLine());
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lines;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String[][] getArray() {
		return array;
	}
}