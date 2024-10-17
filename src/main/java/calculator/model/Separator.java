package calculator.model;

import static calculator.constants.Symbol.BACKSLASH;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_PREFIX;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_SUFFIX;
import static calculator.constants.Symbol.PREFIX_OFFSET;

public class Separator {
    private final String DEFAULT_SEPARATOR = ",:";
    private final String separator;

    public Separator(String expression) {
        this.separator = extractSeparator(expression);
    }

    public String extractSeparator(String expression) {
        String defaultSeparator = DEFAULT_SEPARATOR;
        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int start = expression.indexOf(CUSTOM_DELIMITER_PREFIX) + PREFIX_OFFSET;
            int end = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);
            String customSeparator = expression.substring(start, end);
            if (customSeparator.contains(BACKSLASH)) {
                customSeparator += BACKSLASH;
            }
            return defaultSeparator + customSeparator;
        }
        return defaultSeparator;
    }

    public String getSeparator() {
        return separator;
    }
}
