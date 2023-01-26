/*
 * Class Name - LeaderboardsWrite.java
 * Brief Description - A class that creates/writes
 *                     the record of the game
 * @author G. Bulaong
 */

package leaderboards;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import ui.Leaderboards;

public class LeaderboardsWrite extends LeaderboardsBase{
	

	private File      file;
	private LocalDate date;
	
	public LeaderboardsWrite(String classification,
							 String name,
							 int score) throws IOException {
		
		super(classification, name, score);
		
		file = new File(super.getFileLocation());
		this.writeFile();
		
		new Leaderboards(super.getClassification(),
				         super.getName(),
						 super.getScore());
	}
	
	private void createFile() {
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private LocalDate getDate() {
		date = LocalDate.now();
		return date;
	}
	
	private void writeFile() {
		boolean fileExists = this.file.exists();
		
		if(!fileExists) {
			createFile();
			writeFile();
			return;
		}
		
		String output = this.getName().concat(",")
			.concat(String.valueOf(this.getScore())).concat(",")
			.concat(String.valueOf(this.getDate())).concat("\n");
		try {
			Files.write(Paths.get(this.getFileLocation()), output.getBytes(), 
				StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
