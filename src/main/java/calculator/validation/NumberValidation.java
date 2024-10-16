package calculator.validation;

public class NumberValidation {

    public static void number(String input) {
        if (isNotPositiveNumber(input.trim())) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private static boolean isNotPositiveNumber(String input) {
        int inputNumber = Integer.parseInt(input);
        return inputNumber <= 0;
    }
}
