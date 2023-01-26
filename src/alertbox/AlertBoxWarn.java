/*
 * Class Name - AlerBoxWarn.java
 * Brief Description - A pop-up that will go out every time the
 *                     system wants to send a message
 * @author G. Bulaong
 */

package alertbox;

import javax.swing.JOptionPane;

public class AlertBoxWarn {
	public void alert(String titleBar, String infoMessage) {
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, 
			JOptionPane.INFORMATION_MESSAGE);
	}
}
