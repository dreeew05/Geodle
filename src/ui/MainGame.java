/*
 * Class Name - MainGame.java
 * Brief Description - This is where the game
 *                     is played
 * @author G. Bulaong
 */

package ui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

//External Library
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import alertbox.AlertBoxPromptName;
import alertbox.AlertBoxWarn;
import core.DataDriver;
import core.CategoryFactory;
import core.CheckGuess;
import core.Checkers;
import core.CountDownTimer;
import core.GameCounter;
import core.GameScore;
import datahandler.DataManager;
import filemanager.RetrieveImage;
import imagemanager.ResizeDynamicImage;
import imagemanager.ResizeStaticImage;
import uimanager.AttributeChanger;
import uimanager.SetJFrame;
import uimanager.CustomizableLabel;
import uimanager.SetBannerLabel;
import uimanager.SetComboBox;
import uimanager.SetDynamicImageLabel;
import uimanager.SetStaticImageLabel;
import uimanager.SetTextButton;
import uimanager.SetTextLabel;

import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;

public class MainGame extends CountDownTimer implements ActionListener{
	
	private String mode, category;
	
	private DataManager           dataManager;  
	private DataDriver            dataDriver;
	private Checkers              checkers;
	private CategoryFactory		  categoryFactory;
	private AttributeChanger      attributeChanger;  
	private GameScore             gameScore;
	private GameCounter           gameCounter;
	
	private SetJFrame             createJFrame;
	
	private SetStaticImageLabel   scoreLabel, roundLabel, timerLabel;
	private SetDynamicImageLabel  mustGuessImageLabel, guessImageLabel1,
		                          guessImageLabel2, guessImageLabel3, guessImageLabel4;
	
	private SetBannerLabel        capitalLabel;
	
	private SetTextButton         enterButton;
	
	private SetComboBox           textFieldComboBox;
	
	private SetTextLabel          countryLabel1, continentLabel1, firstLetterLabel1, 
				                  lastLetterLabel1,
				                  countryLabel2, continentLabel2, firstLetterLabel2, 
				                  lastLetterLabel2,
						          countryLabel3, continentLabel3, firstLetterLabel3, 
						          lastLetterLabel3,
						          countryLabel4, continentLabel4, firstLetterLabel4, 
						          lastLetterLabel4;
	
	private CustomizableLabel     questionLabel;
	
	private ResizeDynamicImage    questionImage,
								  guessImage1, guessImage2, guessImage3, guessImage4;
	
	private AlertBoxWarn		  aBoxWarn;

	
	private final int MAX_IMAGE_HEIGHT = 207,
				 	  MAX_IMAGE_WIDTH  = 350;
	
	public MainGame(String mode, String category) throws Exception {
		this.mode     = mode;
		this.category = category;
		
		this.initializeUI();
		this.initializeGame();
		this.guessSelection();
		
	}

	//GETTER METHODS
	private String getMode() {
		return this.mode;
	}
	private String getCategory() {
		return this.category;
	}
	private int getMaxImageHeight() {
		return this.MAX_IMAGE_HEIGHT;
	}
	private int getMaxImageWidth() {
		return this.MAX_IMAGE_WIDTH;
	}
	
	//SETTER METHODS
	private void setCategory(String category) {
		//CHANGE CATEGORY ONLY FOR MIXED MODE
		this.category = category;
	}

	private void initializeGame() throws Exception {
		
		this.dataManager      = new DataManager();
		this.attributeChanger = new AttributeChanger();
		this.gameScore        = new GameScore();
		this.gameCounter      = new GameCounter();
		this.aBoxWarn         = new AlertBoxWarn();
		this.dataDriver       = new DataDriver();
		this.checkers         = new Checkers(this.dataDriver);
		this.categoryFactory  = new CategoryFactory(this.capitalLabel);
		
		if(this.getMode().equals("Single Mode")) {
			this.gameCounter.setMaxCounter(10);
		}
		else {
			this.gameCounter.setMaxCounter(15);
		}
		this.gameScore.setMultiplier(4);
		this.playGame();
	}
	private void initializeUI() throws IOException {
		
		final int    WINDOW_HEIGHT          = 710,
					 WINDOW_WIDTH           = 840,
					 STATUS_MAX_HEIGHT      = 52,
					 STATUS_MAX_WIDTH       = 172,
					 QUESTION_MAX_WIDTH     = 543,
					 QUESTION_MAX_HEIGHT    = 42,
					 GUESS_IMG_MAX_HEIGHT   = 60,
					 GUESS_IMG_MAX_WIDTH    = 130,
					 ENTER_BUTTON_HEIGHT    = 33,
					 ENTER_BUTTON_WIDTH     = 72,
					 COMBOBOX_HEIGHT        = 33,
					 COMBOBOX_WIDTH         = 364,
					 GUESS_CNTRY_MAX_HEIGHT = 26,
					 GUESS_CNTRY_MAX_WIDTH  = 476,
					 BOX_MAX_HEIGHT         = 60,
					 BOX_MAX_WIDTH          = 105,
					 IMG_BOX_MAX_WIDTH      = 130,
					 
					 ROUND_POS_X            = 59,
				     TIMER_POS_X            = 261,
					 SCORE_POS_X            = 463,
					 QUESTION_POS_X         = 75,
					 ANSWER_IMAGE_POS_X     = 172,
					 
					 COUNTRY_POS_X          = 102,
					 GUESS_IMAGE_POS_X      = 102,
					 CONTINENT_POS_X        = 243,
					 FIRST_LETTER_POS_X     = 358,
					 LAST_LETTER_POS_X      = 473,
					 
					 STATS_POS_Y            = 0,
					 QUESTION_POS_Y         = 49,
					 ANSWER_IMAGE_POS_Y     = 91,
					 
					 COUNTRY1_POS_Y         = 360,
					 GUESS_SET1_POS_Y       = 396,
					 COUNTRY2_POS_Y         = 470,
					 GUESS_SET2_POS_Y       = 506,
					 COUNTRY3_POS_Y         = 580,
					 GUESS_SET3_POS_Y       = 616,
					 COUNTRY4_POS_Y         = 690,
					 GUESS_SET4_POS_Y       = 726,
					 
					 ENTER_BUTTON_POS_X     = 488,
					 ENTER_BUTTON_POS_Y     = 313,
					 COMBOBOX_POS_X         = 116,
					 COMBOBOX_POS_Y         = 313;
	 
		final String FOLDER_NAME            = "\\others\\";
		
		RetrieveImage rtImg = new RetrieveImage();
		ResizeStaticImage scoreImage = new ResizeStaticImage(STATUS_MAX_HEIGHT, 
			STATUS_MAX_WIDTH, rtImg.getBaseLocation(FOLDER_NAME, "score"));
		ResizeStaticImage roundImage = new ResizeStaticImage(STATUS_MAX_HEIGHT, 
			STATUS_MAX_WIDTH, rtImg.getBaseLocation(FOLDER_NAME, "round"));
		ResizeStaticImage timerImage = new ResizeStaticImage(STATUS_MAX_HEIGHT, 
			STATUS_MAX_WIDTH, rtImg.getBaseLocation(FOLDER_NAME, "timer"));
		
		//==> Rectangle(pos_x, pos_y, width, height)
		Rectangle roundLabelBounds = new Rectangle(ROUND_POS_X,
			STATS_POS_Y, STATUS_MAX_WIDTH, STATUS_MAX_HEIGHT);
		Rectangle timerLabelBounds = new Rectangle(TIMER_POS_X,
			STATS_POS_Y, STATUS_MAX_WIDTH, STATUS_MAX_HEIGHT);
		Rectangle scoreLabelBounds  = new Rectangle(SCORE_POS_X,
			STATS_POS_Y, STATUS_MAX_WIDTH, STATUS_MAX_HEIGHT);
		Rectangle questionLabelBounds = new Rectangle(QUESTION_POS_X,
			QUESTION_POS_Y, QUESTION_MAX_WIDTH, QUESTION_MAX_HEIGHT);
		Rectangle mustGuessImageBounds = new Rectangle(ANSWER_IMAGE_POS_X,
			ANSWER_IMAGE_POS_Y, this.getMaxImageWidth(), this.getMaxImageHeight());
		Rectangle countryLabel1Bounds = new Rectangle(COUNTRY_POS_X,
			COUNTRY1_POS_Y, GUESS_CNTRY_MAX_WIDTH, GUESS_CNTRY_MAX_HEIGHT);
		Rectangle guessImageLabel1Bounds  = new Rectangle(GUESS_IMAGE_POS_X,
			GUESS_SET1_POS_Y, IMG_BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle continentLabel1Bounds = new Rectangle(CONTINENT_POS_X,
			GUESS_SET1_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle firstLetterLabel1Bounds = new Rectangle(FIRST_LETTER_POS_X,
			GUESS_SET1_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle lastLetterLabel1Bounds  = new Rectangle(LAST_LETTER_POS_X,
			GUESS_SET1_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle countryLabel2Bounds = new Rectangle(COUNTRY_POS_X,
			COUNTRY2_POS_Y, GUESS_CNTRY_MAX_WIDTH, GUESS_CNTRY_MAX_HEIGHT);
		Rectangle guessImageLabel2Bounds = new Rectangle(GUESS_IMAGE_POS_X,
			GUESS_SET2_POS_Y, IMG_BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle continentLabel2Bounds = new Rectangle(CONTINENT_POS_X,
			GUESS_SET2_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle firstLetterLabel2Bounds = new Rectangle(FIRST_LETTER_POS_X,
			GUESS_SET2_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle lastLetterLabel2Bounds = new Rectangle(LAST_LETTER_POS_X,
			GUESS_SET2_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle countryLabel3Bounds = new Rectangle(COUNTRY_POS_X,
			COUNTRY3_POS_Y, GUESS_CNTRY_MAX_WIDTH, GUESS_CNTRY_MAX_HEIGHT);
		Rectangle guessImageLabel3Bounds = new Rectangle(GUESS_IMAGE_POS_X,
			GUESS_SET3_POS_Y, IMG_BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle continentLabel3Bounds = new Rectangle(CONTINENT_POS_X,
			GUESS_SET3_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle firstLetterLabel3Bounds = new Rectangle(FIRST_LETTER_POS_X,
			GUESS_SET3_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle lastLetterLabel3Bounds = new Rectangle(LAST_LETTER_POS_X,
			GUESS_SET3_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle countryLabel4Bounds = new Rectangle(COUNTRY_POS_X,
			COUNTRY4_POS_Y, GUESS_CNTRY_MAX_WIDTH, GUESS_CNTRY_MAX_HEIGHT);
		Rectangle guessImageLabel4Bounds = new Rectangle(GUESS_IMAGE_POS_X,
			GUESS_SET4_POS_Y, IMG_BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle continentLabel4Bounds = new Rectangle(CONTINENT_POS_X,
			GUESS_SET4_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle firstLetterLabel4Bounds = new Rectangle(FIRST_LETTER_POS_X,
			GUESS_SET4_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle lastLetterLabel4Bounds = new Rectangle(LAST_LETTER_POS_X,
			GUESS_SET4_POS_Y, BOX_MAX_WIDTH, BOX_MAX_HEIGHT);
		Rectangle tempBannerBounds = new Rectangle(0, 0, 0, 0);
		Rectangle enterButtonBounds = new Rectangle(ENTER_BUTTON_POS_X,
			ENTER_BUTTON_POS_Y, ENTER_BUTTON_WIDTH, ENTER_BUTTON_HEIGHT);
		Rectangle comboBoxBounds = new Rectangle(COMBOBOX_POS_X,
			COMBOBOX_POS_Y, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		
		this.createJFrame = new SetJFrame(WINDOW_HEIGHT, WINDOW_WIDTH);
		
		this.scoreLabel = new SetStaticImageLabel(scoreLabelBounds, 
			this.createJFrame.getJFrame(), scoreImage);
		this.roundLabel = new SetStaticImageLabel(roundLabelBounds, 
			this.createJFrame.getJFrame(), roundImage);
		this.timerLabel = new SetStaticImageLabel(timerLabelBounds, 
			this.createJFrame.getJFrame(), timerImage);
		
		this.countryLabel1 = new SetTextLabel(countryLabel1Bounds, 
			this.createJFrame.getJFrame());
		this.continentLabel1 = new SetTextLabel(continentLabel1Bounds, 
			this.createJFrame.getJFrame());
		this.firstLetterLabel1   = new SetTextLabel(firstLetterLabel1Bounds, 
			this.createJFrame.getJFrame());
		this.lastLetterLabel1 = new SetTextLabel(lastLetterLabel1Bounds, 
			this.createJFrame.getJFrame());
		
		this.countryLabel2 = new SetTextLabel(countryLabel2Bounds, 
			this.createJFrame.getJFrame());
		this.continentLabel2 = new SetTextLabel(continentLabel2Bounds, 
			this.createJFrame.getJFrame());
		this.firstLetterLabel2 = new SetTextLabel(firstLetterLabel2Bounds, 
			this.createJFrame.getJFrame());
		this.lastLetterLabel2 = new SetTextLabel(lastLetterLabel2Bounds, 
			this.createJFrame.getJFrame());
		
		this.countryLabel3 = new SetTextLabel(countryLabel3Bounds, 
			this.createJFrame.getJFrame());
		this.continentLabel3 = new SetTextLabel(continentLabel3Bounds, 
			this.createJFrame.getJFrame());
		this.firstLetterLabel3 = new SetTextLabel(firstLetterLabel3Bounds, 
			this.createJFrame.getJFrame());
		this.lastLetterLabel3 = new SetTextLabel(lastLetterLabel3Bounds, 
			this.createJFrame.getJFrame());
		
		this.countryLabel4 = new SetTextLabel(countryLabel4Bounds, 
			this.createJFrame.getJFrame());
		this.continentLabel4 = new SetTextLabel(continentLabel4Bounds, 
			this.createJFrame.getJFrame());
		this.firstLetterLabel4 = new SetTextLabel(firstLetterLabel4Bounds, 
			this.createJFrame.getJFrame());
		this.lastLetterLabel4 = new SetTextLabel(lastLetterLabel4Bounds, 
			this.createJFrame.getJFrame());
		
		this.guessImageLabel1 = new SetDynamicImageLabel(guessImageLabel1Bounds, 
			this.createJFrame.getJFrame());
		this.guessImageLabel2 = new SetDynamicImageLabel(guessImageLabel2Bounds, 
			this.createJFrame.getJFrame());
		this.guessImageLabel3 = new SetDynamicImageLabel(guessImageLabel3Bounds, 
			this.createJFrame.getJFrame());
		this.guessImageLabel4 = new SetDynamicImageLabel(guessImageLabel4Bounds, 
			this.createJFrame.getJFrame());
		
		this.capitalLabel = new SetBannerLabel(tempBannerBounds, 
			this.createJFrame.getJFrame());
		
		this.mustGuessImageLabel = new SetDynamicImageLabel(mustGuessImageBounds, 
			this.createJFrame.getJFrame());
		
		this.questionLabel = new CustomizableLabel(questionLabelBounds, 
			this.createJFrame.getJFrame(), Font.BOLD, 16);
		
		this.enterButton = new SetTextButton(enterButtonBounds, 
			this.createJFrame.getJFrame(), "enterButton", "Enter");
		
		this.textFieldComboBox = new SetComboBox(comboBoxBounds, 
			this.createJFrame.getJFrame());
		
		//INITIAL SIZE OF IMAGE BASED ON THE MAX HEIGHT AND WIDTH OF JLABEL
		this.questionImage = new ResizeDynamicImage(this.getMaxImageHeight(),
			this.getMaxImageWidth());
		this.guessImage1 = new ResizeDynamicImage(GUESS_IMG_MAX_HEIGHT, 
			GUESS_IMG_MAX_WIDTH);
		this.guessImage2 = new ResizeDynamicImage(GUESS_IMG_MAX_HEIGHT, 
			GUESS_IMG_MAX_WIDTH);
		this.guessImage3 = new ResizeDynamicImage(GUESS_IMG_MAX_HEIGHT, 
			GUESS_IMG_MAX_WIDTH);
		this.guessImage4 = new ResizeDynamicImage(GUESS_IMG_MAX_HEIGHT,
			GUESS_IMG_MAX_WIDTH);
		
	}
	
	@Override
	public void timerRunsOut() {
		super.timerRunsOut();
		aBoxWarn.alert("Times Up!", "The correct answer is "
			.concat(this.dataDriver.getAnswer()[0]));
		
		try {
			this.resetScreen(0);	//0 TO CLEAR ALL
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void playGame() throws Exception {
		
		this.roundLabel.getLabel().setText(String.valueOf(
			this.gameCounter.getGameCounter() + 1));
		
		this.scoreLabel.getLabel().setText(String.valueOf(
			this.gameScore.getGameScore()));
		
		super.startTimer(this.timerLabel.getLabel());
		
		if(this.getMode().equals("Mixed Mode")) {
			String[] categories = {"flags", "maps", "people", "capitals"};
			this.setCategory(categories[this.dataDriver.getRandomNumber(4)]);
		}
		
		if(this.gameCounter.getGameCounter() < this.gameCounter.getMaxCounter()) {
			this.playCategory(this.getCategory());
			this.gameCounter.setGameCounter(this.gameCounter.getGameCounter() + 1);
		}
		else {
			
			String classification = (this.getMode().equals("Mixed Mode"))
									? "Mixed Mode"
									: this.getCategory();
			
			super.stopTimer();
			this.createJFrame.getJFrame().dispose();
			new AlertBoxPromptName(classification, gameScore.getGameScore());

		}
	}

	private void playCategory(String category) throws Exception {
	
		this.checkers.checkForDuplicates();
		
		this.categoryFactory.getCategoryDetails(this.getCategory(), this.dataDriver.getAnswer());
       
		this.questionLabel.labelSetText(this.categoryFactory.getQuestion().toUpperCase());
	
		BufferedImage finalQuestionImage = this.questionImage.finalImage(
			this.categoryFactory.getGuessImageLocation());
		
		this.mustGuessImageLabel.setImage(finalQuestionImage);
		
		//TO HAVE SAME WIDTH WITH IMAGE
		final int BANNER_POSX   = 172,
				  BANNER_POSY   = 278,
				  BANNER_HEIGHT = 20;
		
		int questionImageWidth  = finalQuestionImage.getWidth();
		int questionImageHeight = finalQuestionImage.getHeight();
		int imageEdgeWidth      = (this.getMaxImageWidth() - questionImageWidth) / 2;	
		int imageEdgeHeight     = (this.getMaxImageHeight() - questionImageHeight) / 2;	
		
		Rectangle bannerBounds  = new Rectangle(BANNER_POSX + imageEdgeWidth,
			BANNER_POSY - imageEdgeHeight, questionImageWidth, BANNER_HEIGHT);
		
		this.capitalLabel.setBannerBounds(bannerBounds);
        
		//SET THE BOXES' COLOR TO GREY
		attributeChanger.defaultColor(countryLabel1, continentLabel1, 
			guessImageLabel1, firstLetterLabel1, lastLetterLabel1);
		attributeChanger.defaultColor(countryLabel2, continentLabel2, 
			guessImageLabel2, firstLetterLabel2, lastLetterLabel2);
		attributeChanger.defaultColor(countryLabel3, continentLabel3, 
			guessImageLabel3, firstLetterLabel3, lastLetterLabel3);
		attributeChanger.defaultColor(countryLabel4, continentLabel4, 
			guessImageLabel4, firstLetterLabel4, lastLetterLabel4);
	}
	
	//COMBOBOX
	private void guessSelection() {
		
		String[] countries = this.dataDriver.getReferenceCountries();
		
		AutoCompleteDecorator.decorate(textFieldComboBox.getComboBox());
		this.textFieldComboBox.getComboBox().setModel(new DefaultComboBoxModel
			<String>(countries));
		this.enterButton.button().addActionListener(this);
		
	}
	
	//ENTER BUTTON
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String textFromField = textFieldComboBox.selectedItem();
		
		boolean isValid      = this.checkers.checkCountryInput(
							   this.dataDriver.getReferenceCountries(), textFromField);
		
		boolean isCorrect    = textFromField.equals(this.dataDriver.getAnswer()[0]) 
							   ? true 
						       : false;
		
		if(!isValid) {
			aBoxWarn.alert("Error!", "Invalid Input. Please try again");
			return;
		}
		
		String guess[] = this.dataManager.getParsedResults(this.dataManager.getWholeData(), 
				         textFromField);
		try {
			guessIt(this.dataDriver.getAnswer(), guess, this.gameScore.getMultiplier());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(!isCorrect) {
			this.gameScore.setMultiplier(this.gameScore.getMultiplier() - 1);
			if(this.gameScore.getMultiplier() != 0) {
				return;
			}
		}
		
		super.stopTimer();
		//CONVERT BOOL TO INT TO USE SWITCH
		int alertBoxValue = isCorrect ? 1 : 0;
		
		switch(alertBoxValue) {
			case 1:
				this.aBoxWarn.alert("Congratulations!", "You entered the correct answer");
				break;
			default:
				this.aBoxWarn.alert("All guesses are used!", "The correct answer is "
					.concat(this.dataDriver.getAnswer()[0]));
				break;
		}
		
		try {
			resetScreen(gameScore.getMultiplier());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	//REFLECTION OF THE USER'S INPUT
	private void guessIt(String[] answer, String[] guess, int guessLeft) throws IOException {
		CheckGuess cg = new CheckGuess(answer[0], answer[2], category);
		
		char answerFirstLetter = cg.getFirstLetter(cg.getAnsCountry());
		char answerLastLetter  = cg.getLastLetter(cg.getAnsCountry());
		
		String guessCountry      = guess[0];
		String guessContinent    = guess[2];
		char   guessFirstLetter  = cg.getFirstLetter(guessCountry);
		char   guessLastLetter   = cg.getLastLetter(guessCountry);
		
		int[] colorPickerCountry = attributeChanger.getColor(
			cg.checkString(cg.getAnsCountry(), guessCountry));
		int[] colorPickerContinent = attributeChanger.getColor(
			cg.checkString(cg.getAnsContinent(), guessContinent));
		int[] colorPickerFirstLetter = attributeChanger.getColor(
			cg.checkChar(answerFirstLetter, guessFirstLetter));
		int[] colorPickerLastLetter  = attributeChanger.getColor(
			cg.checkChar(answerLastLetter, guessLastLetter));
		
		switch (gameScore.getMultiplier()) {
			case 4:
				attributeChanger.giveColor(this.countryLabel1, this.continentLabel1,
					this.guessImageLabel1, this.firstLetterLabel1, this.lastLetterLabel1,
					colorPickerCountry, colorPickerContinent, colorPickerFirstLetter, 
					colorPickerLastLetter);
				
				this.guessImageLabel1.setImage(guessImage1.finalImage(
					cg.getImageLocation(guessCountry)));
				
				attributeChanger.giveText(this.countryLabel1, this.continentLabel1,
					this.firstLetterLabel1, this.lastLetterLabel1,
					guessCountry, guessContinent, guessFirstLetter, guessLastLetter);
				
				break;
			case 3:
				attributeChanger.giveColor(this.countryLabel2, this.continentLabel2, 
					this.guessImageLabel2, this.firstLetterLabel2, this.lastLetterLabel2,
					colorPickerCountry, colorPickerContinent, colorPickerFirstLetter, 
					colorPickerLastLetter);
				
				this.guessImageLabel2.setImage(guessImage2.finalImage(
					cg.getImageLocation(guessCountry)));
				
				attributeChanger.giveText(this.countryLabel2, this.continentLabel2, 
					this.firstLetterLabel2, this.lastLetterLabel2,
					guessCountry, guessContinent, guessFirstLetter, guessLastLetter);
				
				break;
			case 2:
				attributeChanger.giveColor(this.countryLabel3, this.continentLabel3,
					this.guessImageLabel3, this.firstLetterLabel3, this.lastLetterLabel3,
					colorPickerCountry, colorPickerContinent, colorPickerFirstLetter, 
					colorPickerLastLetter);
				
				this.guessImageLabel3.setImage(guessImage3.finalImage(
					cg.getImageLocation(guessCountry)));
				
				attributeChanger.giveText(this.countryLabel3, this.continentLabel3, 
					this.firstLetterLabel3, this.lastLetterLabel3,
					guessCountry, guessContinent, guessFirstLetter, guessLastLetter);
				
				break;
			case 1:
				attributeChanger.giveColor(this.countryLabel4, this.continentLabel4,
					this.guessImageLabel4, this.firstLetterLabel4, this.lastLetterLabel4,
					colorPickerCountry, colorPickerContinent, colorPickerFirstLetter,
					colorPickerLastLetter);
				
				this.guessImageLabel4.setImage(guessImage4.finalImage(
					cg.getImageLocation(guessCountry)));
				
				attributeChanger.giveText(this.countryLabel4, this.continentLabel4, 
					this.firstLetterLabel4, this.lastLetterLabel4,
					guessCountry, guessContinent, guessFirstLetter, guessLastLetter);
				
				break;
			default: 
				break;
		}
		
	}
	
	private void resetScreen(int multiplier) throws Exception {
		
		int scoreSeconds = Integer.parseInt(this.timerLabel.getLabelText());
		
		this.gameScore.setGameScore(scoreSeconds, multiplier);
		this.gameScore.setMultiplier(4);
		this.playGame();
		
		switch (multiplier) {
			/* falls through */
			case 0: //CLEAR ALL
		    /* falls through */
			case 1:
				this.attributeChanger.clearGuess(this.countryLabel4, this.continentLabel4, 
					this.guessImageLabel4, this.firstLetterLabel4, this.lastLetterLabel4);
			/* falls through */
			case 2:
				this.attributeChanger.clearGuess(this.countryLabel3, this.continentLabel3, 
					this.guessImageLabel3, this.firstLetterLabel3, this.lastLetterLabel3);
			/* falls through */
			case 3:
				this.attributeChanger.clearGuess(this.countryLabel2, this.continentLabel2, 
					this.guessImageLabel2, this.firstLetterLabel2, this.lastLetterLabel2);
		    /* falls through */
			case 4:
				this.attributeChanger.clearGuess(this.countryLabel1, this.continentLabel1, 
					this.guessImageLabel1, this.firstLetterLabel1, this.lastLetterLabel1);
			default:
				break;
		}
		
	}
}
