package calculator.model;

import java.util.Objects;

public class Delimiter {

	private final String separator;

	public Delimiter(String delimiter) {
		this.separator = delimiter;
	}

	public boolean compare(String input) {
		return this.separator.equals(input);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Delimiter delimiter = (Delimiter)o;
		return Objects.equals(separator, delimiter.separator);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(separator);
	}
}
