/*
 * Class Name - RandomNumberGeneratorTest.java
 * Brief Description - Test Cases for RandomNumberGenerator
 * @author G. Bulaong
 */

package datahandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomNumberGeneratorTest {
	
	private RandomNumberGenerator rng;

	@Before
	public void setUp() throws Exception {
		this.rng = new RandomNumberGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void testBounds(int size, int randomNumber) {
		boolean isTrue = false;
		
		assertNotNull(randomNumber);
		
		if(0 <= randomNumber && randomNumber <= size) {
			isTrue = true;
			assertEquals(true, isTrue);
		}
		else {
			isTrue = false;
			assertEquals(false, isTrue);
		}
	}

	@Test
	public void testRNGBoundsSize10() {
		int size         = 10;
		int randomNumber = rng.generateRandomNumber(size);
		
		this.testBounds(size, randomNumber);
		
	}
	
	@Test
	public void testRNGBoundsSize50() {
		int size         = 50;
		int randomNumber = rng.generateRandomNumber(size);

		this.testBounds(size, randomNumber);
		
	}
	
	@Test
	public void testRNGBoundsSize100() {
		int size         = 100;
		int randomNumber = rng.generateRandomNumber(size);
		
		this.testBounds(size, randomNumber);
		
	}
	
	@Test
	public void testOutputMoreThanSize() {
		int size         = 100;
		int randomNumber = rng.generateRandomNumber(size);
		
		this.testBounds(size, randomNumber + size);
		
	}
	
	@Test
	public void testOutputLessThanSize() {
		int size         = 100;
		int randomNumber = rng.generateRandomNumber(size);
		
		this.testBounds(size, randomNumber - size);
		
	}

}
