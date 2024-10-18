package calculator.util;

import calculator.exception.util.CustomDelimiterExtractorErrorMessage;

import static calculator.util.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.util.DelimiterConstants.DEFAULT_DELIMITERS;

public class CustomDelimiterExtractor {
    public static String extract(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END);

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        String delimiter = input.substring(2, input.indexOf(CUSTOM_DELIMITER_END));

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

        if (delimiter.equals(DEFAULT_DELIMITERS[0]) || delimiter.equals(DEFAULT_DELIMITERS[1])) {
            throw new IllegalArgumentException(CustomDelimiterExtractorErrorMessage.CUSTOM_DUPLICATE_CUSTOM_DELIMITER.getMessage());
        }
    }
}