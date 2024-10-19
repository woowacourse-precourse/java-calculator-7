package calculator.common;

import calculator.strategy.CustomDelimiter;
import calculator.strategy.DefaultDelimiter;
import calculator.strategy.Delimiter;

public class InputSplitter {

    private static final String CUSTOM_DELIMITER_START_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_END_SUFFIX = "\\n";
    private static final int DELIMITER_DECLARATION_LENGTH = 2;

    public String[] split(String input) {
        String extractedNumberText = input;
        Delimiter delimiter = selectDelimiter(input);

        if (hasCustomDelimiter(input)) {
            int customDelimiterIndex = input.indexOf(CUSTOM_DELIMITER_END_SUFFIX) + DELIMITER_DECLARATION_LENGTH;
            extractedNumberText = input.substring(customDelimiterIndex);
        }
        return delimiter.split(extractedNumberText);
    }

    private Delimiter selectDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END_SUFFIX);
            String customDelimiterText = input.substring(DELIMITER_DECLARATION_LENGTH, customDelimiterEndIndex);
            return new CustomDelimiter(customDelimiterText);
        }
        return new DefaultDelimiter();
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_PREFIX) && input.contains(CUSTOM_DELIMITER_END_SUFFIX);
    }
}
