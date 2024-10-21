package utils;

public class Utils {

    private static final String NUMBERS_ONLY_PATTERN = "^[0-9]+$";
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static boolean containsOnlyNumbers(String input) {
        return input.matches(NUMBERS_ONLY_PATTERN);
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
