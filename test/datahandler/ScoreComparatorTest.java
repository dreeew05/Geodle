/*
 * Class Name - ScoreComparatorTest.java
 * Brief Description - Test Cases for ScoreComparator
 * @author G. Bulaong
 */

package datahandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreComparatorTest {
	
	private ScoreComparator sc;

	@Before
	public void setUp() throws Exception {
		this.sc = new ScoreComparator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDescendingOrderAnswer795() {
		String[] obj1 = {"Jose",  "210",  "2022-12-09"};
		String[] obj2 = {"Rizal", "1005", "2022-12-08"};
		
		assertEquals(795, sc.compare(obj1, obj2));
	}
	
	@Test
	public void testDescendingOrderAnswerNega1123() {
		String[] obj1 = {"Jose",  "2021",  "2022-12-09"};
		String[] obj2 = {"Rizal", "898", "2022-12-08"};
		
		assertEquals(-1123, sc.compare(obj1, obj2));
	}

}
