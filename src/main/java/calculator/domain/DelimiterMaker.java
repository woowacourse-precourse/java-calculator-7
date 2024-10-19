package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import calculator.util.NumberChecker;

public class DelimiterMaker {

	private static final String DEFAULT_DELIMITER_COMMA = ",";
	private static final String DEFAULT_DELIMITER_COLON = ":";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final int STRING_START_INDEX = 0;
	private static final String BLANK_STRING = "";

	public List<String> getDelimitersFrom(String delimiterMixedNumbers) {

		List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));

		String delimiter = getDelimiterStringFrom(delimiterMixedNumbers);
		String[] splitDelimiter = delimiter.split(Pattern.quote(CUSTOM_DELIMITER_SUFFIX));

		validateAllDelimiter(splitDelimiter);

		Arrays.stream(splitDelimiter)
			.map(separator -> separator.replace(CUSTOM_DELIMITER_PREFIX, BLANK_STRING))
			.forEach(delimiters::add);

		return delimiters;
	}

	public String getDelimiterStringFrom(String delimiterMixedNumbers) {
		return delimiterMixedNumbers.substring(STRING_START_INDEX,
			delimiterMixedNumbers.lastIndexOf(CUSTOM_DELIMITER_SUFFIX));
	}

	private void validateAllDelimiter(String[] splitDelimiter) {
		Arrays.stream(splitDelimiter)
			.forEach(this::validateDelimiter);
	}

	private void validateDelimiter(String delimiter) {
		validateBlank(delimiter);
		validateCustomDelimiterFormat(delimiter);
		validateDelimiterIsCustomDelimiterPrefix(delimiter);
		validateDelimiterContainsNumber(delimiter);
		validateDelimiterIsEmpty(delimiter);
	}

	private void validateCustomDelimiterFormat(String delimiter) {
		if (!delimiter.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			throw new IllegalArgumentException("Invalid delimiter: " + delimiter);
		}
	}

	private void validateDelimiterIsCustomDelimiterPrefix(String delimiter) {

		String customDelimiter = delimiter.substring(CUSTOM_DELIMITER_PREFIX.length());

		if(customDelimiter.contains(CUSTOM_DELIMITER_SUFFIX)) {
			throw new IllegalArgumentException("Invalid delimiter: " + customDelimiter);
		}
	}

	private void validateDelimiterContainsNumber(String delimiter) {
		if(NumberChecker.containsNumber(delimiter)) {
			throw new IllegalArgumentException("Invalid delimiter: " + delimiter);
		}
	}

	private void validateBlank(String delimiter) {
		if(delimiter.isBlank()) {
			throw new IllegalArgumentException("Invalid delimiter: " + delimiter);
		}
	}

	private void validateDelimiterIsEmpty(String delimiter) {
		String customDelimiter = delimiter.substring(CUSTOM_DELIMITER_PREFIX.length());

		if(customDelimiter.isEmpty()) {
			throw new IllegalArgumentException("Invalid delimiter: " + customDelimiter);
		}
	}

	public boolean hasCustomSeparator(String input) {
		return input.contains(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
	}

}
