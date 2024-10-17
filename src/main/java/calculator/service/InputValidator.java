package calculator.service;

public class InputValidator {

    public static void validate(String[] parts) {
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            } else if (!isNumeric(part)) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + part);
            } else if (Integer.parseInt(part) < 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되었습니다: " + part);
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