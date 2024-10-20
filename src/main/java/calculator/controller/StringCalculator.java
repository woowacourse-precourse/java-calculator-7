package calculator.controller;

import java.util.List;

import calculator.model.CustomDelimiterValidator;
import calculator.model.NumberExtractor;
import calculator.model.StringValidator;
import calculator.model.SumCalculator;
import calculator.view.Input;
import calculator.view.Output;

public class StringCalculator {

	private final Input input;
	private final Output output;

	public StringCalculator (Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	public void run() {
		String inputString = getInput();
		inputString = validateInput(inputString);
		List<Integer> numbers = extractNumbers(inputString);
		int answer = getAnswer(numbers);
		printAnswer(answer);
	}

	private String getInput() {
		output.printInitialMessage();
		return input.getString();
	}

	private String validateInput(String inputString) {
		CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
		StringValidator stringValidator = new StringValidator();
		if (customDelimiterValidator.hasCustomDelimiter(inputString)) {
			stringValidator.addCustomDelimiter(customDelimiterValidator.getCustomDelimiter(inputString));
			inputString = customDelimiterValidator.removeCustomDelimiter(inputString);
		}
		stringValidator.validate(inputString);
		return inputString;
	}

	private List<Integer> extractNumbers(String inputString) {
		NumberExtractor numberExtractor = new NumberExtractor();
		return numberExtractor.extractNumbers(inputString);
	}

	private int getAnswer(List<Integer> numbers) {
		SumCalculator sumCalculator = new SumCalculator();
		return sumCalculator.calculate(numbers);
	}

	private void printAnswer(int answer) {
		output.printAnswerMessage(answer);
	}
}
