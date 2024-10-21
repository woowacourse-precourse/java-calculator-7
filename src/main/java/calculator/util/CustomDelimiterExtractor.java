package calculator.util;

import static calculator.exception.util.CustomDelimiterExtractorErrorMessage.*;
import static calculator.util.DelimiterConstants.*;

public class CustomDelimiterExtractor {
    private static final String METACHARACTERS = "[.*+?^$(){}|\\\\]";

    public static String extract(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END);

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        String delimiter = input.substring(2, delimiterEndIndex);
        validate(delimiter);
        return delimiter;
    }

    private static void validate(String delimiter) {
        // 커스텀 구분자가 비어있다면,
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_IS_EMPTY.getMessage());
        }

        // 커스텀 구분자가 공백이라면,
        if (delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_IS_SPACE.getMessage());
        }

        // 커스텀 구분자가 기본 구분자와 같다면,
        if (delimiter.equals(DEFAULT_DELIMITERS[0]) || delimiter.equals(DEFAULT_DELIMITERS[1])) {
            throw new IllegalArgumentException(CUSTOM_DUPLICATE_CUSTOM_DELIMITER.getMessage());
        }

        // 커슽머 구분자가 메타 기호라면,
        if (delimiter.matches(METACHARACTERS)) {
            throw new IllegalArgumentException(INVALID_META_DELIMITER_FORMAT.getMessage());
        }
    }
}