package calculator;

import java.util.List;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.Calculator;

public class CalculatorController {
	private final Calculator calculator;
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;

	private CalculatorController(Calculator calculator, InputHandler inputHandler, OutputHandler outputHandler) {
		this.calculator = calculator;
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
	}

	public static CalculatorController of(Calculator calculator, InputHandler inputHandler,
		OutputHandler outputHandler) {
		return new CalculatorController(calculator, inputHandler, outputHandler);
	}

	public void run() {
		outputHandler.showPromptMessage();
		List<Integer> numbers = inputHandler.getValidatedNumbersFromUserInput();
		int sum = calculator.sumNumbers(numbers);
		outputHandler.showCalculateResult(sum);
	}
}
