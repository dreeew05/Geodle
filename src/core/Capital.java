/*
 * Class Name - Capital.java
 * Brief Description - Holds the question, country's
 *                     name, image, and image location
 *                     if the category is CAPITALS
 * @author G. Bulaong
 */

package core;

import filemanager.RetrieveImage;

public class Capital extends CategoryQuestion{
	private String country;
	private RetrieveImage retrieveImage;

    public Capital(String country){
        this.country = country;
        
        this.retrieveImage = new RetrieveImage();
    }
    
    @Override
    public String getAnsCountry(){
        return this.country;
    }
    
    @Override
    public String getQuestion(){
        return "What is the country of this capital?";
    }
    
    @Override
    public String getImageLocation(){
        return this.retrieveImage.getBaseLocation()
        	.concat("capitals\\" + this.country + ".jpg"); 
    }
}
