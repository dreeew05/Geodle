/*
 * Class Name - GuessChecker.java
 * Brief Description - This is where checking of details is done.
 *                     Eg. (Guess Country vs Answer Country)
 *                         (Guess Country's First Letter vs 
 *                         Answer Country's Last Letter)
 * @author G. Bulaong
 */

package core;

import filemanager.RetrieveImage;

interface GuessChecker {
    
    public abstract boolean checkString(String answer, String guess);
    public abstract boolean checkChar(char answer, char guess);

}

public class CheckGuess extends CategoryDetail implements GuessChecker{
	private String AnsCountry, AnsContinent, category;
	private RetrieveImage retrieveImage;

    public CheckGuess(String country, String continent, String category){
        this.AnsCountry   = country;
        this.AnsContinent = continent;
        this.category  = category;
        
        this.retrieveImage = new RetrieveImage();
    }

    @Override
    public String getAnsCountry(){
        return this.AnsCountry;
    }

    public String getAnsContinent(){
        return this.AnsContinent;
    }
    
    private String getCategory() {
    	return this.category;
    }
    
    public char getFirstLetter(String country){
        char firstLetter =  country.charAt(0);
        return Character.toUpperCase(firstLetter);
    }
    public char getLastLetter(String country){
    	int stringLength = 0;
        stringLength = country.length();
        char lastLetter = country.charAt(stringLength - 1);
        return Character.toUpperCase(lastLetter);
    }

    public String getImageLocation(String country){
        String finalLocation = "";

        if(this.getCategory().equals("flags")){
            finalLocation = this.retrieveImage.getBaseLocation()
            	.concat("flags\\" + country + ".png");
        }
        else if(this.getCategory().equals("maps")){
            finalLocation = this.retrieveImage.getBaseLocation()
            	.concat("maps\\" + country + ".png");
        }
        else if(this.getCategory().equals("people")){
            finalLocation = this.retrieveImage.getBaseLocation()
            	.concat("people\\" + country + ".jpeg");
        }
        else if(this.getCategory().equals("capitals")){
            finalLocation = this.retrieveImage.getBaseLocation()
            	.concat("capitals\\" + country + ".jpg");
        }
        return finalLocation;
    }
    
    //Compare the string [COUNTRY, or CONTINENT]
    //of the guess to the correct answer
    public boolean checkString(String answer, String guess){
        boolean isTrue = false;
        if(answer.toUpperCase().equals(guess.toUpperCase())){
            isTrue = true;
        }
        return isTrue;
    }
    
    //Compare the character [FIRST LETTER, or LAST LETTER] 
    //of the guess to the correct answer
    public boolean checkChar(char answer, char guess){
        boolean isTrue = false;
        if(Character.toUpperCase(answer) == Character.toUpperCase(guess)){
            isTrue = true;
        }
        return isTrue;
    }
}