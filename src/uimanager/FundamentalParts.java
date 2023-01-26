/*
 * Class Name - FundamentalParts.java
 * Brief Description - Contains the fundamental parts
 *                     of the GUI [bounds, frame]
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class FundamentalParts {
	
	public Rectangle bounds;
	public JFrame    frame;
	
	public FundamentalParts(Rectangle bounds,
							JFrame frame) {
		
		this.bounds = bounds;
		this.frame  = frame;
		
	}
	
	protected Rectangle getBounds() {
		return this.bounds;
	}
	
	protected JFrame getFrame() {
		return this.frame;
	}
	
}

