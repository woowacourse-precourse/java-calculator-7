package calculator.model;

public class Delimiter {

	private final String separator;

	public Delimiter(String delimiter) {
		this.separator = delimiter;
	}

	public boolean compare(String input) {
		return this.separator.equals(input);
	}
}
