package calculator.controller;

import java.util.List;

import calculator.model.CustomDelimiterValidator;
import calculator.model.NumberExtractor;
import calculator.model.StringValidator;
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
		output.printInitialMessage();
		String inputString = input.getString();
		CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
		StringValidator stringValidator = new StringValidator();
		if (customDelimiterValidator.hasCustomDelimiter(inputString)) {
			stringValidator.addCustomDelimiter(customDelimiterValidator.getCustomDelimiter(inputString));
		}
	}
}
