package calculator.model;

public class CustomDelimiterValidator {

	private static final int CUSTOM_DELIMITER_SUFFIX_START_INDEX = 3;
	private static final int SPECIFIED_CUSTOM_DELIMITER_LENGTH = 5;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final int CUSTOM_DELIMITER_INDEX = 2;
	private static final int CUSTOM_DELIMITER_LENGTH = 1;

	public StringValidator validCustomDelimiter(String input) {
		if (hasCustomDelimiter(input)) {
			String customDelimiter = this.getCustomDelimiter(input);
			input = this.removeCustomDelimiter(input);
			return new StringValidator(input, customDelimiter);
		}
		return new StringValidator(input);
	}

	private boolean hasCustomDelimiter(String input) {
		return input.length() >= SPECIFIED_CUSTOM_DELIMITER_LENGTH && input.startsWith(CUSTOM_DELIMITER_PREFIX)
		        && input.startsWith(CUSTOM_DELIMITER_SUFFIX, CUSTOM_DELIMITER_SUFFIX_START_INDEX);
	}

	private String getCustomDelimiter(String input) {
		return input.substring(CUSTOM_DELIMITER_INDEX, CUSTOM_DELIMITER_INDEX + CUSTOM_DELIMITER_LENGTH);
	}

	private String removeCustomDelimiter(String input) {
		return input.substring(SPECIFIED_CUSTOM_DELIMITER_LENGTH);
	}
}
