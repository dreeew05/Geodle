/*
 * Class Name - GameCounter.java
 * Brief Description - Contain the getter and setter 
 *                     methods of the max and current
 *                     game counters.
 * @author G. Bulaong
 */

package core;

public class GameCounter {
	
	private int gameCounter = 0, 
			    maxCounter  = 0;
	
	public int getGameCounter() {
		return this.gameCounter;
	}
	
	public int getMaxCounter() {
		return this.maxCounter;
	}
	
	public void setGameCounter(int gameCounter) {
		this.gameCounter = gameCounter;
	}
	
	public void setMaxCounter(int maxCounter) {
		this.maxCounter = maxCounter;
	}
	
}
