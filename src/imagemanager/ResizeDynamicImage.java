/*
 * Class Name - ResizeDynamicImage.java
 * Brief Description - When the image's dimension
 *                     is not the same for all its kind,
 *                     you call this class.
 *                     [Eg. Flag's Images]
 * @author G. Bulaong
 */

package imagemanager;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizeDynamicImage extends BaseResizeImage{
	
	public ResizeDynamicImage(int maxHeight, int maxWidth) {
		super(maxHeight, maxWidth);
	}
	
	public BufferedImage finalImage(String filename) throws IOException {
		return super.createImage(filename);
	}
	
}
