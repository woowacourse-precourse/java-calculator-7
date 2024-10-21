package calculator.util;

public abstract class ExpressionUtils {

    public static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
