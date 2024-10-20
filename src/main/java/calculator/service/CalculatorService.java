package calculator.service;

import calculator.parser.InputParser;
import calculator.validation.InputValidator;

public class CalculatorService {
	private final InputValidator inputValidator;
	private final InputParser inputParser;

	public CalculatorService() {
		this.inputValidator = new InputValidator();
		this.inputParser = new InputParser(inputValidator);
	}

	public int add(String text) {
		String[] numbers = inputParser.parse(text);
		return calculateSum(numbers);
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			if (!number.trim().isEmpty()) {
				sum += inputValidator.validatePositiveNumber(number.trim());
			}
		}
		return sum;
	}
}
