/*
 * Class Name - CustomizableLabel.java
 * Brief Description - Properties of a JLabel that has customized
 *                     font properties
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;

import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;

public class CustomizableLabel extends SetSimpleLabel implements SetFontProperties,
	GiveText{

	private int fontStyle,
	            fontSize;
	
	private Color textColor;
	
	private GiveDefaultFontName defaultFontName;
	
	public CustomizableLabel(Rectangle bounds, 
			                 JFrame frame,
			                 int fontStyle,
			                 int fontSize) {
		
		super(bounds, frame);
		this.fontStyle = fontStyle;
		this.fontSize  = fontSize;
		
		this.defaultFontName = new DefaultFontName();
		
		this.initializeCustomizeLabel();
	}
	
	private void setColor(Color textColor) {
		this.textColor = textColor;
	}
	
	private Color getColor() {
		return this.textColor;
	}
	
	private int getFontStyle() {
		return this.fontStyle;
	}
	
	private int getFontSize() {
		return this.fontSize;
	}

	@Override
	public void labelSetText(String text) {
		super.getLabel().setText(text);
	}

	@Override
	public void setFontLabel() {
		super.getLabel().setFont(new Font(this.defaultFontName.getFontName(),
			this.getFontStyle(), this.getFontSize()));
	}

	@Override
	public void setLabelFontColor() {
		super.getLabel().setForeground(this.getColor());
	}
	
	private void initializeCustomizeLabel() {
		this.setColor(Color.WHITE);
		this.setFontLabel();
		this.setLabelFontColor();
	}

}
