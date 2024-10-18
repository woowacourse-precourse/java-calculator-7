package calculator.controller;

import java.util.List;

import calculator.model.Calculator;
import calculator.model.InputParser;
import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final InputValidator inputValidator;
	private final OutputView outputView;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.inputValidator = new InputValidator();
	}

	public void run() {
		String input = inputView.readInput();
		inputValidator.validateInput(input);
		InputParser inputParser = new InputParser(input);
		List<Integer> numbers = inputParser.extractNumbers(input);

		Calculator calculator = new Calculator(numbers);
		outputView.printResult(calculator.sum());
	}
}
