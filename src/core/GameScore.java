/*
 * Class Name - GameScore.java
 * Brief Description - Contains the setter and getter methods
 *                     of the score and the multiplier
 * @author G. Bulaong
 */

package core;

public class GameScore {
	
	private int gameScore;
	private int multiplier;
	
	public GameScore() {
		this.initializeScore();
	}
	
	private void initializeScore() {
		this.gameScore = 0;
	}
	
	public int getMultiplier() {
		return this.multiplier;
	}
	
	public int getGameScore() {
		return this.gameScore;
	}
	
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	
	public void setGameScore(int seconds, int multiplier) {
		this.gameScore += seconds * multiplier;
	}
}
