/*
 * Class Name - Home.java
 * Brief Description - Home page of the game
 * @author G. Bulaong
 */

package ui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import filemanager.RetrieveImage;
import imagemanager.ResizeStaticImage;
import uimanager.SetImageButton;
import uimanager.SetJFrame;
import uimanager.SetGroupVisibility;
import uimanager.SetStaticImageLabel;

public class Home implements ActionListener{

//	private JFrame frame;
	
	public Home() throws IOException {
		initialize();
	}
	
	private SetImageButton standardModeButton,
						   mixedModeButton,
						   exitButton,
						   flagButton,
						   mapButton,
						   peopleButton,
						   capitalButton;
	
	private SetGroupVisibility setGroupVisibility;
	
	private SetStaticImageLabel logoLabel,
		                        selectCategoryLabel;
	
	private SetJFrame createJFrame;
	
	private ArrayList<SetImageButton> buttonVisibility = new ArrayList<SetImageButton>();
	
	private void initialize() throws IOException {

		final int WINDOW_HEIGHT          = 650, 
		          WINDOW_WIDTH           = 780,
		          MODE_BUTTON_HEIGHT     = 70,
		          MODE_BUTTON_WIDTH      = 165,
		          CATEGORY_BUTTON_HEIGHT = 110,
		          CATEGORY_BUTTON_WIDTH  = 275,
		          LOGO_HEIGHT            = 400,
		          LOGO_WIDTH             = 400,
		          CATEGORY_TEXT_HEIGHT   = 120,
		          CATEGORY_TEXT_WIDTH    = 235,
		             
		          MODE_BUTTON_POS_X      = 233,
		          CATEGORY_BUTTON_POS_X  = 184,
		          LOGO_POS_X             = 120,
		          SEL_CATEGORY_POS_X     = 210,
		          SEL_CATEGORY_POS_Y     = 29,
		          STD_MOD_BUTTON_POS_Y   = 396,
		          MIX_MOD_BUTTON_POS_Y   = 482,
		          EXT_MOD_BUTTON_POS_Y   = 570,
		          FLAG_BUTTON_POS_Y      = 170,
		          MAP_BUTTON_POS_Y       = 289,
		          PEOPLE_BUTTON_POS_Y    = 408,
		          CAPITAL_BUTTON_POS_Y   = 527,
		          LOGO_POS_Y             = 29;
		
		final String BUTTONS       = "\\buttons\\",
		             OTHER_IMAGES  = "\\others\\";
		
		RetrieveImage rtImg = new RetrieveImage();
		
		ResizeStaticImage stdModeBtnImage = new ResizeStaticImage(MODE_BUTTON_HEIGHT, 
			MODE_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "standard mode") );
		ResizeStaticImage mixedModeBtnImage = new ResizeStaticImage(MODE_BUTTON_HEIGHT, 
			MODE_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "mixed mode"));
		ResizeStaticImage exitButtonImage = new ResizeStaticImage(MODE_BUTTON_HEIGHT, 
			MODE_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "exit"));
		ResizeStaticImage flagBtnImage = new ResizeStaticImage(CATEGORY_BUTTON_HEIGHT, 
			CATEGORY_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "flags"));
		ResizeStaticImage mapBtnImage = new ResizeStaticImage(CATEGORY_BUTTON_HEIGHT, 
			CATEGORY_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "maps"));
		ResizeStaticImage peopleBtnImage = new ResizeStaticImage(CATEGORY_BUTTON_HEIGHT, 
			CATEGORY_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "people"));
		ResizeStaticImage capitalBtnImage = new ResizeStaticImage(CATEGORY_BUTTON_HEIGHT, 
			CATEGORY_BUTTON_WIDTH, rtImg.getBaseLocation(BUTTONS, "capitals"));
		ResizeStaticImage logoImage  = new ResizeStaticImage(LOGO_HEIGHT, LOGO_WIDTH, 
			rtImg.getBaseLocation(OTHER_IMAGES, "logo"));
		ResizeStaticImage selectCategoryTextImage = new ResizeStaticImage(
			CATEGORY_TEXT_HEIGHT, CATEGORY_TEXT_WIDTH, rtImg.getBaseLocation(
			OTHER_IMAGES, "select category"));
		
		//BOUNDS => pos_x, pos_y, width, height
		Rectangle standardModeButtonBounds = new Rectangle(MODE_BUTTON_POS_X,
			STD_MOD_BUTTON_POS_Y, MODE_BUTTON_WIDTH, MODE_BUTTON_HEIGHT);
		Rectangle mixedModeButtonBounds = new Rectangle(MODE_BUTTON_POS_X,
			MIX_MOD_BUTTON_POS_Y, MODE_BUTTON_WIDTH, MODE_BUTTON_HEIGHT);
		Rectangle exitButtonBounds = new Rectangle(MODE_BUTTON_POS_X,
			EXT_MOD_BUTTON_POS_Y, MODE_BUTTON_WIDTH, MODE_BUTTON_HEIGHT);
		Rectangle flagButtonBounds = new Rectangle(CATEGORY_BUTTON_POS_X,
			FLAG_BUTTON_POS_Y, CATEGORY_BUTTON_WIDTH, CATEGORY_BUTTON_HEIGHT);
		Rectangle mapButtonBounds = new Rectangle(CATEGORY_BUTTON_POS_X,
			MAP_BUTTON_POS_Y, CATEGORY_BUTTON_WIDTH, CATEGORY_BUTTON_HEIGHT);
		Rectangle peopleButtonBounds = new Rectangle(CATEGORY_BUTTON_POS_X,
			PEOPLE_BUTTON_POS_Y, CATEGORY_BUTTON_WIDTH, CATEGORY_BUTTON_HEIGHT);
		Rectangle capitalButtonBounds = new Rectangle(CATEGORY_BUTTON_POS_X,
			CAPITAL_BUTTON_POS_Y, CATEGORY_BUTTON_WIDTH, CATEGORY_BUTTON_HEIGHT);
		Rectangle logoImageBounds = new Rectangle(LOGO_POS_X, LOGO_POS_Y,
			LOGO_WIDTH, LOGO_HEIGHT);
		Rectangle selectCategoryImageBounds = new Rectangle(SEL_CATEGORY_POS_X,
			 SEL_CATEGORY_POS_Y, CATEGORY_TEXT_WIDTH, CATEGORY_TEXT_HEIGHT);

		this.createJFrame = new SetJFrame(WINDOW_HEIGHT, WINDOW_WIDTH);
		
		this.standardModeButton = new SetImageButton(standardModeButtonBounds,
			this.createJFrame.getJFrame(), "standardMode", stdModeBtnImage);
		this.mixedModeButton = new SetImageButton(mixedModeButtonBounds, 
			this.createJFrame.getJFrame(), "mixedMode", mixedModeBtnImage);
		this.exitButton = new SetImageButton(exitButtonBounds, 
			this.createJFrame.getJFrame(), "exit", exitButtonImage);
		this.flagButton = new SetImageButton(flagButtonBounds, 
			this.createJFrame.getJFrame(), "flags", flagBtnImage);
		this.mapButton = new SetImageButton(mapButtonBounds, 
			this.createJFrame.getJFrame(), "maps", mapBtnImage);
		this.peopleButton = new SetImageButton(peopleButtonBounds, 
			this.createJFrame.getJFrame(), "people", peopleBtnImage);
		this.capitalButton = new SetImageButton(capitalButtonBounds, 
			this.createJFrame.getJFrame(), "capitals", capitalBtnImage);
		
		this.standardModeButton.button().addActionListener(this);
		this.mixedModeButton.button().addActionListener(this);
		this.exitButton.button().addActionListener(this);
		this.flagButton.button().addActionListener(this);
		this.mapButton.button().addActionListener(this);
		this.peopleButton.button().addActionListener(this);
		this.capitalButton.button().addActionListener(this);
		
		//SET VISIBILITY OFF
		this.buttonVisibility.addAll(Arrays.asList(flagButton, 
			mapButton, peopleButton, capitalButton));
		
		this.setGroupVisibility = new SetGroupVisibility(buttonVisibility);
		this.setGroupVisibility.setGroupVisibleOff();
		
		this.logoLabel = new SetStaticImageLabel(logoImageBounds, 
			this.createJFrame.getJFrame(), logoImage);
		this.selectCategoryLabel = new SetStaticImageLabel(selectCategoryImageBounds, 
			this.createJFrame.getJFrame(), selectCategoryTextImage);
		
		//Category Label Hidden First
		this.selectCategoryLabel.setVisibleOff();
		
	}
    @Override
	public void actionPerformed(ActionEvent e) {
		
		String buttonName = ((JButton)e.getSource()).getName(),
			   mode       = null,
		       category   = null;
		
		if(buttonName == "standardMode"){
			
			//CATEGORY BUTTONS
			this.setGroupVisibility.setGroupVisibleOn();
			this.selectCategoryLabel.setVisibleOn();
			
			//Clear ArrayList to Store the outgoing buttons
			this.buttonVisibility.clear();
			
			//MODES, EXIT BUTTONS
			this.buttonVisibility.addAll(Arrays.asList(standardModeButton,
				mixedModeButton, exitButton));
			this.setGroupVisibility.setGroupVisibleOff();
			this.logoLabel.setVisibleOff();
			
			return;

		}
		
		if(buttonName == "exit") {
			System.exit(0);
		}
		
		if(buttonName == "mixedMode") {
			mode = "Mixed Mode";
		}
		else if(buttonName == "flags"  || buttonName == "maps" || 
				buttonName == "people" || buttonName == "capitals") {
			
			mode     = "Single Mode";
			category = buttonName;
			
		}
		
		try {
			this.createJFrame.getJFrame().dispose();
			new MainGame(mode, category);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
