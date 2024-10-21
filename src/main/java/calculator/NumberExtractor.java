package calculator;

public class NumberExtractor {
    private static final String SEPARATOR_CHAR = "//";
    private static final int START_NUMBER_INDEX = 5;

    private static boolean isCustomDelimiterUsed(String inputString) {
        return inputString.contains(SEPARATOR_CHAR);
    }
}
