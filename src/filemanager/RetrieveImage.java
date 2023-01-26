/*
 * Class Name - RetrieveImage.java
 * Brief Description - Contains the getter methods of base
 *                     image locations of the game
 * @author G. Bulaong
 */

package filemanager;

public class RetrieveImage {
	
	String baseLocation = System.getProperty("user.dir")
		.concat("\\src\\assets\\imgs\\");
	
	public String getBaseLocation(){
        return baseLocation;
    }
    public String getBaseLocation(String country){
        return baseLocation;
    }
    public String getBaseLocation(String folder, String filename) {
    	return baseLocation.concat(folder).concat(filename).concat(".png");
    }
}
