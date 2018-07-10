package examples;

import com.harium.malt.serial.Serial;
import com.harium.malt.serial.SerialIO;
import com.harium.malt.serial.SerialListener;

import java.io.IOException;
import java.util.Scanner;

public class SerialMonitor {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) throws IOException {
		SerialIO serial = new Serial(9600);
		serial.initAsync(new Monitor());

		Scanner scanner = new Scanner(System.in);
		String input = "";

		while (!EXIT_COMMAND.equals(input)) {
			input = scanner.nextLine();
			serial.send(input);
		}
	}

	public static class Monitor implements SerialListener {
		public void receive(String message) {
			System.out.println(message);
		}

		public void error(Exception e) {

		}
	}

}