package calculator;

public abstract class DelimiterParser {

    private static final String DEFAULT_REGEX = "[,|:]";

    public static boolean isDefaultDelimiter(String input) {
        String[] defaultDelimiterNumber = input.split(DEFAULT_REGEX);
        try {
            Integer.parseInt(defaultDelimiterNumber[0]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
