package calculator.util;

public class ValidatorUtil {

    public static boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public static boolean isContainingNumbers(String input) {
        return input.matches(".*\\d.*");
    }

    public static boolean isContainingWhitespace(String input) {
        return input.matches(".*\\s.*");
    }
}
