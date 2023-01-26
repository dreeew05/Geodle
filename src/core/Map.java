/*
 * Class Name - Map.java
 * Brief Description - Holds the question, country's
 *                     name, image, and image location
 *                     if the category is MAPS
 * @author G. Bulaong
 */

package core;

import filemanager.RetrieveImage;

public class Map extends CategoryQuestion {
	private String country;
	private RetrieveImage retrieveImage;

    public Map(String country){
        this.country = country;
        
        this.retrieveImage = new RetrieveImage();
    }
    
    @Override
    public String getAnsCountry(){
        return this.country;
    }
    
    @Override
    public String getQuestion(){
        return "What country is this map?";
    }
    
    @Override
    public String getImageLocation(){
        return this.retrieveImage.getBaseLocation()
        	.concat("maps\\" + this.country + ".png"); 
    }
}