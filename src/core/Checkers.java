/*
 * Class Name - Checkers.java
 * Brief Description - To Check for invalid inputs
 *                     and check for duplicate countries
 * @author G. Bulaong
 */

package core;

import java.util.Arrays;
import java.util.Collections;

public class Checkers {
	
	private DataDriver dataDriver;
	
	public Checkers(DataDriver dataDriver) {
		this.dataDriver = dataDriver;
	}
	
	private DataDriver getDataDriver() {
		return this.dataDriver;
	}
	
	public boolean checkCountryInput(String[] referenceCountries,
		                             String country) {
		
		int result = Arrays.binarySearch(referenceCountries, country);
    	boolean isValidCountry = (result > -1) ? true : false;
    	
    	return isValidCountry;
		
	}
	
	//EACH COUNTRY THAT THE USER IS GUESSING MUST BE UNIQUE
	public void checkForDuplicates() {
		String[] tempAnswer = new String[3];
		
		String country;
		
		do {
			tempAnswer = this.dataDriver.generateAnswer();
			country = tempAnswer[0];
		}
		while(Collections.binarySearch(this.getDataDriver().getCountriesBucket(), 
			country) > - 1);
		
		this.getDataDriver().addCountryToBucket(country);
		this.getDataDriver().setAnswer(tempAnswer);
		
	}
	
}
