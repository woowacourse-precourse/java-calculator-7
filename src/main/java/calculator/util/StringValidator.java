package calculator.util;

public abstract class StringValidator {

    public static void validate(String input) {
        validateInput(input);
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
