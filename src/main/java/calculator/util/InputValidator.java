package calculator.util;

import calculator.exception.util.InputValidateErrorMessage;

public class InputValidator {
    public static String validate(String str) {
        // 문자열이 공백인지 확인
        if (str == null || str.isEmpty()) {
            return "0";
        }

        // 문자열 앞이 // 또는 숫자인지 확인
        if (!str.startsWith("//") && !str.matches("^\\d.*")) {
            throw new IllegalArgumentException(InputValidateErrorMessage.INVALID_INPUT.getMessage());
        }

        // 문자열 마지막이 숫자인지 확인
        if (!str.matches(".*\\d$")) {
            throw new IllegalArgumentException(InputValidateErrorMessage.INVALID_INPUT.getMessage());
        }

        return str;
    }
}
