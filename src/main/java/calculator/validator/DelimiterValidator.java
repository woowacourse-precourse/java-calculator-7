package calculator.validator;

import calculator.exception.delimiter.DelimiterException;

import static calculator.exception.delimiter.DelimiterExceptionMessage.EMPTY_CUSTOM_DELIMITER;
import static calculator.exception.delimiter.DelimiterExceptionMessage.WRONG_CUSTOM_DELIMITER_FORMAT;

public class DelimiterValidator {

    private static final int NON_EXIST = -1;

    public static void validateEndIndexExists(int endIndex) {
        if (endIndex == NON_EXIST) {
            throw new DelimiterException(WRONG_CUSTOM_DELIMITER_FORMAT);
        }
    }

    public static void validateEmptyCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new DelimiterException(EMPTY_CUSTOM_DELIMITER);
        }
    }
}
