package calculator.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String BASIC_DELIMITER_REGEX = "[,|:]";
    private static final int STARTPOINT_OF_STRING = 5;

    public static void validateInput(String input, boolean isValidCustomDelimiter, String customDelimiter) {
        String delimiterRegex = BASIC_DELIMITER_REGEX;
        if (isValidCustomDelimiter) {
            delimiterRegex = BASIC_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
            input = input.substring(STARTPOINT_OF_STRING);
        }

        validateStartWithNumber(input);
        validateContinuousDelimiters(input, isValidCustomDelimiter, customDelimiter);
        validateTokens(input, delimiterRegex);
    }

    private static void validateStartWithNumber(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력의 시작은 숫자여야 합니다. 구분자로 시작할 수 없습니다.");
        }
    }

    private static void validateContinuousDelimiters(String input, boolean isValidCustomDelimiter, String customDelimiter) {
        String continuousDelimiterRegex = "[,|:]{" + 2 + "}";
        if (isValidCustomDelimiter) {
            continuousDelimiterRegex += "|" + Pattern.quote(customDelimiter) + "{" + 2 + "}";
        }
        if (input.matches(".*(" + continuousDelimiterRegex + ").*")) {
            throw new IllegalArgumentException("구분자가 연속으로 올 수 없습니다.");
        }
    }

    private static void validateTokens(String input, String delimiterRegex) {
        String[] tokens = input.split(delimiterRegex);
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다.");
                }
            }
        }
    }
}
