/*
 * Class Name - AttributeChanger.java
 * Brief Description - Changes the appearance of the box
 *                     from the MainGame base on the 
 *                     guess of the user
 * @author G. Bulaong
 */

package uimanager;

public class AttributeChanger {
	public int[] getColor(boolean isCorrect) {
		int[] red = {230, 61, 61};
		int[] green = {162, 217, 87};
		int[] finalColor = (isCorrect) ? green : red;
		return finalColor;
	}
	
	//RED ==> Guess is wrong
	//Green ==> Guess is correct
	public void giveColor(SetTextLabel country, SetTextLabel continent, 
			              SetDynamicImageLabel guessImage, 
		                  SetTextLabel firstLetter, SetTextLabel lastLetter,
		                  int[] colorCountry, int[] colorContinent, 
		                  int[] colorFirstLetter, int[] colorLastLetter) {
		
		country.giveBgColor(colorCountry);
		continent.giveBgColor(colorContinent);
		guessImage.giveBgColor(colorCountry);
		firstLetter.giveBgColor(colorFirstLetter);
		lastLetter.giveBgColor(colorLastLetter);
			
	}
	
	//Set the boxes' color into grey [BLANK]
	public void defaultColor(SetTextLabel country, SetTextLabel continent, 
			                 SetDynamicImageLabel guessImage,
		                     SetTextLabel firstLetter, SetTextLabel lastLetter ) {
		
		int[] greyColor = {166, 166, 166};
		
		country.giveBgColor(greyColor);
		guessImage.giveBgColor(greyColor);
		continent.giveBgColor(greyColor);
		firstLetter.giveBgColor(greyColor);
		lastLetter.giveBgColor(greyColor);
		
	}
	
	//Write into the boxes using the contents from the parsed data
	public void giveText(SetTextLabel country, SetTextLabel continent,
		                 SetTextLabel firstLetter, SetTextLabel lastLetter,
		                 String countryText, String continentText,
		                 char firstLetterText, char lastLetterText) {
		
		country.labelSetText(countryText);
		continent.labelSetText(continentText);
		firstLetter.labelSetText(Character.toString(firstLetterText));
		lastLetter.labelSetText(Character.toString(lastLetterText));
		
	}
	
	//Set the boxes' texts into blank
	public void clearGuess(SetTextLabel country, SetTextLabel continent, 
			               SetDynamicImageLabel guessImage,
			               SetTextLabel firstLetter, SetTextLabel lastLetter ) {
		
		country.labelSetText("");
		guessImage.clearImage();
		continent.labelSetText("");
		firstLetter.labelSetText("");
		lastLetter.labelSetText("");
		
	}
}
