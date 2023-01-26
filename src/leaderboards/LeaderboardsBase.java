/*
 * Class Name - LeaderboardsBase.java
 * Brief Description - A superclass that receives
 *                     data from the pop-up that
 *                     prompts for name.
 * @author G. Bulaong
 */

package leaderboards;

import filemanager.RetrieveFile;

public class LeaderboardsBase extends RetrieveFile{
	
	private String classification,
	   			   name;
	private int    score;
	
	public LeaderboardsBase(String classification,
			  				String name,
			  				int score) {
		
		this.classification = classification;
		this.name           = name;
		this.score          = score;
	
	}
	
	public String getClassification() {
		return this.classification;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}

	public String getFileLocation() {
		return super.getBaseFileLocation().concat("leaderboards\\")
			.concat(this.getClassification()).concat(".csv");
	}
	
}
