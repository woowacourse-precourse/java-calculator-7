package calculator.delimiter;

public class DelimiterUtils {

    private DelimiterUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String removeSpaces(String input) {
        return input.replace(" ", "");
    }

    public static String replaceSpecialCharacters(String input) {
        return input.replace("|", "\\|");
    }
}
