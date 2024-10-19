package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import calculator.constant.ErrorMessage;
import calculator.util.NumberChecker;

public class DelimiterMaker {

	private static final String DEFAULT_DELIMITER_COMMA = ",";
	private static final String DEFAULT_DELIMITER_COLON = ":";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

	public List<String> getDefaultDelimiters() {
		return new ArrayList<>(List.of(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));
	}

	public List<String> getDelimitersFrom(String delimiterSection) {

		String[] splitDelimiter = delimiterSection.split(Pattern.quote(CUSTOM_DELIMITER_SUFFIX));
		validateAllDelimiter(splitDelimiter);

		List<String> delimiters = getDefaultDelimiters();
		Arrays.stream(splitDelimiter)
			.map(separator -> separator.substring(CUSTOM_DELIMITER_PREFIX.length()))
			.forEach(delimiters::add);

		return delimiters;
	}

	private void validateAllDelimiter(String[] splitDelimiter) {
		Arrays.stream(splitDelimiter)
			.forEach(this::validateDelimiter);
	}

	private void validateDelimiter(String delimiter) {
		validateCustomDelimiterFormat(delimiter);
		validateDelimiterIsCustomDelimiterPrefix(delimiter);
		validateDelimiterContainsNumber(delimiter);
		validateDelimiterIsEmpty(delimiter);
	}

	private void validateCustomDelimiterFormat(String delimiter) {
		if (!delimiter.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
		}
	}

	private void validateDelimiterIsCustomDelimiterPrefix(String delimiter) {

		String customDelimiter = delimiter.substring(CUSTOM_DELIMITER_PREFIX.length());

		if (customDelimiter.contains(CUSTOM_DELIMITER_PREFIX)) {
			throw new IllegalArgumentException(
				ErrorMessage.USE_CUSTOM_DELIMITER_PREFIX_AT_CUSTOM_DELIMITER.getMessage()
			);
		}
	}

	private void validateDelimiterContainsNumber(String delimiter) {
		if (NumberChecker.containsNumber(delimiter)) {
			throw new IllegalArgumentException(ErrorMessage.USE_NUMBER_AT_CUSTOM_DELIMITER.getMessage());
		}
	}

	private void validateDelimiterIsEmpty(String delimiter) {
		String customDelimiter = delimiter.substring(CUSTOM_DELIMITER_PREFIX.length());

		if (customDelimiter.isEmpty()) {
			throw new IllegalArgumentException(
				ErrorMessage.USE_BLANK_OR_CUSTOM_DELIMITER_SUFFIX_AT_CUSTOM_DELIMITER.getMessage()
			);
		}
	}

	public boolean hasCustomSeparator(String input) {
		return input.contains(CUSTOM_DELIMITER_PREFIX) || input.contains(CUSTOM_DELIMITER_SUFFIX);
	}

}
