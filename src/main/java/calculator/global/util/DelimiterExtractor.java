package calculator.global.util;

import java.util.Arrays;

public abstract class DelimiterExtractor {

    protected static final String VALID_NUMERIC_REGEX = "^(0|[1-9][0-9]*)(\\.[0-9]+)?$";

    protected static final String CUSTOM_DELIMITER_PREFIX = "//";

    public abstract Integer[] extractNumber(String input);

    public abstract boolean isApplicable(String input);

    protected boolean isNotValid(String input) {
        return !input.matches(VALID_NUMERIC_REGEX);
    }
}
