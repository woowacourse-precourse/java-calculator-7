package calculator.model;

import calculator.util.Constants;
import calculator.util.ErrorMessages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.*;
import static calculator.util.ErrorMessages.*;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sumTokens(tokens);
    }

    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            validateCustomDelimiter(input);
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        return splitWithDefaultDelimiters(input);
    }

    private String[] splitWithDefaultDelimiters(String input) {
        validateDefaultDelimiter(input);
        return input.split(DEFAULT_DELIMITERS);
    }

    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            validateNegativeNumber(number);
            sum += number;
        }
        return sum;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
        }
    }

    private void validateCustomDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            int delimiterEndIndex = inputString.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException(ERROR_INVALID_CUSTOM_DELIMITER);
            }
        }

        if (!inputString.startsWith("//") && inputString.contains("\\n")) {
            throw new IllegalArgumentException(ERROR_INVALID_CUSTOM_DELIMITER);
        }
    }
    private void validateDefaultDelimiter(String input) {
        if (!input.matches("^[0-9" + DEFAULT_DELIMITERS + "]+$")) {
            throw new IllegalArgumentException(ERROR_INVALID_DEFAULT_DELIMITER);
        }
    }
}
