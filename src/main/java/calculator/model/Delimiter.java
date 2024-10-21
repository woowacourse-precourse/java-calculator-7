package calculator.model;

import calculator.errors.InputError;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private String delimiters;

    public Delimiter(String message) {
        this.delimiters = DEFAULT_DELIMITERS;
        parseCustomDelimiter(message);
    }

    private void parseCustomDelimiter(String message) {
        if (hasCustomDelimiter(message)) {
            String customDelimiter = extractCustomDelimiter(message);
            addCustomDelimiter(customDelimiter);
        }
    }

    private boolean hasCustomDelimiter(String message) {
        return message.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String extractCustomDelimiter(String message) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = message.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = message.substring(startIndex, endIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(InputError.INVALID_DELIMITER.getMessage());
        }
        return customDelimiter;
    }

    private void addCustomDelimiter(String newDelimiter) {
        String escapedDelimiter = Pattern.quote(newDelimiter);
        this.delimiters += "|" + escapedDelimiter;
    }

    public String getRegexString() {
        return this.delimiters;
    }

    public int getNumbersStartIndex(String message) {
        if (hasCustomDelimiter(message)) {
            return message.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        }
        return 0;
    }
}