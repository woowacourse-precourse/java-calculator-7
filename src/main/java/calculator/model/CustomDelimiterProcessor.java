package calculator.model;

import static calculator.model.CustomDelimiterPattern.*;

import java.util.Optional;

import calculator.validation.InputValidator;

public class CustomDelimiterProcessor {
	public Optional<String> extractCustomDelimiter(String input) {
		if (!hasCustomDelimiterPattern(input)) {
			return Optional.empty();
		}
		int startIndex = findStartIndex(input);
		int endIndex = findEndIndex(input);

		return Optional.of(extractCustomDelimiter(input, startIndex, endIndex));
	}

	private boolean hasCustomDelimiterPattern(String input) {
		return input.contains(START.getPattern()) && input.contains(END.getPattern());
	}

	private int findStartIndex(String input) {
		int startIndex = input.indexOf(START.getPattern());
		InputValidator.validateStartPattern(startIndex);

		return startIndex + START.getPatternLength();
	}

	private int findEndIndex(String input) {
		int endIndex = input.indexOf(END.getPattern());
		InputValidator.validateEndPattern(endIndex);

		return endIndex;
	}

	private String extractCustomDelimiter(String input, int start, int end) {
		InputValidator.validatePatternPosition(start, end);

		return input.substring(start, end);
	}
}
