/*
 * Class Name - BaseResizeImageTest.java
 * Brief Description - Test Cases for BaseResizeImage
 * @author G. Bulaong
 */

package imagemanager;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseResizeImageTest {
	
	private BaseResizeImage bri1,
		                    bri2,
		                    bri3;
	
	private Dimension origDimension1, maxDimension1,
	                  origDimension2, maxDimension2,
	                  origDimension3, maxDimension3;
	
	private String baseImageLocation;
	
	private String getBaseImageLocation() {
		return this.baseImageLocation;
	}
	
	private void setBaseImageLocation(String baseImageLocation) {
		this.baseImageLocation = baseImageLocation;
	}
	
	@Before
	public void setUp() throws Exception {
		this.bri1           = new BaseResizeImage(800, 600);
		this.origDimension1 = new Dimension(1200, 400);
		this.maxDimension1  = new Dimension(bri1.getMaxWidth(), bri1.getMaxHeight());
		
		this.bri2           = new BaseResizeImage(1500, 450);
		this.origDimension2 = new Dimension(2500, 900);
		this.maxDimension2  = new Dimension(bri2.getMaxWidth(), bri2.getMaxHeight());
		
		this.bri3           = new BaseResizeImage(1800, 1500);
		this.origDimension3 = new Dimension(900, 2400);
		this.maxDimension3  = new Dimension(bri3.getMaxWidth(), bri3.getMaxHeight());
		
		this.setBaseImageLocation(System.getProperty("user.dir")
				                  .concat("\\test\\assets\\testImages\\"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScaledDimensionAns600x200() throws IOException {
		Dimension expectedDimension = new Dimension(600, 200);
		
		assertEquals(expectedDimension, this.bri1.getScaledDimension(
			this.origDimension1, this.maxDimension1));
		
		assertNotNull(this.bri1.createImage(this.getBaseImageLocation()
			      .concat("SampleImage1.jpeg")));
	}
	
	@Test
	public void testScaledDimensionAns450x162() throws IOException {
		Dimension expectedDimension = new Dimension(450, 162);
		
		assertEquals(expectedDimension, this.bri2.getScaledDimension(
			this.origDimension2, this.maxDimension2));
		
		assertNotNull(this.bri2.createImage(this.getBaseImageLocation()
			      .concat("SampleImage2.jpg")));
	}
	
	@Test
	public void testScaledDimensionAns675x1800() throws IOException {
		Dimension expectedDimension = new Dimension(675, 1800);
		
		assertEquals(expectedDimension, this.bri3.getScaledDimension(
			this.origDimension3, this.maxDimension3));
		
		assertNotNull(this.bri3.createImage(this.getBaseImageLocation()
			      .concat("SampleImage3.png")));
	}

}
