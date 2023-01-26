/*
 * Class Name - SetBannerLabel.java
 * Brief Description - Properties of the Banner Label
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;

import fontmanager.BannerFont;
import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;

public class SetBannerLabel extends SetSimpleLabel implements SetIndividualVisibility,
	SetFontProperties, GiveText, GiveBgColor{

	private GiveLabelBgColor    labelBgColor;
	private GiveFontProperties  giveFontProperties;
	private GiveDefaultFontName giveDefaultFontName;
	
	public SetBannerLabel(Rectangle bounds, 
						  JFrame frame) {
		
		super(bounds, frame);
		
		this.giveDefaultFontName = new DefaultFontName();
		this.giveFontProperties  = new BannerFont();
		this.labelBgColor        = new GiveLabelBgColor();
		
		this.initializeBanner();
	}
	
	public void setBannerBounds(Rectangle bounds) {
		super.getLabel().setBounds(bounds);
	}
	
	private int[] getBannerColor() {
		int[] bannerColor = {81, 82, 102};
		return bannerColor;
	}
	
	private void initializeBanner() {
		this.setFontLabel();
		this.setLabelFontColor();
		this.giveBgColor(this.getBannerColor());
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
	public void giveBgColor(int[] color) {
		this.labelBgColor.setLabelBgColor(super.getLabel(), color);
	}

	@Override
	public void labelSetText(String text) {
		super.getLabel().setText(text);
	}

	@Override
	public void setFontLabel() {
		super.getLabel().setFont(new Font(giveDefaultFontName.getFontName(),
           giveFontProperties.getFontStyle(), giveFontProperties.getFontSize()));
	}

	@Override
	public void setLabelFontColor() {
		super.getLabel().setForeground(giveFontProperties.getForegroundColor());
		
	}

}
