package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
	public void run() {
		Calculator calculator = new Calculator();
		List<Integer> numbers = new ArrayList<>();
		ValidatingParser validatingParser = new ValidatingParser();
		InputHandler inputHandler = InputHandler.of(validatingParser);
		inputHandler.getValidatedUserInput();
	}
}
