package calculator.domain;

import static calculator.constants.DelimiterConstants.COLON;
import static calculator.constants.DelimiterConstants.COMMA;

public class DelimiterHandler {

    private static final String NUMBER_FIRST_REGEX = "^[1-9].*";
    private static final String EMPTY_STRING = "";

    private final CustomDelimiterExtractor customDelimiterExtractor;

    public DelimiterHandler(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    public String getCustomDelimiterIfPresent(String stringWithDelimiter) {
        if (!isUsingOriginalDelimiter(stringWithDelimiter)) {
            return customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter);
        }
        return EMPTY_STRING;
    }

    private boolean isUsingOriginalDelimiter(String stringWithDelimiter) {
        return stringWithDelimiter.startsWith(COMMA) ||
                stringWithDelimiter.startsWith(COLON) ||
                stringWithDelimiter.matches(NUMBER_FIRST_REGEX);
    }
}
