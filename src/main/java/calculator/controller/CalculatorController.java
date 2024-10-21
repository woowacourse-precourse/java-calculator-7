package calculator.controller;

import java.util.List;
import java.util.Optional;

import calculator.model.Calculator;
import calculator.model.delimiter.CustomDelimiterProcessor;
import calculator.model.delimiter.Delimiters;
import calculator.model.InputFilter;
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
		String input = readInput();

		Delimiters delimiters = new Delimiters();
		addCustomDelimiter(input, delimiters);

		List<Integer> numbers = extractNumbers(input, delimiters);

		int result = calculate(numbers);
		printResult(result);
	}

	private String readInput() {
		outputView.printReadCommand();
		String input = inputView.readInput();
		inputView.closeRead();

		return input;
	}

	private void addCustomDelimiter(String input, Delimiters delimiters) {
		Optional<String> customDelimiter = customDelimiterProcessor.extractCustomDelimiter(input);
		customDelimiter.ifPresent(delimiters::addCustomDelimiter);
	}

	private List<Integer> extractNumbers(String input, Delimiters delimiters) {
		String processedInput = customDelimiterProcessor.removeCustomDelimiterPattern(input);

		return InputFilter.extractNumbers(processedInput, delimiters);
	}

	private int calculate(List<Integer> numbers) {
		Calculator calculator = new Calculator();

		return calculator.sum(numbers);
	}

	private void printResult(int result) {
		outputView.printResult(result);
	}

}
