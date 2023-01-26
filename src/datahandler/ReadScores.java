/*
 * Class Name - ReadScores.java
 * Brief Description - Reads the contents of the CSV 
 *                     and transform it into quantifiable
 *                     data that can be sorted
 * @author G. Bulaong
 */

package datahandler;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadScores {
	
	private String fileLocation;
	
	private Scanner obj;
	
	private ArrayList<String[]> sortedScores = new ArrayList<String[]>();
	
	public ReadScores(String fileLocation) {
		this.fileLocation = fileLocation;
		
		try {
			this.sortScores();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getFileLocation() {
		return this.fileLocation;
	}
	
	private void sortScores() throws Exception{
 		this.obj = new Scanner(new File(this.getFileLocation()));
		
		//Read from CSV
		while(this.obj.hasNextLine()) {
			String[] line = obj.nextLine().split(",");
			String[] dataArr = {line[0], line[1], line[2]};
			sortedScores.add(dataArr);
		}
		this.obj.close();
		
		Collections.sort(sortedScores, new ScoreComparator());
	}
	
	//Returns the top 10 Scorers depending on the mode
	//or category
	public ArrayList<String[]> returnTopTen() throws Exception {
		ArrayList<String[]> topTen = new ArrayList<String[]>();
		
		String[] header = {"Name", "Score", "Date"};
		topTen.add(header);
		
		String[] emptyArr = {"None", "None", "None"};
		
		for(int i = 0; i < 10; i++) {
			if(i < this.sortedScores.size()) {
				topTen.add(sortedScores.get(i));
			}
			else {
				topTen.add(emptyArr);
			}
		}
		return topTen;
	}
}
