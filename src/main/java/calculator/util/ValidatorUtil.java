package calculator.util;

public class ValidatorUtil {

    public static boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
