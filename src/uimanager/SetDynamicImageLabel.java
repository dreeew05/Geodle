/*
 * Class Name - SetDynamicImageLabel.java
 * Brief Description - Properties of the JLabel that
 *                     contains a dynamic image
 *                     [Images that does not have the 
 *                     same dimension] 
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SetDynamicImageLabel extends SetSimpleLabel 
	implements GiveBgColor{

	private GiveLabelBgColor labelBgColor;
	
	public SetDynamicImageLabel(Rectangle bounds, JFrame frame) {
		super(bounds, frame);
		
		this.labelBgColor = new GiveLabelBgColor();
	}
	
	public void setImage(BufferedImage image) {
		super.getLabel().setIcon(new ImageIcon(image));
	}
	
	public void clearImage() {
		super.getLabel().setIcon(null);
	}
	
	@Override
	public void giveBgColor(int[] color) {
		this.labelBgColor.setLabelBgColor(super.getLabel(), color);
	}

}
