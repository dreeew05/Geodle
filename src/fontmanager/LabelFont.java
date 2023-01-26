/*
 * Class Name - LabelFont.java
 * Brief Description - Concrete class for the font
 *                     properties of the a default JLabel
 * @author G. Bulaong
 */

package fontmanager;

import java.awt.Color;
import java.awt.Font;

public class LabelFont extends GameFont implements GiveFontProperties{

	@Override
	public int getFontSize() {
		return 13;
	}

	@Override
	public int getFontStyle() {
		return Font.BOLD;
	}

	@Override
	public Color getForegroundColor() {
		return Color.WHITE;
	}
}
