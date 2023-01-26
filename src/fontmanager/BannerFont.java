/*
 * Class Name - BannerFont.java
 * Brief Description - Concrete class for the font
 *                     properties of the "Banner"
 * @author G. Bulaong
 */

package fontmanager;

import java.awt.Color;
import java.awt.Font;

public class BannerFont extends GameFont implements GiveFontProperties{

	@Override
	public int getFontSize() {
		return 14;
	}

	@Override
	public int getFontStyle() {
		return Font.PLAIN;
	}

	@Override
	public Color getForegroundColor() {
		return Color.WHITE;
	}

}
