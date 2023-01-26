/*
 * Class Name - RandomNumberGenerator.java
 * Brief Description - Contains a method 
 *                     that returns a random number
 *                     given a provided size
 * @author G. Bulaong
 */

package datahandler;

import java.util.Random;

public class RandomNumberGenerator {
	public int generateRandomNumber(int size) {
    	Random rand = new Random();
    	int randomNum = rand.nextInt(size);
    	return randomNum;
    }
}
