package calculator.model;

public class CustomDelimiterValidator {

	private static final int CUSTOM_DELIMITER_SUFFIX_START_INDEX = 3;
	private static final int MIN_LENGTH_FOR_CUSTOM_DELIMITER = 5;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

	public boolean hasCustomDelimiter(String input) {
		return input.length() >= MIN_LENGTH_FOR_CUSTOM_DELIMITER && input.startsWith(CUSTOM_DELIMITER_PREFIX)
		        && input.startsWith(CUSTOM_DELIMITER_SUFFIX, CUSTOM_DELIMITER_SUFFIX_START_INDEX);
	}
}
