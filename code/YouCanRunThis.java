package code;
import java.util.Scanner;

public class YouCanRunThis {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Oven myOven = new Oven("My Oven");
		System.out.println("Welcome, the oven is ready for your command:\n");
		while (true) {
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
				System.out.println("Bye");
				System.exit(0);
			} else if (com_parts[0].equals("SET") && com_parts[1].equals("TIME") && com_parts.length == 3) {
				//set the timer
				int time;
				try {
					time = Integer.parseInt(com_parts[2]);
					myOven.setTimer(time);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input for time");
				}
			} else {
				//throw an exception
				System.out.println("invalid command");
			}
		}
	}
}
