/*
 * Class Name - SetGroupVisbility.java
 * Brief Description - Group of JButtons that can
 *                     be hidden after click
 * @author G. Bulaong
 */

package uimanager;

import java.util.ArrayList;

public class SetGroupVisibility {
	
	private ArrayList<SetImageButton> buttons;
	 
	public SetGroupVisibility(ArrayList<SetImageButton> buttons) {
		this.buttons = buttons;
	}
	
	public void setGroupVisibleOn() {
		for(SetImageButton sb : buttons) {
			sb.setVisibleOn();
		}
	}
	
	public void setGroupVisibleOff() {
		for(SetImageButton sb : buttons) {
			sb.setVisibleOff();
		}
	}
}
