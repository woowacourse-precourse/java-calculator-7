package calculator.model;

public enum CustomDelimiterPattern {
	START("//"),
	END("\\n");

	private final String pattern;

	CustomDelimiterPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
}
