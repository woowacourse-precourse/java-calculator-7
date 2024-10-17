package calculator.model;

import calculator.constant.ErrorMessage;

public class Delimiter {
	private static final int STRICT_LENGTH = 1;

	private final String delimiter;

	private Delimiter(String delimiter) {
		validateLength(delimiter);
		this.delimiter = delimiter;
	}

	public static Delimiter from(String delimiter) {
		return new Delimiter(delimiter);
	}

	private void validateLength(String delimiter) {
		if (delimiter.isBlank() || delimiter.length() > STRICT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH.getMessage());
		}
	}
}