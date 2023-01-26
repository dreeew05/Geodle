/*
 * Class Name - SetStaticImageLabel.java
 * Brief Description - Properties of the JLabel that
 *                     contains a static image
 *                     [Images that does have the 
 *                     same dimension] 
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;
import fontmanager.StatusFont;
import imagemanager.ResizeStaticImage;

public class SetStaticImageLabel extends SetSimpleLabel implements SetIndividualVisibility,
	SetFontProperties{
	
	private ResizeStaticImage img;
	
	private GiveDefaultFontName giveDefaultFontName;
	private GiveFontProperties giveFontProperties;
	
	public SetStaticImageLabel(Rectangle bounds,
						       JFrame frame,
						       ResizeStaticImage img) throws IOException{
		
		super(bounds, frame);
		this.img = img;
		
		this.giveDefaultFontName = new DefaultFontName();
		this.giveFontProperties  = new StatusFont();
		
		this.initializeStaticImageLabel();
		
	}
	
	private void setLabelImage() throws IOException {
		super.getLabel().setIcon(new ImageIcon(img.finalImage()));
	}
	
	private void setLabelTextGap() {
		super.getLabel().setIconTextGap(-75);
	}
	
	public JLabel getLabel() {
		return super.getLabel();
	}
	
	public String getLabelText() {
		return super.getLabel().getText();
	}
	
	@Override
	public void setVisibleOn() {
		super.getLabel().setVisible(true);
	}
	
	@Override
	public void setVisibleOff() {
		super.getLabel().setVisible(false);
	}

	@Override
	public void setFontLabel() {
		super.getLabel().setFont(new Font(this.giveDefaultFontName.getFontName(),
            this.giveFontProperties.getFontStyle(), 
            this.giveFontProperties.getFontSize()));
	}

	@Override
	public void setLabelFontColor() {
		super.getLabel().setForeground(Color.BLACK);
	}
	
	private void initializeStaticImageLabel() throws IOException {
		this.setLabelImage();
		this.setLabelTextGap();
		this.setFontLabel();
		this.setLabelFontColor();
	}
	
}
