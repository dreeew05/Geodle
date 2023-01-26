/*
 * Class Name - BaseResizeImage.java
 * Brief Description - A super class that resizes an image
 * @author G. Bulaong
 */

package imagemanager;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseResizeImage {
	
	private int maxHeight, maxWidth;
	
	public BaseResizeImage(int maxHeight, int maxWidth) {
		this.maxHeight = maxHeight;
		this.maxWidth  = maxWidth;
	}
	
	protected int getMaxHeight() {
		return this.maxHeight;
	}
	
	protected int getMaxWidth() {
		return this.maxWidth;
	}
	
	//Returns an appropriate dimension that is 
	//bounded by the max length and width
	protected Dimension getScaledDimension(Dimension imageDimension, Dimension maxDimension) {
    	double originalHeight = imageDimension.getHeight();
    	double originalWidth  = imageDimension.getWidth();
    	double maxHeight      = maxDimension.getHeight();
    	double maxWidth       = maxDimension.getWidth();
    	double resizedHeight  = 0;
    	double resizedWidth   = 0;
    	
    	double widthRatio = maxWidth / originalWidth;
    	double heightRatio = maxHeight / originalHeight;
    	double ratio = Math.min(widthRatio, heightRatio);
    	
    	resizedWidth  = originalWidth * ratio;
    	resizedHeight = originalHeight * ratio;
		
		return new Dimension((int) resizedWidth, (int) resizedHeight);
    	
    }
	
	public BufferedImage createImage(String filename) throws IOException {
		BufferedImage bimg = ImageIO.read(new File(filename));
    	Dimension imageDim = new Dimension(bimg.getWidth(), bimg.getHeight());
    	Dimension boundaryDim = new Dimension(this.getMaxWidth(), this.getMaxHeight());
    	Dimension resizedDim = this.getScaledDimension(imageDim, boundaryDim);
		Image tmp = bimg.getScaledInstance((int) resizedDim.getWidth(), 
			(int) resizedDim.getHeight(), Image.SCALE_SMOOTH);
    	
    	BufferedImage resizedImage = new BufferedImage((int) resizedDim.getWidth(), 
    		(int) resizedDim.getHeight(), BufferedImage.TYPE_INT_ARGB);
    	
    	Graphics2D g2d = resizedImage.createGraphics();
    	g2d.drawImage(tmp, 0, 0, null);
    	g2d.dispose();
    	
    	return resizedImage;
	}
	
}
