/*
 * Class Name - DataManagerTest.java
 * Brief Description - Test Cases for DataManager
 * @author G. Bulaong
 */

package datahandler;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataManagerTest {

	private DataManager       dm;
	private CheckerComparator cc;
	
	private String baseLocation;
	
	private String getBaseLocation() {
		return this.baseLocation;
	}
	
	private void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	
	@Before
	public void setUp() throws Exception {
		this.dm = new DataManager();
		this.cc = new CheckerComparator();
		
		this.setBaseLocation("test\\assets\\testfiles\\");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWholeData1Line() throws Exception {
		String[][] expectedArr = {{"Afghanistan","Kabul","Asia"}};
		
		ArrayList<String[]> testArrList = dm.processWholeData(this.getBaseLocation()
				                          .concat("testData1.csv"));
		
		cc.checkerCompareTwoArrLists(expectedArr, testArrList);
	}
	
	@Test
	public void testWholeData5Lines() throws Exception {
		String[][] expectedArr = {{"Afghanistan","Kabul","Asia"},
					              {"Albania","Tirana","Europe"},
					              {"Algeria","Algiers","Africa"},
					              {"Andorra","Andorra la Vella","Europe"},
					              {"Angola","Luanda","Africa"}};
		
		ArrayList<String[]> testArrList = dm.processWholeData(this.getBaseLocation()
                                          .concat("testData2.csv"));
		
		cc.checkerCompareTwoArrLists(expectedArr, testArrList);
	}
	
	@Test
	public void testWholeData10Lines() throws Exception {
		String[][] expectedArr = {{"Afghanistan","Kabul","Asia"},
					              {"Albania","Tirana","Europe"},
					              {"Algeria","Algiers","Africa"},
					              {"Andorra","Andorra la Vella","Europe"},
					              {"Angola","Luanda","Africa"},
					              {"Antigua and Barbuda","Saint John's","North America"},
					              {"Argentina","Buenos Aires","South America"},
					              {"Armenia","Yerevan","Asia"},
					              {"Australia","Canberra","Oceania"},
					              {"Austria","Vienna","Europe"}};
		
		ArrayList<String[]> testArrList = dm.processWholeData(this.getBaseLocation()
                                          .concat("testData3.csv"));
		
		cc.checkerCompareTwoArrLists(expectedArr, testArrList);
	}

	@Test
	public void testGenerateCountries1Line() {
		String[] expectedArr = {"Afghanistan"};
		
		ArrayList<String[]> testArrList = new ArrayList<String[]>();
		String[] sample = {"Afghanistan","Kabul","Asia"};
		testArrList.add(sample);
		
		String[] testArr = dm.generateCountries(testArrList);
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
		
	}
	
	@Test
	public void testGenerateCountries3Lines() {
		String[] expectedArr = {"Afghanistan", "Albania", "Algeria"};
		
		ArrayList<String[]> testArrList = new ArrayList<String[]>();
		String[] sample  = {"Afghanistan","Kabul","Asia"};
		String[] sample2 = {"Albania","Tirana","Europe"};
		String[] sample3 = {"Algeria","Algiers","Africa"};
		testArrList.add(sample);
		testArrList.add(sample2);
		testArrList.add(sample3);
		
		String[] testArr = dm.generateCountries(testArrList);
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
		
	}
	
	@Test
	public void testGenerateCountries5Lines() {
		String[] expectedArr = {"Afghanistan", "Albania", "Algeria",
				                "Andorra", "Angola"};
		
		ArrayList<String[]> testArrList = new ArrayList<String[]>();
		String[] sample  = {"Afghanistan","Kabul","Asia"};
		String[] sample2 = {"Albania","Tirana","Europe"};
		String[] sample3 = {"Algeria","Algiers","Africa"};
		String[] sample4 = {"Andorra","Andorra la Vella","Europe"};
		String[] sample5 = {"Angola","Luanda","Africa"};
	              
		testArrList.add(sample);
		testArrList.add(sample2);
		testArrList.add(sample3);
		testArrList.add(sample4);
		testArrList.add(sample5);
		
		String[] testArr = dm.generateCountries(testArrList);
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
		
	}
	
	private ArrayList<String[]> generateArrList() {
		ArrayList<String[]> arrList = new ArrayList<String[]>();
		String[] sample  = {"Afghanistan","Kabul","Asia"};
		String[] sample2 = {"Albania","Tirana","Europe"};
		String[] sample3 = {"Algeria","Algiers","Africa"};
		String[] sample4 = {"Andorra","Andorra la Vella","Europe"};
		String[] sample5 = {"Angola","Luanda","Africa"};
	              
		arrList.add(sample);
		arrList.add(sample2);
		arrList.add(sample3);
		arrList.add(sample4);
		arrList.add(sample5);
		
		return arrList;
	}
	
	@Test
	public void testParsedResultsFoundAfghanistan() {
		String[] expectedArr = {"Afghanistan","Kabul","Asia"};
		String[] testArr     = dm.getParsedResults(this.generateArrList(), "Afghanistan");
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
	}
	
	@Test
	public void testParsedResultsFoundAlbania() {
		String[] expectedArr = {"Albania","Tirana","Europe"};
		String[] testArr     = dm.getParsedResults(this.generateArrList(), "Albania");
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
	}
	
	@Test
	public void testParsedResultsFoundAngola() {
		String[] expectedArr = {"Angola","Luanda","Africa"};
		String[] testArr     = dm.getParsedResults(this.generateArrList(), "Angola");
		
		cc.checkerCompareTwoArrsString(expectedArr, testArr);
	}

}
