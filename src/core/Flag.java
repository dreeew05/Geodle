/*
 * Class Name - Flag.java
 * Brief Description - Holds the question, country's
 *                     name, image, and image location
 *                     if the category is FLAGS
 * @author G. Bulaong
 */

package core;

import filemanager.RetrieveImage;

public class Flag extends CategoryQuestion {
	private String country;
	private RetrieveImage retrieveImage;

    public Flag(String country){
        this.country = country;
        
        this.retrieveImage = new RetrieveImage();
    }
    
    @Override
    public String getAnsCountry(){
        return this.country;
    }
    
    @Override
    public String getQuestion(){
        return "What country is this flag?";
    }
    
    @Override
    public String getImageLocation(){
        return this.retrieveImage.getBaseLocation()
        	.concat("flags\\" + this.country + ".png"); 
    }
}
