/*
 * Class Name - AlertBoxPromptName.java
 * Brief Description - This pop-up will come out after the game is done
 *                     where the system will need a name to record
 *                     the session
 * @author G. Bulaong
 */

package alertbox;

import java.io.IOException;

import javax.swing.JOptionPane;

import leaderboards.LeaderboardsWrite;

public class AlertBoxPromptName {
	
	public AlertBoxPromptName (String classification,
			                   int score) throws IOException {
		
		String name = this.getNameFromBox();
		new LeaderboardsWrite(classification, name, score);
		
	}
	
	public String getNameFromBox() {
		String nameFromBox =  JOptionPane.showInputDialog("Enter Name: ");	
		
		/* Check if the user closed the input button. If this is the case,
		 * the user's name would be "Guest". Otherwise, the user's name
		 * is the input*/
		
		String userName = (nameFromBox == null) ? "Guest" : nameFromBox;
		return userName;
	}
	
}
