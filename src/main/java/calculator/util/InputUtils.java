package calculator.util;

import calculator.domain.Expression;
import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static Expression convertToExpression(String input) {
        String delimiter = "[,:]";
        boolean isCustomDelimiter = false;
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterIndex);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException();
            }
            isCustomDelimiter = true;
            input = input.substring(delimiterIndex + 1);
        }

        validateExpression(input);
        return new Expression(input, delimiter, isCustomDelimiter);
    }

    public static String readInput() {
        String input = Console.readLine();
        validateNullInput(input);
        validateWhitespaceInput(input);
        return input;
    }

    private static void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWhitespaceInput(String input) {
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateExpression(String expression) {
        char firstChar = expression.charAt(0);
        char lastChar = expression.charAt(expression.length() - 1);
        if (!Character.isDigit(firstChar) || !Character.isDigit(lastChar)) {
            throw new IllegalArgumentException();
        }
    }

    // 토큰이 유효한지 검증하는 메서드
    private static void validateTokens(String[] tokens) {
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException();
            }
            validateNumericInput(token);
        }
    }

    // 문자열이 양수인지 검증하는 메서드
    private static void validateNumericInput(String token) {
        try {
            // 옳바른 양수인지 확인 01은 숫자가 아님
            if (token.charAt(0) == '0') {
                throw new IllegalArgumentException();
            }
            int number = Integer.parseInt(token); // 숫자로 변환 시도
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}