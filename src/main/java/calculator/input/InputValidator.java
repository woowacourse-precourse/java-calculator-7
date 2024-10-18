package calculator.input;

public class InputValidator {

    public static void validateNonNegative(int n) {
        if (isNegative(n)) {
            throw new IllegalArgumentException("입력 값이 음수가 될 수 없습니다.");
        }
    }

    public static void validateInputBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값이 null 또는 비어있을 수 없습니다.");
        }
    }

    private static boolean isNegative(int n) {
        return n < 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
