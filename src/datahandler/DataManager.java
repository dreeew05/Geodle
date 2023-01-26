/*
 * Class Name - DataManager.java
 * Brief Description - Holds the repository of the game.
 *                     Contains its setter and getter methods.
 * @author G. Bulaong
 */

package datahandler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import filemanager.RetrieveFile;

public class DataManager extends RetrieveFile {
	
	public DataManager() {
		try {
			this.setWholeData(this.processWholeData(this.getFileLocation()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Scanner obj;
	private ArrayList<String[]> wholeData = new ArrayList<String[]>();
	
	public String getFileLocation() {
		return super.getBaseFileLocation().concat("data.csv");
	}
	
	private void setWholeData(ArrayList<String[]> wholeData) {
		this.wholeData = wholeData;
	}
	
	public ArrayList<String[]> getWholeData(){
		return this.wholeData;
	}
	
	//SET TO PUBLIC FOR TESTING PURPOSES
	//Convert the contents of the CSV into ArrayList
	public ArrayList<String[]> processWholeData(String fileLocation) throws Exception{
		ArrayList<String[]> tmpDataArrList = new ArrayList<String[]>();
        this.obj = new Scanner(new File(fileLocation));
        while(this.obj.hasNextLine()){
            String[] line = obj.nextLine().split(",");
            String[] dataArr = {line[1], line[2], line[3]};
            tmpDataArrList.add(dataArr);
        }
        this.obj.close();
        return tmpDataArrList;
    }
	
	//To check if the input country of the user is valid
	//and show suggestions to the comboBox
    public String[] generateCountries(ArrayList<String[]> arr){
        String[] countries = new String[arr.size()];
        for(int i = 0; i < countries.length; i++) {
        	countries[i] = arr.get(i)[0];
        }
        return countries;
    }
    
    private String[] parseResults(ArrayList<String[]> data, int index){
        String results[] = data.get(index);
        return results;
    }
    
    //Search for the index of the country from the ArrayList
    //and return its corresponding contents 
    //[CONTINENT, CAPITAL]
    public String[] getParsedResults(ArrayList<String[]> arr, String country){
        int index = Arrays.binarySearch(this.generateCountries(arr), country);
        String[] result = this.parseResults(arr, index);
        
        return result;
    }
}
