package code;
import java.util.Scanner;

public class YouCanRunThis {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Oven myOven = new Oven("My Oven");
		while (true):
			//process commands
			String command = kb.nextLine();
			String[] com_parts = command.split(" ");
			if (com_parts[0].equals("START")) {
				//start the oven
				myOven.start();
			} else if (com_parts[0].equals("STOP")) {
				//stop the oven
				myOven.stop();
			} else if (com_parts[0].equals("QUIT")) {
				break;
			} else if (com_parts[0].equals("SET") && com_parts[1].equals("TIME") && com_parts.length == 3) {
				//set the timer
				int time = Integer.parseInt(com_parts[2]);
				myOven.setTimer(time);
			} else {
				//throw an exception
				throw new Exception("Invalid command");
			}
	}
}
