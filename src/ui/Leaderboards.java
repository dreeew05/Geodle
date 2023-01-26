/*
 * Class Name - Leaderboards.java
 * Brief Description - Show the leaderboards
 * @author G. Bulaong
 */

package ui;

import java.awt.Font;

import javax.swing.JButton;

import datahandler.ReadScores;
import filemanager.RetrieveImage;
import imagemanager.ResizeStaticImage;
import leaderboards.LeaderboardsBase;
import uimanager.SetJFrame;
import uimanager.SetTable;
import uimanager.CustomizableLabel;
import uimanager.SetImageButton;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Leaderboards extends LeaderboardsBase implements ActionListener{

	private SetJFrame         createJFrame;
	
	private CustomizableLabel greetingLabel,
						      scoreLabel,
						      textLabel;
	
	private ReadScores        leaderboards;
	
	private SetImageButton    homeButton;
	
	private RetrieveImage     rtImg;
	private ResizeStaticImage homeButtonImage;
	
	public Leaderboards(String classification,
						String name,
			            int score) throws IOException {
		
		super(classification, name, score);
		
		this.initialize();
		this.showText();
	}

	private void initialize() throws IOException {
		
		final int    WINDOW_HEIGHT   = 650,
				     WINDOW_WIDTH    = 780,
				     BUTTON_HEIGHT   = 38,
				     BUTTON_WIDTH    = 89,
				     TEXT_POS_X      = 10,
				     TABLE_POS_X     = 32,
				     BUTTON_POS_X    = 272,
				     GREET_POS_Y     = 41,
				     SCORE_POS_Y     = 66,
				     TXT_LBL_POS_Y   = 194,
				     TABLE_POS_Y     = 240,
				     BUTTON_POS_Y    = 661,
				     
				     TEXT_WIDTH      = 614,
				     TABLE_WIDTH     = 570,
				     GREET_HEIGHT    = 20,
				     SCORE_HEIGHT    = 103,
				     TXT_LBL_HEIGHT  = 25,
				     TABLE_HEIGHT    = 414;
				     
		final String BUTTON_FOLDER = "\\buttons\\";

		//BOUNDS => pos_x, pos_y, width, height
		Rectangle greetingLabelBounds = new Rectangle(TEXT_POS_X,
			GREET_POS_Y, TEXT_WIDTH, GREET_HEIGHT);
		Rectangle scoreLabelBounds = new Rectangle(TEXT_POS_X,
			SCORE_POS_Y, TEXT_WIDTH, SCORE_HEIGHT);
		Rectangle textLabelBounds = new Rectangle(TEXT_POS_X,
			TXT_LBL_POS_Y, TEXT_WIDTH, TXT_LBL_HEIGHT);
		Rectangle tableBounds = new Rectangle(TABLE_POS_X, 
			TABLE_POS_Y, TABLE_WIDTH, TABLE_HEIGHT);
		Rectangle buttonBounds = new Rectangle(BUTTON_POS_X, 
			BUTTON_POS_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		
		this.createJFrame = new SetJFrame(WINDOW_HEIGHT, WINDOW_WIDTH);
		
		this.greetingLabel = new CustomizableLabel(greetingLabelBounds, 
			this.createJFrame.getJFrame(), Font.PLAIN, 15);
		this.scoreLabel = new CustomizableLabel(scoreLabelBounds, 
			this.createJFrame.getJFrame(), Font.BOLD, 99);
		this.textLabel = new CustomizableLabel(textLabelBounds, 
			this.createJFrame.getJFrame(), Font.BOLD, 18);
		this.leaderboards = new ReadScores(this.getFileLocation());
		this.rtImg = new RetrieveImage();
		this.homeButtonImage = new ResizeStaticImage(BUTTON_HEIGHT, BUTTON_WIDTH,
			this.rtImg.getBaseLocation(BUTTON_FOLDER, "home"));
		this.homeButton = new SetImageButton(buttonBounds, 
			this.createJFrame.getJFrame(), "homeButton", this.homeButtonImage);
		
		try {
			new SetTable(tableBounds, this.createJFrame.getJFrame(), 
				this.leaderboards.returnTopTen());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.homeButton.button().addActionListener(this);
		
	}
	
	private void showText() {
		this.greetingLabel.labelSetText("Nice Try, ".concat(this.getName())
			.concat("! Your score is:"));
		this.scoreLabel.labelSetText(String.valueOf(this.getScore()));
		this.textLabel.labelSetText("Top 10 Scorers for "
			.concat(this.getClassification().toUpperCase()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = ((JButton)e.getSource()).getName();
		
		if(buttonName == "homeButton") {
			this.createJFrame.getJFrame().dispose();
			try {
				new Home();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
