/*
 * Class Name - SetFrame.java
 * Brief Description - Create and Initialize 
 *                     JFrame
 * @author G. Bulaong
 */

package uimanager;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class SetJFrame {
	
	private JFrame frame;
	
	private int windowHeight,
	            windowWidth;
	
	public SetJFrame(int windowHeight,
		             int windowWidth) {
		 
		this.windowHeight = windowHeight;
		this.windowWidth  = windowWidth;
		
		this.createJFrame();
		this.initializeFrame();
		
	}
	
	public JFrame getJFrame() {
		return this.frame;
	}
	
	private int getWindowHeight() {
		return this.windowHeight;
	}
	
	private int getWindowWidth() {
		return this.windowWidth;
	}
	
	private void createJFrame() {
		this.frame = new JFrame("Geodle");
	}
	
	private void initializeFrame() {
		
		final Color BACKGROUND_COLOR = new Color(24, 80, 155);
		
		this.getJFrame().setSize(this.getWindowHeight(), 
			this.getWindowWidth());
		this.getJFrame().getContentPane().setBackground(
				BACKGROUND_COLOR);
		this.getJFrame().setLocationRelativeTo(null);
		this.getJFrame().setLayout(null);
		this.getJFrame().setResizable(false);
		this.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getJFrame().setVisible(true);
		
		this.getJFrame().addWindowListener(new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);
		    }
		});
		
	}
	
}
