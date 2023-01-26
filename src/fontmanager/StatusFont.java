/*
 * Class Name - StatusFont.java
 * Brief Description - Concrete class for the font
 *                     properties of the game's status bars
 *                     [ROUND, TIMER, SCORE]
 * @author G. Bulaong
 */

package fontmanager;

import java.awt.Color;
import java.awt.Font;

public class StatusFont extends GameFont implements GiveFontProperties{

	@Override
	public int getFontSize() {
		return 16;
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
