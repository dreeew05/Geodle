/*
 * Class Name - SetTable.java
 * Brief Description - Table for the leaderboard
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fontmanager.DefaultFontName;
import fontmanager.GiveDefaultFontName;
import fontmanager.GiveFontProperties;
import fontmanager.LabelFont;

public class SetTable extends FundamentalParts{
	
	private ArrayList<String[]> tableValues;
	
	private JPanel panel;
	
	private GiveDefaultFontName giveDefaultFont;
	private GiveFontProperties  giveFontProperties;
	
	public SetTable(Rectangle bounds, 
					   JFrame frame,
			           ArrayList<String[]> tableValues) {
		
		super(bounds, frame);
		this.tableValues = tableValues;
		
		this.giveDefaultFont    = new DefaultFontName();
		this.giveFontProperties = new LabelFont();
		
		this.initializeJTable();
	}
	
	private ArrayList<String[]> getTableValues(){
		return this.tableValues;
	}
	
	private void createPanel() {
		this.panel = new JPanel();
	}
	
	private void panelSetBounds() {
		this.getPanel().setBounds(this.getBounds());
	}
	
	private void setColor() {
		this.getPanel().setBackground(new Color(24, 80, 155));
	}
	
	private void setGrid() {
		
		final int COLUMNS = 11;
		final int ROWS    = 3;
		
		this.getPanel().setLayout(new GridLayout(COLUMNS, ROWS));
	}
	
	private void addToFrame() {
		this.getFrame().getContentPane().add(panel);
	}
	
	private JPanel getPanel() {
		return this.panel;
	}
	
	private void setTable() {
		for(String[] line : this.getTableValues()) {
			for(String data : line) {
				JLabel label = new JLabel(data, SwingConstants.CENTER);
				label.setFont(new Font(this.giveDefaultFont.getFontName(), Font.PLAIN,
						               giveFontProperties.getFontSize()));
				label.setForeground(Color.WHITE);
				this.getPanel().add(label);
			}
		}
	}
	
	private void initializeJTable() {
		this.createPanel();
		this.panelSetBounds();
		this.setColor();
		this.setGrid();
		this.setTable();
		this.addToFrame();
	}
}
