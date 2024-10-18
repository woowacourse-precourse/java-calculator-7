package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

import calculator.constant.CommonPattern;
import calculator.constant.ErrorMessage;

public class Delimiter {
	private static final int STRICT_LENGTH = 1;
	private static final String EMPTY = "";
	private static final Pattern SINGLE_NUMERIC_PATTERN = Pattern.compile(CommonPattern.SINGLE_NUMBER);

	private final String delimiter;

	private Delimiter(String delimiter) {
		validateLength(delimiter);
		validateNotNumber(delimiter);

		this.delimiter = delimiter;
	}

	public static Delimiter from(String delimiter) {
		return new Delimiter(delimiter.trim());
	}

	private void validateLength(String delimiter) {
		if (delimiter.isBlank() || delimiter.length() > STRICT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH.getMessage());
		}
	}

	private void validateNotNumber(String delimiter) {
		if (SINGLE_NUMERIC_PATTERN.matcher(delimiter).matches()) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_NOT_NUMBER.getMessage());
		}
	}

	public static String toRegex(List<Delimiter> delimiters) {
		return String.format(
			CommonPattern.SELECT_ONE,
			String.join(EMPTY, delimiters.stream().map(delimiter -> delimiter.delimiter).toList())
		);
	}
}