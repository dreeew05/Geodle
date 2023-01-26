/*
 * Class Name - CheckersTest.java
 * Brief Description - Checks the checkCountryMethod
 *                     in Checkers.java
 * @author G. Bulaong
 */

package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersTest {
	
	private Checkers checkers;
	private DataDriver dataDriver;

	@Before
	public void setUp() throws Exception {
		
		this.dataDriver = new DataDriver();
		this.checkers = new Checkers(this.dataDriver);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void allCountriesAreFalse(String[] countries, String[] correctCountries) {
		for(String country : countries) {
			assertFalse(this.checkers.checkCountryInput(correctCountries, country));
			assertNotNull(this.checkers.checkCountryInput(correctCountries, country));
		}
}

	private void allCountriesAreTrue(String[] countries, String[] correctCountries) {
		for(String country : countries) {
			assertTrue(this.checkers.checkCountryInput(correctCountries, country));
			assertNotNull(this.checkers.checkCountryInput(correctCountries, country));
		}
	}

	@Test
	public void testCheckCountryInput() {
		
		String[] correctCountries = {"Argentina",
				"Canada",
                "Czechslovakia",
                "France",
                "Honduras",
                "Mexico",
                "Morocco",
                "Philippines",
                "Russia",
                "Thailand"};

		String[] sampleCountries = {"Philippines",
		               "Canada",
		               "France",
		               "Morocco",
		               "Argentina"};
		
		String[] errorCountries = {"Egypt",
		              "Portugal",
		              "Australia",
		              "Zimbabwe",
		              "China"};

		this.allCountriesAreFalse(errorCountries, correctCountries);
		this.allCountriesAreTrue(sampleCountries, correctCountries);
		
	}

}
