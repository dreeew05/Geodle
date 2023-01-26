/*
 * Class Name - SetSimpleButton.java
 * Brief Description - Properties of the JButton
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;
import fontmanager.LabelFont;

public class SetSimpleButton extends FundamentalParts{
	
	private JButton button;
	private String name;
	
	private GiveDefaultFontName giveDefaultFontName;
	private GiveFontProperties  giveFontProperties;

	public SetSimpleButton(Rectangle bounds,
			               JFrame frame,
			               String name) {
		
		super(bounds, frame);
		this.name = name;
		
		this.giveDefaultFontName = new DefaultFontName();
		this.giveFontProperties = new LabelFont();
		
		this.createJButton();
		this.initializeJButton();
	}
	
	protected JButton getButton() {
		return this.button;
	}
	
	protected String getName() {
		return this.name;
	}
	
	private void createJButton() {
		this.button = new JButton();
	}
	
	private void centerButton() {
		this.getButton().setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void defaultFontButton() {
		this.getButton().setFont(new Font(this.giveDefaultFontName.getFontName(), 
			Font.PLAIN, this.giveFontProperties.getFontSize()));
	}
	
	private void initializeJButton() {
		this.centerButton();
		this.defaultFontButton();
		this.getButton().setName(this.getName());
		this.getButton().setBounds(this.getBounds());
		this.getFrame().getContentPane().add(this.getButton());
	}
	
	

}
