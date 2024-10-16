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

    private static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }

    private static boolean isNotPositiveNumber(String input) {
        return input.contains("0") || input.contains("-");
    }
}
