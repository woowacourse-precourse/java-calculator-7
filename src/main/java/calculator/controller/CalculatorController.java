package calculator.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import calculator.model.Calculator;
import calculator.model.delimiter.CustomDelimiterProcessor;
import calculator.model.delimiter.Delimiters;
import calculator.model.InputFilter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;
	private final Delimiters delimiters;
	private final CustomDelimiterProcessor customDelimiterProcessor;
	private final InputFilter inputFilter;
	private final Calculator calculator;

	public CalculatorController(
		InputView inputView,
		OutputView outputView,
		Delimiters delimiters,
		CustomDelimiterProcessor customDelimiterProcessor,
		InputFilter inputFilter,
		Calculator calculator
	) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.delimiters = delimiters;
		this.customDelimiterProcessor = customDelimiterProcessor;
		this.inputFilter = inputFilter;
		this.calculator = calculator;
	}

	public void run() {
		String input = readInput();

		String processedInput = processCustomDelimiter(input);
		Set<Integer> numbers = extractNumbers(processedInput);
		int result = sum(numbers);

		printResult(result);
	}

	private String readInput() {
		outputView.printReadCommand();
		String input = inputView.readInput();
		inputView.closeRead();

		return input;
	}

	private String processCustomDelimiter(String input) {
		Optional<String> customDelimiter = customDelimiterProcessor.extractCustomDelimiter(input);
		customDelimiter.ifPresent(delimiters::addDelimiter);

		return customDelimiterProcessor.removeCustomDelimiterPattern(input);
	}

	private Set<Integer> extractNumbers(String processedInput) {
		return inputFilter.extractNumbers(processedInput, delimiters);
	}

	private int sum(Set<Integer> numbers) {
		return calculator.sum(numbers);
	}

	private void printResult(int result) {
		outputView.printResult(result);
	}
}
