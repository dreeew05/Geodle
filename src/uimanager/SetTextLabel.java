/*
 * Class Name - SetTextLabel.java
 * Brief Description - Properties of the JLabel that
 *                     contains a text
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;

import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;
import fontmanager.LabelFont;

public class SetTextLabel extends SetSimpleLabel implements SetFontProperties,
	GiveText, GiveBgColor{
	
	private GiveDefaultFontName giveFontName;
	private GiveFontProperties  giveFontProperties;
	
	private GiveLabelBgColor labelBgColor;
	
	public SetTextLabel(Rectangle bounds,
						JFrame frame) {
		
		super(bounds, frame);
		
		this.giveFontName        = new DefaultFontName();
		this.giveFontProperties  = new LabelFont();
		this.labelBgColor        = new GiveLabelBgColor();
		
		this.initializeTextLabel();
	}
	
	@Override
	public void labelSetText(String text) {
		super.getLabel().setText(text);
	}
	
	@Override
	public void setLabelFontColor() {
		super.getLabel().setForeground(giveFontProperties.getForegroundColor());
	}
	
	@Override
	public void setFontLabel() {
		super.getLabel().setFont(new Font(this.giveFontName.getFontName(),
			this.giveFontProperties.getFontStyle(), 
			this.giveFontProperties.getFontSize()));
	}
	
	@Override
	public void giveBgColor(int[] color) {
		this.labelBgColor.setLabelBgColor(this.getLabel(), color);
	}
	
	private void initializeTextLabel() {
		this.setFontLabel();
		this.setLabelFontColor();
	}
	
}
