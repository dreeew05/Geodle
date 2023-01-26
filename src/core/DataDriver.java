/*
 * Class Name - DataDriver.java
 * Brief Description - Methods that move the data
 * @author G. Bulaong
 */

package core;

import java.util.ArrayList;
import java.util.Collections;

import datahandler.DataManager;
import datahandler.RandomNumberGenerator;

public class DataDriver {
	
	private DataManager dataManager;
	private RandomNumberGenerator rng;
	
	private String[] answer;
	private ArrayList<String> countriesBucket;
	
	public DataDriver() {
		this.dataManager = new DataManager();
		this.rng = new RandomNumberGenerator();
		this.countriesBucket = new ArrayList<>();
	}
	
	public int getRandomNumber(int size) {
		return rng.generateRandomNumber(size);
	}
	
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}
	
	public String[] getAnswer() {
		return this.answer;
	}
	
	public String[] generateAnswer() {
		return dataManager.getParsedResults(dataManager.getWholeData(),
			   dataManager.getWholeData().get(this.getRandomNumber(
			   dataManager.getWholeData().size()))[0]);
	}
	
	public String[] getReferenceCountries() {
		return this.dataManager.generateCountries(
			   this.dataManager.getWholeData());
	}
	
	public ArrayList<String> getCountriesBucket(){
		return this.countriesBucket;
	}
	
	public void addCountryToBucket(String country) {
		this.countriesBucket.add(country);
		Collections.sort(this.getCountriesBucket());
	}
	
}
