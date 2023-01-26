/*
 * Class Name - CheckerComparator.java
 * Brief Description - Class that checks the 
 *                     contents of Arrays/ArrayLists
 * @author G. Bulaong
 */

package datahandler;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class CheckerComparator {
	
	public void checkerCompareTwoArrLists(String[][] expectedArr,
		ArrayList<String[]> testArrList) {
		
		ArrayList<String[]> expectedArrList = new ArrayList<String[]>();
		
		//Convert to ArrayList since it is the returned datatype
		for(String[] arr : expectedArr) {
			expectedArrList.add(arr);
		}
		
		//Check if same size
		assertEquals(expectedArrList.size(), testArrList.size());
		
		for(int i = 0; i < expectedArrList.size(); i++) {
			for(int j = 0; j < expectedArrList.get(0).length; j++) {
				//Check Each Content
				assertEquals(expectedArrList.get(i)[j], testArrList.get(i)[j]);
			}
		}
			
	}
	
	public void checkerCompareTwoArrsString(String[] expectedArr,
									        String[] testArr) {

		int counter = 0;
		for(String country: expectedArr) {
		assertEquals(country, testArr[counter]);
		counter++;
		}
		
		assertEquals(expectedArr.length, testArr.length);
	
	}
	
	public void checkerCompareTwoArrsInteger(int[] expectedArr,
			   						         int[] testArr) {

		int counter = 0;
		for(int country: expectedArr) {
		assertEquals(country, testArr[counter]);
		counter++;
		}
		
		assertEquals(expectedArr.length, testArr.length);
		
		}
	
}
