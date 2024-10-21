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
		StringValidator stringValidator = validateInput(inputString);
		List<Integer> numbers = extractNumbers(stringValidator.getInput());
		int answer = getAnswer(numbers);
		printAnswer(answer);
	}

	private String getInput() {
		output.printInitialMessage();
		return input.getString();
	}

	private StringValidator validateInput(String inputString) {
		CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
		StringValidator stringValidator = customDelimiterValidator.validCustomDelimiter(inputString);
		stringValidator.validate();
		return stringValidator;
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
