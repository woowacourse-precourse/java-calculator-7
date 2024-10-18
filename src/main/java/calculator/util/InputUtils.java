package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    private static String readInput() {
        String input = Console.readLine();
        if (input.startsWith("//")) {
            validateCustomDelimiterInput(input);
        } else {
            validateDefaultDelimiterInput(input);
        }
        return input;
    }

    private static void validateCustomDelimiterInput(String input) {
        // todo 커스텀 구분자 검증 로직
    }

    private static void validateDefaultDelimiterInput(String input) {
        // todo 기본 구분자 검증 로직
    }
}