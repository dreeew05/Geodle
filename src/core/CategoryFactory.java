/*
 * Class Name - CategoryFactory.java
 * Brief Description - Generates the country's associated questions,
 *                     and image based on the category.
 * @author G. Bulaong
 */

package core;

import uimanager.SetBannerLabel;

public class CategoryFactory {
	
	private SetBannerLabel capitalLabel;
	private CategoryQuestion categoryQuestion;
	
	public CategoryFactory(SetBannerLabel capitalLabel) {
		this.capitalLabel = capitalLabel;
	}
	
	private SetBannerLabel getCapitalLabel() {
		return this.capitalLabel;
	}
	
	public void getCategoryDetails(String category,
								   String[] answer) {
		
		String country = answer[0],
			   capital = answer[1];
		
		//ONLY SHOW THIS JLABEL IF THE CATEGORY IS capitalS
		this.getCapitalLabel().setVisibleOff();
		
		switch(category) {
			case "flags":
				this.categoryQuestion = new Flag(country);
				break;
			case "maps":
				this.categoryQuestion = new Map(country);
				break;
			case "people":
				this.categoryQuestion = new People(country);
				break;
			case "capitals":
				this.categoryQuestion = new Capital(country);
				this.getCapitalLabel().setVisibleOn();
				this.getCapitalLabel().labelSetText(capital);
				break;
			default: 
				break;
		}
		
	}
	
	public String getQuestion() {
		return this.categoryQuestion.getQuestion();
	}
	
	public String getGuessImageLocation() {
		return this.categoryQuestion.getImageLocation();
	}
	
}
