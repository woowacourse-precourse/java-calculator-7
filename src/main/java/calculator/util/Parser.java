package calculator.util;

public class Parser {

    private static final String CUSTOM_TAG = "(//|\\\\n)";

    public static String[] splitByTag(String input) {
        return input.split(CUSTOM_TAG);
    }
}
