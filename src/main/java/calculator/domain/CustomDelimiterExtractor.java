package calculator.domain;

import static calculator.constants.DelimiterConstants.COLON;
import static calculator.constants.DelimiterConstants.COMMA;
import static calculator.validator.DelimiterValidator.*;

public class CustomDelimiterExtractor {

    private static final String CUSTOM_DELIMITER_SUFFIX_FORMAT = "\\n";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    private static final String NUMBER_FIRST_REGEX = "^-?\\d.*";
    private static final String EMPTY_STRING = "";

    public String getCustomDelimiter(String stringWithDelimiter) {
        if (!isUsingOriginalDelimiter(stringWithDelimiter)) {
            return extractCustomDelimiter(stringWithDelimiter);
        }
        return EMPTY_STRING;
    }

    private boolean isUsingOriginalDelimiter(String stringWithDelimiter) {
        return stringWithDelimiter.startsWith(COMMA) ||
                stringWithDelimiter.startsWith(COLON) ||
                stringWithDelimiter.matches(NUMBER_FIRST_REGEX);
    }

    private String extractCustomDelimiter(String stringWithDelimiter) {
        validateStartIndexExists(stringWithDelimiter);

        int endIndex = stringWithDelimiter.indexOf(CUSTOM_DELIMITER_SUFFIX_FORMAT);
        validateEndIndexExists(endIndex);

        String customDelimiter = stringWithDelimiter.substring(CUSTOM_DELIMITER_BEGIN_INDEX, endIndex);
        validateEmptyCustomDelimiter(customDelimiter);

        return customDelimiter;
    }
}
