package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static String readInput() {
        String input = Console.readLine();
        validateNullInput(input);
        validateWhitespaceInput(input);
        if (input.startsWith("//")) {
            validateCustomDelimiterInput(input);
        } else if (input.isEmpty()){
            input = "0";
        } else {
            validateDefaultDelimiterInput(input);
        }
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

    private static void validateCustomDelimiterInput(String input) {
        int delimiterIndex = input.indexOf("\\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException();
        }
        String delimiter = input.substring(2, delimiterIndex);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String expression = input.substring(delimiterIndex + 2);
        validateExpression(expression);
        String[] tokens = expression.split(delimiter);
        validateTokens(tokens);
    }

    private static void validateDefaultDelimiterInput(String input) {
        validateExpression(input);
        String[] tokens = input.split("[,:]");
        validateTokens(tokens);
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