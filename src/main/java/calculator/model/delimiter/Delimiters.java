package calculator.model.delimiter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import calculator.config.DefaultDelimiter;
import calculator.validation.InputValidator;

public class Delimiters {
	private final Set<String> delimiters = new HashSet<>();

	public Delimiters() {
		initDefaultDelimiters();
	}

	public void addDelimiter(String delimiterInput) {
		InputValidator.validateEmpty(delimiterInput);
		InputValidator.validateNonDigit(delimiterInput);
		delimiters.add(delimiterInput);
	}

	public boolean isRegisteredDelimiter(String delimiter) {
		return delimiters.contains(delimiter);
	}

	public String[] getRegex() {
		return delimiters.stream()
			.map(Pattern::quote)
			.toArray(String[]::new);
	}

	private void initDefaultDelimiters() {
		Arrays.stream(DefaultDelimiter.values())
			.forEach(delimiter -> this.delimiters.add(delimiter.getDelimiter()));
	}

	public Set<String> getDelimiters() {
		return Collections.unmodifiableSet(delimiters);
	}
}
