package calculator.model;

import static calculator.utils.StringUtils.getFirstChar;
import static calculator.utils.StringUtils.isEmptyString;

public class CustomDelimiterProcessor {
    private static final String CUSTOM_DELIMITER_FIRST_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_LAST_FORMAT = "\\n";
    private static final int CUSTOM_DELIMITER_FORMAT_LENGTH = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final char CUSTOM_DELIMITER_PREFIX = '/';

    public String addCustomDelimiters(String inputString, Delimiters delimiters) {
        while (usesCustomDelimiter(inputString)) {
            correctCustomDelimiterFormatOrThrow(inputString);
            char customDelimiter = inputString.charAt(CUSTOM_DELIMITER_INDEX);
            delimiters.addCustomDelimiter(customDelimiter);
            inputString = inputString.substring(CUSTOM_DELIMITER_FORMAT_LENGTH);
        }
        return inputString;
    }

    private boolean usesCustomDelimiter(String inputString) {
        if (isEmptyString(inputString)) {
            return false;
        }
        char firstChar = getFirstChar(inputString);
        return firstChar == CUSTOM_DELIMITER_PREFIX;
    }

    private void correctCustomDelimiterFormatOrThrow(String inputString) {
        if (!checkCustomDelimiterFormatLength(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!isCustomDelimiterFirstFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!isCustomDelimiterLastFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkCustomDelimiterFormatLength(String inputString) {
        return inputString.length() >= CUSTOM_DELIMITER_FORMAT_LENGTH;
    }

    private boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 2);
        return firstFormat.equals(CUSTOM_DELIMITER_FIRST_FORMAT);
    }

    private boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 5);
        return lastFormat.equals(CUSTOM_DELIMITER_LAST_FORMAT);
    }
}
