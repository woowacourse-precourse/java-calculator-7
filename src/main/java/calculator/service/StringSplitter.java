package calculator.service;

import calculator.constant.CalculatorConstants;
import calculator.constant.ExceptionMessageConstants;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringSplitter {
    public List<String> split(String input) {
        if (input.startsWith(CalculatorConstants.CUSTOM_DELIMITER_PREFIX)) {
            return splitWithCustomDelimiter(input);
        }
        return splitWithDefaultDelimiter(input);
    }

    private List<String> splitWithCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf(CalculatorConstants.CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEnd == -1) {
            throw new IllegalArgumentException(ExceptionMessageConstants.INVALID_CUSTOM_DELIMITER);
        }

        String customDelimiter = input.substring(CalculatorConstants.CUSTOM_DELIMITER_PREFIX.length(), delimiterEnd);
        String numbers = input.substring(delimiterEnd + CalculatorConstants.CUSTOM_DELIMITER_SUFFIX.length());
        if (numbers.isEmpty()) {
            return Arrays.asList();
        }
        return Arrays.asList(numbers.split(Pattern.quote(customDelimiter)));
    }

    private List<String> splitWithDefaultDelimiter(String input) {
        return Arrays.asList(input.split(CalculatorConstants.DEFAULT_DELIMITERS));
    }
}