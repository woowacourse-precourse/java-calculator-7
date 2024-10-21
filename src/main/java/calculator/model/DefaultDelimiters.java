package calculator.model;

public enum DefaultDelimiters {
	COMMA(","),
	COLON(":");

	private final String delimiter;

	DefaultDelimiters(String delimiter) {
		this.delimiter = delimiter;
	}

	public String getDelimiter() {
		return delimiter;
	}
}
