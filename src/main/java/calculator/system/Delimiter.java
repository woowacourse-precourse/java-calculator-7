package calculator.system;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Delimiter {
	COMMA(","),
	COLON(":");

	private final String value;

	Delimiter(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Set<String> getDefaults() {
		return Arrays.stream(Delimiter.values())
				.map(Delimiter::getValue)
				.collect(Collectors.toSet());
	}
}