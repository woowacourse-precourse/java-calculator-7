package calculator.model;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import calculator.constant.ErrorMessage;

public class Delimiter {
	private static final int STRICT_LENGTH = 1;
	private static final String EMPTY = "";
	private static final String SELECT_ONE_FORMAT = "[%s]";
	private static final Pattern SINGLE_NUMERIC_PATTERN = Pattern.compile("^[0-9]$");

	private final String character;

	private Delimiter(String character) {
		validateLength(character);
		validateNotNumber(character);

		this.character = character;
	}

	public static Delimiter from(String character) {
		return new Delimiter(character.trim());
	}

	private void validateLength(String character) {
		if (character.isBlank() || character.length() > STRICT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH_OVER.getMessage());
		}
	}

	private void validateNotNumber(String character) {
		if (SINGLE_NUMERIC_PATTERN.matcher(character).matches()) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_NOT_NUMBER.getMessage());
		}
	}

	public static String toRegex(List<Delimiter> delimiters) {
		return String.format(
			SELECT_ONE_FORMAT,
			String.join(EMPTY, delimiters.stream().map(delimiter -> delimiter.character).toList())
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Delimiter that = (Delimiter)o;
		return Objects.equals(this.character, that.character);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(character);
	}
}