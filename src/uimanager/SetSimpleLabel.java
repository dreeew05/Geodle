/*
 * Class Name - SetSimpleLabel.java
 * Brief Description - Properties of a basic
 *                     JLabel
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SetSimpleLabel extends FundamentalParts{
	
	private JLabel label;
	
	public SetSimpleLabel(Rectangle bounds,
						  JFrame frame) {
		
		super(bounds, frame);
		
		this.createJLabel();
		this.initializeJLabel();
	}
	
	protected JLabel getLabel() {
		return this.label;
	}
	
	private void createJLabel() {
		this.label = new JLabel();
	}
	
	private void centerLabel() {
		this.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void initializeJLabel() {
		this.centerLabel();
		this.getLabel().setBounds(this.getBounds());
		this.getFrame().getContentPane().add(this.getLabel());
	}
	
}
