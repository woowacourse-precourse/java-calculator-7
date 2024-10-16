package calculator.util;

public abstract class InputValidator {
    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
