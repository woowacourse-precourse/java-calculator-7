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
		NumberExtractor numberExtractor = new NumberExtractor();
		List<Integer> numbers = numberExtractor.extractNumbers(inputString);
		SumCalculator sumCalculator = new SumCalculator();
		int answer = sumCalculator.calculate(numbers);
		output.printAnswerMessage(answer);
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
}
