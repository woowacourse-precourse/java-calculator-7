package calculator.domain;

import calculator.exception.delimiter.DelimiterException;

import static calculator.exception.delimiter.DelimiterExceptionMessage.WRONG_CUSTOM_DELIMITER_FORMAT;
import static calculator.validator.DelimiterValidator.validateEmptyCustomDelimiter;
import static calculator.validator.DelimiterValidator.validateEndIndexExists;

public class CustomDelimiterExtractor {

    private static final String CUSTOM_DELIMITER_PREFIX_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX_FORMAT = "\\n";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;

    public String getCustomDelimiter(String stringWithDelimiter) {
        if (stringWithDelimiter.startsWith(CUSTOM_DELIMITER_PREFIX_FORMAT)) {
            return extractCustomDelimiter(stringWithDelimiter);
        }
        throw new DelimiterException(WRONG_CUSTOM_DELIMITER_FORMAT);
    }

    private String extractCustomDelimiter(String stringWithDelimiter) {
        int endIndex = stringWithDelimiter.indexOf(CUSTOM_DELIMITER_SUFFIX_FORMAT);
        validateEndIndexExists(endIndex);

        String customDelimiter = stringWithDelimiter.substring(CUSTOM_DELIMITER_BEGIN_INDEX, endIndex);
        validateEmptyCustomDelimiter(customDelimiter);

        return customDelimiter;
    }
}
