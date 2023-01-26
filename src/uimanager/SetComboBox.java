/*
 * Class Name - SetComboBox.java
 * Brief Description - Properties of the JComboBox 
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import fontmanager.ComboBoxFont;
import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;

public class SetComboBox extends FundamentalParts{
	
	private JComboBox<String> combobox;
	
	private GiveDefaultFontName defaultFontName;
	private GiveFontProperties giveFontProperties;

	public SetComboBox(Rectangle bounds, 
					   JFrame frame) {
		super(bounds, frame);
		
		this.defaultFontName    = new DefaultFontName();
		this.giveFontProperties = new ComboBoxFont();
		
		this.createComboBox();
		this.initilializeJComboBox();
	}
	
	private void createComboBox() {
		this.combobox = new JComboBox<String>();
	}
	
	private void setComboBoxDefaultFont() {
		this.getComboBox().setFont(new Font(this.defaultFontName.getFontName(),
			giveFontProperties.getFontStyle(), giveFontProperties.getFontSize()));
	}
	
	private void initilializeJComboBox() {
		this.setComboBoxDefaultFont();
		this.getComboBox().setBounds(bounds);
		this.setComboBoxEditable();
		this.getFrame().getContentPane().add(this.getComboBox());
	}
	
	private void setComboBoxEditable() {
		this.getComboBox().setEditable(true);
	}
	
	public JComboBox<String> getComboBox() {
		return this.combobox;
	}
	
	public String selectedItem() {
		return this.getComboBox().getSelectedItem().toString();
	}
	
}
