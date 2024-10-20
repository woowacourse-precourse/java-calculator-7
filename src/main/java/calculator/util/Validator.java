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

    // 문자열이 양수인지 검증하는 메서드
    public static int validateNumericInput(String token) {
        try {
            // 옳바른 양수인지 확인 01은 숫자가 아님
            if (token.charAt(0) == '0' && token.length() > 1) {
                throw new IllegalArgumentException();
            }
            int number = Integer.parseInt(token); // 숫자로 변환 시도
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
