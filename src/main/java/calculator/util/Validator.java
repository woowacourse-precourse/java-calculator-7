package calculator.util;

public class Validator {
    public static void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWhitespaceInput(String input) {
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateExpression(String expression) {
        char firstChar = expression.charAt(0);
        char lastChar = expression.charAt(expression.length() - 1);
        if (!Character.isDigit(firstChar) || !Character.isDigit(lastChar)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumericInput(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if ((token.charAt(0) == '0' && token.length() > 1) || token.charAt(0) == '-') {
            throw new IllegalArgumentException();
        }
    }
}
