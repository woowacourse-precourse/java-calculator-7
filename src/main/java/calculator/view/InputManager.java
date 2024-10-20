package calculator.view;

import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static String customDelimiter;

    public static String consoleInput() {
        String input = Console.readLine();
        boolean isValidCustomDelimiter = false;

        if (input.isEmpty()) return "0";

        if (input.startsWith("//")) {
            isValidCustomDelimiter = validateCustomDelimiter(input);
        }

        InputValidator.validateInput(input, isValidCustomDelimiter, customDelimiter);

        return input;
    }

    private static boolean validateCustomDelimiter(String input) {
        if (!input.contains("\n")) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        int delimiterEndIndex = input.indexOf("\n");
        String custom = input.substring(2, delimiterEndIndex);

        if (custom.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 반드시 하나의 문자여야 합니다.");
        }

        customDelimiter = custom;
        return true;
    }
}
