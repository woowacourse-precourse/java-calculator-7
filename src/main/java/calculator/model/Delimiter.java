package calculator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import calculator.validation.InputValidator;

public class Delimiter {
	private final Set<String> delimiters = new HashSet<>();

	public Delimiter() {
		initDefaultDelimiters();
	}

	public void addCustomDelimiter(String delimiterInput) {
		InputValidator.validateEmpty(delimiterInput);
		InputValidator.validateNonDigit(delimiterInput);
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
