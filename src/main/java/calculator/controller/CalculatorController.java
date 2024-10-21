package calculator.controller;

import java.util.List;
import java.util.Optional;

import calculator.model.Calculator;
import calculator.model.Delimiter;
import calculator.model.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		String input = inputView.readInput();
		inputView.closeRead();

		Delimiter delimiter = new Delimiter();

		Optional<String> customDelimiter = InputParser.extractCustomDelimiter(input);
		customDelimiter.ifPresent(delimiter::addCustomDelimiter);
		List<Integer> numbers = InputParser.extractNumbers(input, delimiter);

		Calculator calculator = new Calculator(numbers);
		outputView.printResult(calculator.sum());
	}
}
