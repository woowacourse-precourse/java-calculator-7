package calculator.validation;

public class NumberValidation {

    public static void number(String input) {
        if (isNotPositiveNumber(input)) {
            throw new IllegalArgumentException("양수만 입력가능합니다.");
        }
    }

    private static boolean isNotPositiveNumber(String input) {
        return !input.matches("[1-9]");
    }
}
