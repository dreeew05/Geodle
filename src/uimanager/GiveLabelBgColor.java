/*
 * Class Name - GiveLabeBgColor.java
 * Brief Description - Gives color to the box
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Color;

import javax.swing.JLabel;

public class GiveLabelBgColor{

	public void setLabelBgColor(JLabel label, int[] color) {
		label.setBackground(new Color(
			color[0], color[1], color[2]));
		label.setOpaque(true);
		
	}

}
