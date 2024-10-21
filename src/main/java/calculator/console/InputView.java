package calculator.console;

import calculator.console.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String readConsole() {
		try {
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
