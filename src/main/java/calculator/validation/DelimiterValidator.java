package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constants.DelimiterEnum.*;
import static calculator.controller.ExceptionMessage.INVALID_CUSTOM_TYPE;
import static calculator.validation.InputValidator.isContainMinus;

public class DelimiterValidator {
    public static String[] customDelimiterAddCalculator(String userInput) {
        userInput = userInput.replace("\\n", CUSTOM_DELIMITER_BACKWARD.getValue());
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN.getValue()).matcher(userInput);
        if (m.find()) {
            String[] numbers = splitByCustomDelimiter(m.group(2), m.group(1));
            isContainMinus(numbers);
            return numbers;
        }
        throw new IllegalArgumentException(INVALID_CUSTOM_TYPE.format());
    }

    public static String[] defaultDelimiterAddCalculator(String userInput) {
        String[] numbers = userInput.split(DEFAULT_DELIMITER.getValue());
        isContainMinus(numbers);
        return numbers;
    }

    private static String[] splitByCustomDelimiter(String userInput, String customDelimiter) {
        if (userInput.matches(".*[,:].*")) {
            String combinedDelimiter = Pattern.quote(customDelimiter) + AND.getValue() + DEFAULT_DELIMITER.getValue();
            return userInput.split(combinedDelimiter);
        }
        if (userInput.contains(customDelimiter)) {
            return userInput.split(Pattern.quote(customDelimiter));
        }
        if (userInput.matches("\\d+")) {
            return new String[]{userInput};
        }
        throw new IllegalArgumentException(INVALID_CUSTOM_TYPE.format());
    }
}
