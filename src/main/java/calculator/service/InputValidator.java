package calculator.service;

import calculator.exception.ErrorCode;

public class InputValidator {

    public static void validate(String[] parts) {
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            } else if (!isNumeric(part)) {
                throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage() + part);
            } else if (Integer.parseInt(part) < 0) {
                throw new IllegalArgumentException(ErrorCode.NOT_POSITIVE_NUMBER.getMessage() + part);
            }
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}