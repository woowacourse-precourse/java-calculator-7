package calculator.controller;

import java.util.List;
import java.util.Optional;

import calculator.model.Calculator;
import calculator.model.CustomDelimiterProcessor;
import calculator.model.Delimiter;
import calculator.model.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;
	private final CustomDelimiterProcessor customDelimiterProcessor;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.customDelimiterProcessor = new CustomDelimiterProcessor();
	}

	public void run() {
		String input = inputView.readInput();
		inputView.closeRead();

		Delimiter delimiter = new Delimiter();
		Optional<String> customDelimiter = customDelimiterProcessor.extractCustomDelimiter(input);
		customDelimiter.ifPresent(delimiter::addCustomDelimiter);

		String processedInput = customDelimiterProcessor.removeCustomDelimiterPattern(input);
		List<Integer> numbers = InputParser.extractNumbers(processedInput, delimiter);

		Calculator calculator = new Calculator(numbers);
		outputView.printResult(calculator.sum());
	}
}
