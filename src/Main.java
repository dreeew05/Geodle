/*
 * Class Name - Main.java
 * Brief Description - This is where you run the project
 * @author G. Bulaong
 */

import java.awt.EventQueue;

import ui.Home;

public class Main{

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Home();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
