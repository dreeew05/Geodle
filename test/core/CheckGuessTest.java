/*
 * Class Name - CheckGuessTest.java
 * Brief Description - Test Cases for CheckGuess
 * @author G. Bulaong
 */

package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckGuessTest {
	
	private CheckGuess cg1,
		 	           cg2,
		 	           cg3,
		 	           cg4,
		 	           cg5,
		 	           cg6;

	@Before
	public void setUp() throws Exception {
		this.cg1 = new CheckGuess("Philippines", "Asia", "flags");
		this.cg2 = new CheckGuess("Canada", "North America", "maps");
		this.cg3 = new CheckGuess("Brazil", "South America", "capitals");
		this.cg4 = new CheckGuess("Australia", "Oceania", "people");
		this.cg5 = new CheckGuess("France", "Europe", "flags");
		this.cg6 = new CheckGuess("Egypt", "Africa", "maps");
	}
	
	private void testLetters(char expected, char test) {
		assertNotNull(test);
		assertEquals(expected, test);
	}
	
	private void testLocations(String expected, String test) {
		assertNotNull(test);
		assertEquals(expected, test);
	}
	
	private void testBoolean(boolean testCorrect, boolean wrong) {
		assertNotNull(testCorrect);
		assertTrue(testCorrect);
		assertFalse(wrong);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//CHECK IF SAME FIRST LETTER
	@Test
	public void testGetFirstLetterPhilippines() {
		char expected = 'P';
		char test     = this.cg1.getFirstLetter(this.cg1.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetFirstLetterCanada() {
		char expected = 'C';
		char test     = this.cg2.getFirstLetter(this.cg2.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetFirstLetterBrazil() {
		char expected = 'B';
		char test     = this.cg3.getFirstLetter(this.cg3.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetFirstLetterAustralia() {
		char expected = 'A';
		char test     = this.cg4.getFirstLetter(this.cg4.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetFirstLetterFrance() {
		char expected = 'F';
		char test     = this.cg5.getFirstLetter(this.cg5.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetFirstLetterEgypt() {
		char expected = 'E';
		char test     = this.cg6.getFirstLetter(this.cg6.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	//CHECK IF SAME LAST LETTER
	@Test
	public void testGetLastLetterPhilippines() {
		char expected = 'S';
		char test     = this.cg1.getLastLetter(this.cg1.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetLastLetterCanada() {
		char expected = 'A';
		char test     = this.cg2.getLastLetter(this.cg2.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetLastLetterBrazil() {
		char expected = 'L';
		char test     = this.cg3.getLastLetter(this.cg3.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetLastLetterAustralia() {
		char expected = 'A';
		char test     = this.cg4.getLastLetter(this.cg4.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetLastLetterFrance() {
		char expected = 'E';
		char test     = this.cg5.getLastLetter(this.cg5.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	@Test
	public void testGetLastLetterEgypt() {
		char expected = 'T';
		char test     = this.cg6.getLastLetter(this.cg6.getAnsCountry());
		
		this.testLetters(expected, test);
	}
	
	//CHECK IF SAME IMAGE LOCATION
	@Test
	public void testGetImageLocationPhilippinesCategoryFlags() {
		String expected = this.cg1.getImageLocation("Philippines");
		String test     = this.cg1.getImageLocation(this.cg1.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	@Test
	public void testGetImageLocationCanadaMaps() {
		String expected = this.cg2.getImageLocation("Canada");
		String test     = this.cg2.getImageLocation(this.cg2.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	@Test
	public void testGetImageLocationBrazilCapitals() {
		String expected = this.cg3.getImageLocation("Brazil");
		String test     = this.cg3.getImageLocation(this.cg3.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	@Test
	public void testGetImageLocationAustrailiaPeople() {
		String expected = this.cg4.getImageLocation("Australia");
		String test     = this.cg4.getImageLocation(this.cg4.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	@Test
	public void testGameImageLocationFranceFlags() {
		String expected = this.cg5.getImageLocation("France");
		String test     = this.cg5.getImageLocation(this.cg5.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	@Test
	public void testGetImageLocationEgyptMaps() {
		String expected = this.cg6.getImageLocation("Egypt");
		String test     = this.cg6.getImageLocation(this.cg6.getAnsCountry());
		
		this.testLocations(expected, test);
	}
	
	//CHECK STRING [COUNTRY]
	@Test
	public void testCheckStringPhilippines() {
		boolean test  = this.cg1.checkString("Philippines", this.cg1.getAnsCountry());
		boolean wrong = this.cg1.checkString("Spain", this.cg1.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringCanada() {
		boolean test  = this.cg2.checkString("Canada", this.cg2.getAnsCountry());
		boolean wrong = this.cg2.checkString("Spain", this.cg2.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringBrazil() {
		boolean test  = this.cg3.checkString("Brazil", this.cg3.getAnsCountry());
		boolean wrong = this.cg3.checkString("Spain", this.cg3.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringAustralia() {
		boolean test  = this.cg4.checkString("Australia", this.cg4.getAnsCountry());
		boolean wrong = this.cg4.checkString("Spain", this.cg4.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringFrance() {
		boolean test  = this.cg5.checkString("France", this.cg5.getAnsCountry());
		boolean wrong = this.cg5.checkString("Spain", this.cg5.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringEgypt() {
		boolean test  = this.cg6.checkString("Egypt", this.cg6.getAnsCountry());
		boolean wrong = this.cg6.checkString("Spain", this.cg6.getAnsCountry());
		
		this.testBoolean(test, wrong);
	}

	//CHECK STRING [CONTINENT]
	@Test
	public void testCheckStringAsia() {
		boolean test  = this.cg1.checkString("Asia", this.cg1.getAnsContinent());
		boolean wrong = this.cg1.checkString("Antarctica", this.cg1.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringNorthAmerica() {
		boolean test  = this.cg2.checkString("North America", this.cg2.getAnsContinent());
		boolean wrong = this.cg2.checkString("Antarctica", this.cg2.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringSouthAmerica() {
		boolean test  = this.cg3.checkString("South America", this.cg3.getAnsContinent());
		boolean wrong = this.cg3.checkString("Antarctica", this.cg3.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringOceania() {
		boolean test  = this.cg4.checkString("Oceania", this.cg4.getAnsContinent());
		boolean wrong = this.cg4.checkString("Antarctica", this.cg4.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringEurope() {
		boolean test  = this.cg5.checkString("Europe", this.cg5.getAnsContinent());
		boolean wrong = this.cg5.checkString("Antarctica", this.cg5.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckStringAfrica() {
		boolean test  = this.cg6.checkString("Africa", this.cg6.getAnsContinent());
		boolean wrong = this.cg6.checkString("Antarctica", this.cg6.getAnsContinent());
		
		this.testBoolean(test, wrong);
	}
	
	//CHECK CHAR [FIRST LETTER OF COUNTRY]
	@Test
	public void testCheckCharFirstLetterPhilippines() {
		boolean test  = this.cg1.checkChar(this.cg1.getFirstLetter(this.cg1.getAnsCountry()), 'P');
		boolean wrong = this.cg1.checkChar(this.cg1.getFirstLetter(this.cg1.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);		
	}
	@Test
	public void testCheckCharFirstLetterCanada() {
		boolean test  = this.cg2.checkChar(this.cg2.getFirstLetter(this.cg2.getAnsCountry()), 'C');
		boolean wrong = this.cg2.checkChar(this.cg2.getFirstLetter(this.cg2.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharFirstLetterBrazil() {
		boolean test  = this.cg3.checkChar(this.cg3.getFirstLetter(this.cg3.getAnsCountry()), 'B');
		boolean wrong = this.cg3.checkChar(this.cg3.getFirstLetter(this.cg3.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharFirstLetterAustralia() {
		boolean test  = this.cg4.checkChar(this.cg4.getFirstLetter(this.cg4.getAnsCountry()), 'A');
		boolean wrong = this.cg4.checkChar(this.cg4.getFirstLetter(this.cg4.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharFirstLetterFrance() {
		boolean test  = this.cg5.checkChar(this.cg5.getFirstLetter(this.cg5.getAnsCountry()), 'F');
		boolean wrong = this.cg5.checkChar(this.cg5.getFirstLetter(this.cg5.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharFirstLetterEgypt() {
		boolean test  = this.cg6.checkChar(this.cg6.getFirstLetter(this.cg6.getAnsCountry()), 'E');
		boolean wrong = this.cg6.checkChar(this.cg6.getFirstLetter(this.cg6.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	
	//CHECK CHAR [LAST LETTER OF COUNTRY]
	@Test
	public void testCheckCharLastLetterPhilippines() {
		boolean test  = this.cg1.checkChar(this.cg1.getLastLetter(this.cg1.getAnsCountry()), 'S');
		boolean wrong = this.cg1.checkChar(this.cg1.getLastLetter(this.cg1.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharLastLetterCanada() {
		boolean test  = this.cg2.checkChar(this.cg2.getLastLetter(this.cg2.getAnsCountry()), 'A');
		boolean wrong = this.cg2.checkChar(this.cg2.getLastLetter(this.cg2.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharLastLetterBrazil() {
		boolean test  = this.cg3.checkChar(this.cg3.getLastLetter(this.cg3.getAnsCountry()), 'L');
		boolean wrong = this.cg3.checkChar(this.cg3.getLastLetter(this.cg3.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharLastLetterAustralia() {
		boolean test  = this.cg4.checkChar(this.cg4.getLastLetter(this.cg4.getAnsCountry()), 'A');
		boolean wrong = this.cg4.checkChar(this.cg4.getLastLetter(this.cg4.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharLastLetterFrance() {
		boolean test  = this.cg5.checkChar(this.cg5.getLastLetter(this.cg5.getAnsCountry()), 'E');
		boolean wrong = this.cg5.checkChar(this.cg5.getLastLetter(this.cg5.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}
	@Test
	public void testCheckCharLastLetterEgypt() {
		boolean test  = this.cg6.checkChar(this.cg6.getLastLetter(this.cg6.getAnsCountry()), 'T');
		boolean wrong = this.cg6.checkChar(this.cg6.getLastLetter(this.cg6.getAnsCountry()), 'Z');
		
		this.testBoolean(test, wrong);
	}

}
