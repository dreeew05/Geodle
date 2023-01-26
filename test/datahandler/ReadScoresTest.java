/*
 * Class Name - ReadScoresTest.java
 * Brief Description - Test Cases for ReadScores
 * @author G. Bulaong
 */

package datahandler;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ReadScoresTest {
	
	private ReadScores        rs1,
	                          rs2;
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
		
		this.setBaseLocation(System.getProperty("user.dir")
                				 .concat("\\test\\assets\\"
                				 + "testFiles\\"));
		
		String testFileName1 = this.getBaseLocation().concat("testLeaderBoard1.csv"),
			   testFileName2 = this.getBaseLocation().concat("testLeaderBoard2.csv");
		
		this.rs1 = new ReadScores(testFileName1);
		this.rs2 = new ReadScores(testFileName2);
		
		this.cc = new CheckerComparator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTopTen5Items() throws Exception {
		String[][] expectedArr = {
				{"Name", "Score", "Date"},
				{"Item1", "1998", "2022-12-05"},
				{"Item2", "1500", "2022-12-05"},
				{"Item3", "1234", "2022-12-05"},
				{"Item4", "895",  "2022-12-05"},
				{"Item5", "789",  "2022-12-05"},
				{"None",  "None", "None"},
				{"None",  "None", "None"},
				{"None",  "None", "None"},
				{"None",  "None", "None"},
				{"None",  "None", "None"}};
		
		ArrayList<String[]> testArrList = new ArrayList<String[]>();
		
		testArrList = rs1.returnTopTen();
		
		cc.checkerCompareTwoArrLists(expectedArr, testArrList);
	}
	
	@Test
	public void testTopTen10Items() throws Exception {
		String[][] expectedArr = {
				{"Name",  "Score", "Date"},
				{"Item1",  "1998", "2022-12-05"},
				{"Item2",  "1500", "2022-12-05"},
				{"Item3",  "1234", "2022-12-05"},
				{"Item4",  "895",  "2022-12-05"},
				{"Item5",  "789",  "2022-12-05"},
				{"Item6",  "777",  "2022-12-05"},
				{"Item7",  "655",  "2022-12-05"},
				{"Item8",  "555",  "2022-12-05"},
				{"Item9",  "444",  "2022-12-05"},
				{"Item10", "333",  "2022-12-05"}};
		
		ArrayList<String[]> testArrList = new ArrayList<String[]>();
		
		testArrList = rs2.returnTopTen();
		
		cc.checkerCompareTwoArrLists(expectedArr, testArrList);
	}

}
