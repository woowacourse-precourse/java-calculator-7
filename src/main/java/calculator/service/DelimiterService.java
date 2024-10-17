package calculator.service;

import calculator.model.Delimiters;

public class DelimiterService {
    private static final char CUSTOM_DELIMITER_PREFIX = '/';
    private static final String CUSTOM_DELIMITER_FIRST_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_LAST_FORMAT = "\n";
    private static final int CUSTOM_DELIMITER_FORMAT_MIN_LENGTH = 5;

    private final Delimiters delimiters;

    public DelimiterService(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public String addCustomDelimiters(String inputString) {
        while (usesCustomDelimiter(inputString)) {
            correctCustomDelimiterFormatOrThrow(inputString);
            char customDelimiter = inputString.charAt(2);
            delimiters.addCustomDelimiter(customDelimiter);
            inputString = inputString.substring(5);
        }
        return inputString;
    }

    private boolean usesCustomDelimiter(String inputString) {
        if (inputString.length() == 0) {
            return false;
        }
        char firstChar = inputString.charAt(0);
        return firstChar == CUSTOM_DELIMITER_PREFIX;
    }

    private void correctCustomDelimiterFormatOrThrow(String inputString) {
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

    private boolean checkCustomDelimiterFormatLength(String inputString) {
        return inputString.length() >= CUSTOM_DELIMITER_FORMAT_MIN_LENGTH;
    }

    private boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals(CUSTOM_DELIMITER_FIRST_FORMAT);
    }

    private boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals(CUSTOM_DELIMITER_LAST_FORMAT);
    }
}
