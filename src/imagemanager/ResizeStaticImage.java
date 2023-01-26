/*
 * Class Name - ResizeStaticImage.java
 * Brief Description - When the image's dimension
 *                     is not changing for all its kind,
 *                     you call this class.
 *                     [Eg. Game's buttons]
 * @author G. Bulaong
 */

package imagemanager;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizeStaticImage extends BaseResizeImage{

    private String filename;

    public ResizeStaticImage(int maxHeight, int maxWidth, String filename){
    	super(maxHeight, maxWidth);
        this.filename = filename;

    }
    
    private String getFilename() {
    	return this.filename;
    }
    
    public BufferedImage finalImage() throws IOException {
    	return super.createImage(this.getFilename());
    }
}