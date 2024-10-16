package calculator.utils;

public class Utils {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public static boolean isNumeric(String str) {
        return str.matches(POSITIVE_INTEGER_REGEX);
    }
}
