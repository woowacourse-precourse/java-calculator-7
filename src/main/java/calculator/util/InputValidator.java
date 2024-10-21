package calculator.util;

import calculator.common.ErrorMessage;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateExpression(String expression, Set<Character> delimiters) {
        for (Character c : expression.toCharArray()) {
            if (!delimiters.contains(c) && !Character.isDigit(c) && c != '.' && c != '-') {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    public static void validateCustomDelimiters(char[] delimiters) {
        if (hasDefaultDelimiter(delimiters)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DEFAULT_DELIMITER.getMessage());
        }
        if (isDelimiterRepeated(delimiters)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DELIMITER.getMessage());
        }
        if (hasDelimiterNumber(delimiters)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_DELIMITER_NOT_ALLOWED.getMessage());
        }
    }

    private static boolean isDelimiterRepeated(char[] delimiters) {
        Set<Character> uniqueDelimiters = new HashSet<>();

        for (char delimiter : delimiters) {
            if (!uniqueDelimiters.add(delimiter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDefaultDelimiter(char[] delimiters) {
        for (char delimiter : delimiters) {
            if (delimiter == ',' || delimiter == ':') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDelimiterNumber(char[] delimiters) {
        for (char delimiter : delimiters) {
            if (Character.isDigit(delimiter)) {
                return true;
            }
        }
        return false;
    }
}
