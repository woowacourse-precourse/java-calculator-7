package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    private static String readInput() {
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
        // todo 커스텀 구분자 검증 로직
    }

    private static void validateDefaultDelimiterInput(String input) {
        // todo 기본 구분자 검증 로직
    }
}