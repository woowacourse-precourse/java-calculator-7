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
        String delimiter = input.substring(2, input.indexOf("\\n"));
        String expression = input.substring(input.indexOf("\\n") + 2);
        String[] tokens = expression.split(delimiter);
        validateTokens(tokens);
    }

    private static void validateDefaultDelimiterInput(String input) {
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(input.length() - 1);
        if (!Character.isDigit(firstChar) || !Character.isDigit(lastChar)) {
            throw new IllegalArgumentException();
        }
        String[] tokens = input.split("[,:]");
        validateTokens(tokens);
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