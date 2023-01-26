/*
 * Class Name - People.java
 * Brief Description - Holds the question, country's
 *                     name, image, and image location
 *                     if the category is PEOPLE
 * @author G. Bulaong
 */

package core;

import filemanager.RetrieveImage;

public class People extends CategoryQuestion{
	private String country;
	private RetrieveImage retrieveImage;

    public People(String country){
        this.country = country;
        
        this.retrieveImage = new RetrieveImage();
    }
    
    @Override
    public String getAnsCountry(){
        return this.country;
    }
    
    @Override
    public String getQuestion(){
        return "What country does this individual/people represent?";
    }
    
    @Override
    public String getImageLocation(){
        return this.retrieveImage.getBaseLocation()
        	.concat("people\\" + this.country + ".jpeg"); 
    }
}
