package calculator;

public class InputValidator {

    public static boolean isEmptyString(String input) {
        return input.isEmpty();
    }

    public static void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }
    }
}
