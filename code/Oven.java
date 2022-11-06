package code;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//SLDC STEP 1 : STAKEHOLDER REQUIREMENTS
/*
This oven represents a smart oven.
It needs a heating element with associated status
Needs a way to control the oven's heating cycle - can be controlled manually or automatically
manual - set it for longer than automatic will allow
automatic - set for 120 minutes
once the timer hits 0, then the heating element will turn off
need a command console to control the oven
commands supported:
"START" - starts the oven
"STOP" - manually stops the oven and clears the timer (defaults back to 120 min)
"SET TIME <time>" - sets the timer to the specified time, time is in minutes
	for example "SET TIME 200"
"QUIT"	- exits the program
*/

//SLDC STEP 2 : DESIGN
public class Oven {
	boolean heatingElementOn = false;
	String name;
	Timer timer = new Timer();
	static int remainingTime = 120;

	//constructor
	public Oven(String name) {
		this.name = name;
	}

	//starts the oven and the timer countdown
	public void start() {
		if (this.heatingElementOn) {
			System.out.println("Oven is already running");
			return;
		}
		this.heatingElementOn = true;
		System.out.println("Oven is on");
		int delay = 1000;
		int interval = 1000; //1000 ms
		System.out.println("Remaining time: " + remainingTime);
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(
			new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					remainingTime--;
					if (remainingTime == 0) {
						processTimerUp();
					} else {
						System.out.println("Remaining time: " + remainingTime);
					}
				}
			}, delay, interval
		);
	}

	//sets the timer to a manual value
	public void setTimer(int time) {
		if(!heatingElementOn) {
			remainingTime = time;
			System.out.println("Timer set to " + time + " minutes");
		} else {
			System.out.println("Timer already in Progress");
		}
	}

	//returns the remaining time on the timer
	public int getRemainingTime() {
		if(this.heatingElementOn) {
			return remainingTime;
		} else {
			return 0;
		}
	}

	//stops the oven and clears the timer
	public void stop() {
		this.heatingElementOn = false;
		this.timer.cancel();
		System.out.println("Oven manual shutoff");
		remainingTime = 120;
	}

	//when the timer reaches 0, we call this method to turn off the heating element and notify the user that the heating is done
	public void processTimerUp() {
		this.timer.cancel();
		heatingElementOn = false;
		System.out.println("Heating is done");
		remainingTime = 120;
	}
	
	//prints heating element status
	public void statusCheck() {
		System.out.println("Heating element status = " + this.heatingElementOn);
	}

	//toString
	public String toString() {
		return "Oven [heatingElementOn=" + heatingElementOn + ", name=" + name + ", remainingTime="
				+ remainingTime + "]";
	}
}
