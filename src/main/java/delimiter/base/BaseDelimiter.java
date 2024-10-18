package delimiter.base;

public enum BaseDelimiter {
	COMMA(","),
	COLON(":");

	private final String  description;

	BaseDelimiter(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
