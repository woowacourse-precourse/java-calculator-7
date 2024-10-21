package calculator;

public class InputValidator {

    private static final int MAX_LENGTH = 9;

    public static boolean isEmptyString(String input) {
        return input.isEmpty();
    }

    public static void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("계산 대상 문자열의 길이가 9자를 초과했습니다.");
        }
    }
}
