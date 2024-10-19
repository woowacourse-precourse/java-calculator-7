package calculator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import calculator.interfaces.IOHandler;

public class ConsoleUtil implements IOHandler {
	private static final Logger logger = LoggerFactory.getLogger(ConsoleUtil.class);

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public String readInput() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			return reader.readLine();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "입력을 읽는 중 오류 발생", e);
			return null;
		}
	}
}