package calculator.validation;

public class NumberValidation {

    public static void validation(String input) {
        if (isNotNumber(input.trim()) || isNotPositiveNumber(input.trim())) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private static boolean isNotNumber(String input) {
        return input.matches("[\\D]+");
    }

    private static boolean isNotPositiveNumber(String input) {
        return input.contains("0") || input.contains("-");
    }
}
