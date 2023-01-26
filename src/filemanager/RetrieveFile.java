/*
 * Class Name - RetrieveFile.java
 * Brief Description - Contains the getter method
 *                     of the base location of all files
 *                     of the game
 * @author G. Bulaong
 */

package filemanager;

public class RetrieveFile {
	public String getBaseFileLocation() {
		return System.getProperty("user.dir") + "\\src\\assets\\files\\";
	}
}
