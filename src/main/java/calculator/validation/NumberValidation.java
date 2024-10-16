package calculator.validation;

public class NumberValidation {

    public static void validation(String input) {
        if (isKorean(input.trim()) || isAlphabet(input.trim()) || isNotPositiveNumber(input.trim())) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private static boolean isKorean(String input) {
        return input.matches("[가-힣]+");
    }

    private static boolean isNotPositiveNumber(String input) {
        int inputNumber = Integer.parseInt(input);
        return inputNumber <= 0;
    }

    private static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }
}
