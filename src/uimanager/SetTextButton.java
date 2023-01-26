/*
 * Class Name - SetTextButton.java
 * Brief Description - Button that has a text inside
 *                     [ENTER BUTTON]
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SetTextButton extends SetSimpleButton{

	private String text;
	
	public SetTextButton(Rectangle bounds, 
						 JFrame frame, 
						 String name,
						 String text) {
		
		super(bounds, frame, name);
		this.text = text;
		
	}
	
	private void setButtonText() {
		super.getButton().setText(text);
	}
	
	public JButton button() {
		this.setButtonText();
		return super.getButton();
	}

}
