package calculator;

import calculator.exception.InvalidInputException;

public class CalculatorDelimiter implements Delimiter {
    private final static String CUSTOM_DELIMITER_PREFIX = "//";
    private final static String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final String input;
    private final int prefixIndex;
    private final int suffixIndex;

    public CalculatorDelimiter(String input) {
        prefixIndex = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        validateCustomDelimiter(input);
        this.input = input;
    }

    private boolean isValidDelimiterPosition() {
        return prefixIndex == -1 && suffixIndex == -1 ||
                prefixIndex == 0 && prefixIndex < suffixIndex;
    }

    private boolean isEmptyCustomDelimiter() {
        return prefixIndex == -1 && suffixIndex == -1;
    }

    private void validateCustomDelimiter(String input) {
        if (!isValidDelimiterPosition()) {
            throw new InvalidInputException();
        }

        final String customDelimiter = getCustomDelimiter(input);
        if (customDelimiter == null) {
            return;
        }

        this.delimiters.add(customDelimiter);
    }

    private String getCustomDelimiter(String input) {
        if (isEmptyCustomDelimiter()) {
            return null;
        }
        return input.substring(CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
    }

    public String getDelimiterRegex() {
        return String.join("|", this.delimiters);
    }

    public String getContentWithoutDelimiter() {
        if (suffixIndex == -1) {
            return input;
        }
        return input.substring(suffixIndex+CUSTOM_DELIMITER_SUFFIX.length());
    }
}
