/*
 * Class Name - AlertBoxPromptName.java
 * Brief Description - Test Cases for AlertBoxPromptName
 * @author G. Bulaong
 */

package alertbox;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlertBoxPromptNameTest {

	private AlertBoxPromptName abpn1,
							   abpn2,
							   abpn3,
							   abpn4;
	
	@Before
	public void setUp() throws Exception {
		this.abpn1 = new AlertBoxPromptName("flags", 100);
		this.abpn2 = new AlertBoxPromptName("maps", 200);
		this.abpn3 = new AlertBoxPromptName("capitals", 300);
		this.abpn4 = new AlertBoxPromptName("people", 400);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserCloseBox() {
		//User closes the dialog box
		assertNotNull(this.abpn1.getNameFromBox());
	}
	@Test
	public void testUserEntersNameAndrew() {
		assertNotNull(this.abpn2.getNameFromBox());
	}
	@Test
	public void testUserEntersNameTest() {
		//User closes the dialog box
		assertNotNull(this.abpn3.getNameFromBox());
	}
	@Test
	public void testUserEntersNameRaidenShogun() {
		//User closes the dialog box
		assertNotNull(this.abpn4.getNameFromBox());
	}

}
