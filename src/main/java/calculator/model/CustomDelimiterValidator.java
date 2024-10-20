package calculator.model;

public class CustomDelimiterValidator {

	private static final int CUSTOM_DELIMITER_SUFFIX_START_INDEX = 3;
	private static final int SPECIFIED_CUSTOM_DELIMITER_LENGTH = 5;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final int CUSTOM_DELIMITER_INDEX = 2;
	private static final int CUSTOM_DELIMITER_LENGTH = 1;

	public boolean hasCustomDelimiter(String input) {
		return input.length() >= SPECIFIED_CUSTOM_DELIMITER_LENGTH && input.startsWith(CUSTOM_DELIMITER_PREFIX)
		        && input.startsWith(CUSTOM_DELIMITER_SUFFIX, CUSTOM_DELIMITER_SUFFIX_START_INDEX);
	}

	public String getCustomDelimiter(String input) {
		return input.substring(CUSTOM_DELIMITER_INDEX, CUSTOM_DELIMITER_INDEX + CUSTOM_DELIMITER_LENGTH);
	}
}
