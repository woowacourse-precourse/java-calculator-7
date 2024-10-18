package calculator.constant;

import java.util.Arrays;
import java.util.List;

import calculator.model.Delimiter;

public enum DefaultDelimiter {
	REST(","),
	COLON(":");

	private final String character;

	DefaultDelimiter(String character) {
		this.character = character;
	}

	public static List<Delimiter> getDefaultDelimiter() {
		return Arrays.stream(DefaultDelimiter.values())
			.map(delimiter -> Delimiter.from(delimiter.character))
			.toList();
	}
}
