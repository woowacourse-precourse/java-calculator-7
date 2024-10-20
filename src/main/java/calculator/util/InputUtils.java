package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static String readInput() {
        String input = Console.readLine();
        validateNullInput(input);
        validateWhitespaceInput(input);
        if (input.startsWith("//")) {
            validateCustomDelimiterInput(input);
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
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException();
            }
            validateNumericInput(token);
        }
    }

    private static void validateDefaultDelimiterInput(String input) {
        String[] tokens = input.split("[,:]");
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
            int number = Integer.parseInt(token); // 숫자로 변환 시도
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}