/*
 * Class Name - CountDownTimer.java
 * Brief Description - This class contains the timer
 *                     for the game
 * @author G. Bulaong
 */

package core;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class CountDownTimer {
	
	private int defaultTime = 60;
	
	private int remainingSeconds;
	
	Timer     t  = new Timer();
	TimerTask tt;
	
	public CountDownTimer() {
		this.showTime(this.getDefaultTime());
	} 
	
	private int getDefaultTime() {
		return this.defaultTime;
	}
	
	private void decrementSeconds(){
		if(this.getRemainingSeconds() > 0) {
			--this.remainingSeconds;
		}
		else {
			this.timerRunsOut();
		}
	}
	
	public void timerRunsOut() {
		this.stopTimer();
		this.showTime(this.getDefaultTime());
	}
	
	public void showTime(int remainingSeconds) {
		this.remainingSeconds = remainingSeconds;
	}
	
	public int getRemainingSeconds() {
		return this.remainingSeconds;
	}
	
	public void startTimer(final JLabel label) {
		tt = new TimerTask() {

			@Override
			public void run() {
				label.setText(String.valueOf(getRemainingSeconds()));
				decrementSeconds();
			}
			
		};
		// ==> TimerTask, Delay, Speed
		this.t.scheduleAtFixedRate(tt, 0, 1000);
	}
	
	public void stopTimer() {
		this.tt.cancel();
		this.showTime(this.getDefaultTime());
	}
	
	
}
