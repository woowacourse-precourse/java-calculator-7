package utils;

public class Utils {
    private static final String ZERO_OR_POSITIVE_NUMBER = "^[0-9]+$";

    public static boolean isNumeric(String input) {
        return input.matches(ZERO_OR_POSITIVE_NUMBER);
    }
}
