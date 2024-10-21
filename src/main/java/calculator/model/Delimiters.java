package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import calculator.validation.InputValidator;

public class Delimiters {
	private final Set<String> delimiters = new HashSet<>();
	private final InputValidator inputValidator;

	public Delimiters() {
		initDefaultDelimiters();
		this.inputValidator = new InputValidator();
	}

	public void addCustomDelimiter(String delimiterInput) {
		inputValidator.validateEmpty(delimiterInput);
		inputValidator.validateNonDigit(delimiterInput);
		delimiters.add(delimiterInput);
	}

	public boolean isRegisteredDelimiter(String delimiter) {
		return delimiters.contains(delimiter);
	}

	private void initDefaultDelimiters() {
		Arrays.stream(DefaultDelimiters.values())
			.forEach(delimiter -> this.delimiters.add(delimiter.getDelimiter()));
	}
}
