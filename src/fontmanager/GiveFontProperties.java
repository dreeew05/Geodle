/*
 * Class Name - GiveFontProperties.java
 * Brief Description - An Interface that gives
 *                     font properties to an object
 * @author G. Bulaong
 */

package fontmanager;

import java.awt.Color;

public interface GiveFontProperties {
	public int    getFontSize();
	public int    getFontStyle();
	public Color  getForegroundColor();
}
