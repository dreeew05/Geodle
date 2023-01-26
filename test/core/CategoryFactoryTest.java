/*
 * Class Name - CategoryFactoryTest.java
 * Brief Description - Test Cases for CategoryFactoryTest
 * @author G. Bulaong
 */

package core;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import filemanager.RetrieveImage;
import uimanager.SetBannerLabel;

public class CategoryFactoryTest {
	
	private CategoryFactory categoryFactory1,
	                        categoryFactory2,
	                        categoryFactory3,
	                        categoryFactory4;
	
	private ArrayList<String[]> arrList1,
	                            arrList2,
	                            arrList3,
	                            arrList4;
	
	private SetBannerLabel tmpBanner;
	private JFrame tempFrame;
	private Rectangle tempRectangle;
	private RetrieveImage retrieveImage;

	@Before
	public void setUp() throws Exception {
		this.tempFrame = new JFrame();
		this.tempRectangle = new Rectangle(0, 0, 0, 0);
		this.tmpBanner = new SetBannerLabel(tempRectangle, tempFrame);
		this.retrieveImage = new RetrieveImage();
		
		this.categoryFactory1 = new CategoryFactory(this.tmpBanner);
		this.categoryFactory2 = new CategoryFactory(this.tmpBanner);
		this.categoryFactory3 = new CategoryFactory(this.tmpBanner);
		this.categoryFactory4 = new CategoryFactory(this.tmpBanner);
		
		this.arrList1 = new ArrayList<>();
		this.arrList2 = new ArrayList<>();
		this.arrList3 = new ArrayList<>();
		this.arrList4 = new ArrayList<>();
		
		String[] answer1 = {"Philippines", "Manila", "Asia"};
		String[] answer2 = {"Canada", "Ottawa", "North America"};
		String[] answer3 = {"France", "Paris", "Europe"};
		String[] answer4 = {"Egypt", "Cairo", "Africa"};
		
		this.arrList1.add(answer1);
		this.arrList2.add(answer2);
		this.arrList3.add(answer3);
		this.arrList4.add(answer4);
		
		this.categoryFactory1.getCategoryDetails("flags", answer1);
		this.categoryFactory2.getCategoryDetails("maps", answer2);
		this.categoryFactory3.getCategoryDetails("people", answer3);
		this.categoryFactory4.getCategoryDetails("capitals", answer4);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuestion() {
		
		assertEquals("What country is this flag?", this.categoryFactory1.getQuestion());
		assertNotNull(this.categoryFactory1.getQuestion());
		
		assertEquals("What country is this map?", this.categoryFactory2.getQuestion());
		assertNotNull(this.categoryFactory2.getQuestion());
		
		assertEquals("What country does this individual/people represent?", 
			this.categoryFactory3.getQuestion());
		assertNotNull(this.categoryFactory3.getQuestion());
		
		assertEquals("What is the country of this capital?", this.categoryFactory4.getQuestion());
		assertNotNull(this.categoryFactory4.getQuestion());
		
	}
	
	public void testImageLocation() {
		
		assertEquals(this.retrieveImage.getBaseLocation()
	        .concat( this.arrList1.get(0)[0] + ".png"), this.categoryFactory1
	        .getGuessImageLocation());
		assertNotNull(this.categoryFactory1.getGuessImageLocation());
		
		assertEquals(this.retrieveImage.getBaseLocation()
		        .concat( this.arrList2.get(0)[0] + ".png"), this.categoryFactory2
		        .getGuessImageLocation());
		assertNotNull(this.categoryFactory2.getGuessImageLocation());
		
		assertEquals(this.retrieveImage.getBaseLocation()
		        .concat( this.arrList3.get(0)[0] + ".jpeg"), this.categoryFactory3
		        .getGuessImageLocation());
		assertNotNull(this.categoryFactory1.getGuessImageLocation());
			
		assertEquals(this.retrieveImage.getBaseLocation()
		        .concat( this.arrList3.get(0)[0] + ".jpg"), this.categoryFactory3
		        .getGuessImageLocation());
		assertNotNull(this.categoryFactory3.getGuessImageLocation());
		
	}

}
