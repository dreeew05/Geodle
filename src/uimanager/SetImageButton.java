/*
 * Class Name - SetImageButton.java
 * Brief Description - Properties of the JButton 
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import imagemanager.ResizeStaticImage;

public class SetImageButton extends SetSimpleButton 
	implements SetIndividualVisibility{
	
	private ResizeStaticImage img;
	
	public SetImageButton(Rectangle bounds,
						  JFrame frame,
						  String name, 
						  ResizeStaticImage img) throws IOException {
		
		super(bounds, frame, name);
		this.img = img;
		
	}
	
	private void setButtonImage() throws IOException {
		this.getButton().setIcon(new ImageIcon(img.finalImage()));
	}
	
	public JButton button() throws IOException {
		this.setButtonImage(); 
		return this.getButton();
		
	}
	
	@Override
	public void setVisibleOn() {
		super.getButton().setVisible(true);
	}
	
	@Override
	public void setVisibleOff() {
		super.getButton().setVisible(false);
	}
	
}
