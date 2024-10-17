package calculator.model;

public class CustomDelimiterProcessor {
    private final static char CUSTOM_DELIMITER_PREFIX = '/';
    private static final String CUSTOM_DELIMITER_FIRST_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_LAST_FORMAT = "\n";
    private static final int CUSTOM_DELIMITER_FORMAT_MIN_LENGTH = 5;

    public static String addCustomDelimiters(String inputString, Delimiters delimiters) {
        while (usesCustomDelimiter(inputString)) {
            correctCustomDelimiterFormatOrThrow(inputString);
            char customDelimiter = inputString.charAt(2);
            delimiters.addCustomDelimiter(customDelimiter);
            inputString = inputString.substring(5);
        }
        return inputString;
    }

    private static boolean usesCustomDelimiter(String inputString) {
        if (inputString.length() == 0) {
            return false;
        }
        char firstChar = inputString.charAt(0);
        return firstChar == CUSTOM_DELIMITER_PREFIX;
    }

    private static void correctCustomDelimiterFormatOrThrow(String inputString) {
        if (!checkCustomDelimiterFormatLength(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterFirstFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterLastFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkCustomDelimiterFormatLength(String inputString) {
        return inputString.length() >= CUSTOM_DELIMITER_FORMAT_MIN_LENGTH;
    }

    private static boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals(CUSTOM_DELIMITER_FIRST_FORMAT);
    }

    private static boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals(CUSTOM_DELIMITER_LAST_FORMAT);
    }
}
