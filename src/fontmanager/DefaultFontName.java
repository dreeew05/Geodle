/*
 * Class Name - DefaultFontName.java
 * Brief Description - Concrete class that contains
 *                     the default font name.
 * @author G. Bulaong
 */

package fontmanager;

public class DefaultFontName extends GameFont implements GiveDefaultFontName{

	@Override
	public String getFontName() {
		return super.defaultFontName;
	}
	
}
