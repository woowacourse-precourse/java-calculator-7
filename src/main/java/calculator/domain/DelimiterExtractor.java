package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.MULTIPLE_CHARACTERS;

import calculator.global.exception.CalculatorException;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final int MAX_DELIMITER_LENGTH = 1;

    public String extractDelimiters(String input, String defaultDelimiters, String customDelimiterStart,
                                    String customDelimiterEnd) {
        String delimiters = defaultDelimiters;
        String customDelimiter = extractCustomDelimiter(input, customDelimiterStart, customDelimiterEnd);
        if (!customDelimiter.isEmpty()) {
            validateCustomDelimiterLength(customDelimiter);
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        return delimiters;
    }

    private String extractCustomDelimiter(String input, String customDelimiterStart, String customDelimiterEnd) {
        int startIndex = input.indexOf(customDelimiterStart);
        int endIndex = input.indexOf(customDelimiterEnd);

        if (startIndex != -1 && endIndex != -1) {
            if (startIndex < endIndex) {
                return input.substring(startIndex + customDelimiterStart.length(), endIndex);
            } else {
                return input.substring(endIndex + customDelimiterEnd.length(), startIndex);
            }
        }
        return "";
    }

    private void validateCustomDelimiterLength(String customDelimiter) {
        if (customDelimiter.length() > MAX_DELIMITER_LENGTH) {
            throw new CalculatorException(MULTIPLE_CHARACTERS);
        }
    }
}
