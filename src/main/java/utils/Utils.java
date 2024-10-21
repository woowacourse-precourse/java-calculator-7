package utils;

public class Utils {

    private static final String ZERO_OR_POSITIVE_NUMBER = "^[0-9]+$";
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static boolean isNumeric(String input) {
        return input.matches(ZERO_OR_POSITIVE_NUMBER);
    }

    public static String removeCommas(String input) {
        return input.replaceAll(COMMA, "");
    }

    public static String removeColons(String input) {
        return input.replaceAll(COLON, "");
    }

    public static String removeDelimiters(String input, String delimiter) {
        return input.replaceAll(delimiter, "");
    }
}
