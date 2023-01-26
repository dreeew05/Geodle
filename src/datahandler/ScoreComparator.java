/*
 * Class Name - ScoreComparator.java
 * Brief Description - Compares the value of each given
 *                     combination that can be used
 *                     to sort the data into descending order.
 * @author G. Bulaong
 */

package datahandler;

import java.util.Comparator;

public class ScoreComparator implements Comparator<String[]>{

	@Override
	public int compare(String[] o1, String[] o2) {
		
		int score1 = Integer.parseInt(o1[1]);
		int score2 = Integer.parseInt(o2[1]);
		
		//DESCENDING ORDER
		return score2 - score1;
	}

}
