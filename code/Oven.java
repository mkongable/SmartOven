package code;

public class Oven {
	private int temperature;  //target temperature in F
	private int realTemperature;
	private boolean lightstatus;
	
	public static void readMe() {
		System.out.println("Hi this is a program for ovens");
	}
	
	public Oven() {
		this.temperature = 75;
		this.lightstatus = false; //off
	}
	
	/**
	 * toggles the light
	 */
	public void toggleLight() {
		this.lightstatus = !this.lightstatus;
	}
	
	/*
	 * User puts in the temperature, and the temperature would try and reach the setting
	 */
	public void setTemperature(int newTemp) {
		if (this.lightstatus == true) {
			this.temperature = newTemp;
		}
	}
	
	@Override
	public String toString() {
		String lightStatusString;
		if (this.lightstatus == false) {
			lightStatusString = "OFF";
		} else {
			lightStatusString = "ON";
		}
		return Integer.toString(this.temperature) + " " + lightStatusString;
	}
}
