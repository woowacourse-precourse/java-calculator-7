package calculator.util;

import calculator.exception.util.CustomDelimiterExtractorErrorMessage;

public class CustomDelimiterExtractor {
    private static final String DEFAULT_DELIMITER_1 = ",";
    private static final String DEFAULT_DELIMITER_2 = ":";
    private static final String CUSTOM_DELIMITER_END = "\n";

    public static String extract(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END);

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        String delimiter = input.substring(2, input.indexOf('\n'));

        validate(delimiter);

        return delimiter;
    }

    private static void validate(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.CUSTOM_DELIMITER_IS_EMPTY.getMessage());
        }

        if (delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.CUSTOM_DELIMITER_IS_SPACE.getMessage());
        }

        if (delimiter.equals(DEFAULT_DELIMITER_1) || delimiter.equals(DEFAULT_DELIMITER_2)) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.CUSTOM_DUPLICATE_CUSTOM_DELIMITER.getMessage());
        }
    }
}