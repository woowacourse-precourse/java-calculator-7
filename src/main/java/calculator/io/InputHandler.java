package calculator.io;

import java.util.List;

import calculator.service.ValidatingParser;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
	private final ValidatingParser validatingParser;

	private InputHandler(ValidatingParser validatingParser) {
		this.validatingParser = validatingParser;
	}

	public static InputHandler from(ValidatingParser validatingParser) {
		return new InputHandler(validatingParser);
	}

	public List<Integer> getValidatedNumbersFromUserInput() {
		String userInput = Console.readLine();
		return validatingParser.validatedNumbersFrom(userInput);
	}
}
