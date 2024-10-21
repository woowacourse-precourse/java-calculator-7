package calculator;

public class NumberExtractor {
    private static final String SEPARATOR_CHAR = "//";
    private static final int START_NUMBER_INDEX = 5;

    private static boolean isCustomDelimiterUsed(String inputString) {
        return inputString.contains(SEPARATOR_CHAR);
    }

    private static String trimInputString(String inputString) {
        return inputString.substring(START_NUMBER_INDEX);
    }

    public String[] extractNumbers(String inputString) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        if (inputString.isEmpty()) {
            return new String[]{"0"};
        }

        String delimiter = delimiterExtractor.extractDelimiter(inputString);
        if (isCustomDelimiterUsed(inputString)) {
            inputString = trimInputString(inputString);
        }
        return inputString.split(delimiter);

    }
}
