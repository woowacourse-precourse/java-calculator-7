package calculator.calculator;

import static calculator.exception.ErrorMessage.INVALID_INPUT;

public class Calculator {
    public static String input(String str) {
        if (str == null || str.isEmpty()) {
            return "0";
        }

        if (!str.startsWith("//") || !str.matches("^\\d.*")) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        return str;
    }
}
