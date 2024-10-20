package calculator.util;

public class NumberValidator {
    private static final int positiveNumber = 1;

    public static int parseAndValidateInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < positiveNumber) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자 이외에 숫자만 입력가능합니다.");
        }
    }

    public static boolean isNullString(String[] input) {
        return input == null || input.length == 0;
    }
}
