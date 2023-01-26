/*
 * Class Name - AttributeChangerTest.java
 * Brief Description - Test Cases for AttributeChanger
 * @author G. Bulaong
 */

package uimanager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datahandler.CheckerComparator;

public class AttributeChangerTest {
	
	private AttributeChanger ac;
	private CheckerComparator cc;

	@Before
	public void setUp() throws Exception {
		this.ac = new AttributeChanger();
		this.cc = new CheckerComparator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetColorGreen() {
		int[] expectedColor = {162, 217, 87}; //Color green base on RGB
		int[] testColor     = this.ac.getColor(true);
		
		assertNotNull(testColor);
		this.cc.checkerCompareTwoArrsInteger(expectedColor, testColor);
		
	}
	
	@Test
	public void testColorRed() {
		int[] expectedColor = {230, 61, 61}; //Color red base on RGB
		int[] testColor     = this.ac.getColor(false);
		
		assertNotNull(testColor);
		this.cc.checkerCompareTwoArrsInteger(expectedColor, testColor);
		
	}

}
