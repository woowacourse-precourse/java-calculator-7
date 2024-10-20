package calculator;

import java.util.regex.Pattern;

public class InputStringParser {

    public static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 5;

    private String delimiterPattern = DEFAULT_DELIMITER;

    public String processInputString(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return input;
        }
        if (input.startsWith("//")) {
            input = processCustomDelimiter(input);
        }
        return input;
    }

    public String processCustomDelimiter(String input) {
        InputValidator.validateCustomDelimiterFormat(input);
        int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END);
        String customDelimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, delimiterIndex);
        InputValidator.validateCustomDelimiter(customDelimiter);
        delimiterPattern = Pattern.quote(customDelimiter) + "|" + delimiterPattern;
        return input.substring(CUSTOM_DELIMITER_END_INDEX);
    }

    public String[] split(String input) {
        String[] numbers = input.split(delimiterPattern);
        InputValidator.validateNumbers(numbers);
        return numbers;
    }
}
