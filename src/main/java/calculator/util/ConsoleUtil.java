package calculator.util;

import calculator.interfaces.IOHandler;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil implements IOHandler {

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public String readLine() {
		return Console.readLine();
	}
}