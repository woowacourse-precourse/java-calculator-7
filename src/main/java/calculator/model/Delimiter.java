package calculator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import calculator.validation.InputValidator;

public class Delimiter {
	private final Set<String> delimiters = new HashSet<>();
	private final InputValidator inputValidator;

	public Delimiter() {
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
		Arrays.stream(DefaultDelimiter.values())
			.forEach(delimiter -> this.delimiters.add(delimiter.getDelimiter()));
	}

	public Set<String> getDelimiters() {
		return Collections.unmodifiableSet(delimiters);
	}
}
