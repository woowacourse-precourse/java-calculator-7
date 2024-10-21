package calculator.model;

import java.util.HashSet;
import java.util.Set;

import calculator.validation.InputValidator;

public class Delimiters {
	private final Set<String> delimiters;
	private final InputValidator inputValidator;

	public Delimiters() {
		this.delimiters = new HashSet<>(Set.of(",", ":"));
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
}
