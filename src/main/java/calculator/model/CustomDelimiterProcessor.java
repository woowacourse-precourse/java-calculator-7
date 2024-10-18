package calculator.model;

public class CustomDelimiterProcessor {
    private static final String CUSTOM_DELIMITER_FIRST_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_LAST_FORMAT = "\\n";
    private static final int CUSTOM_DELIMITER_FORMAT_LENGTH = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public String addCustomDelimiters(String inputString, Delimiters delimiters) {

        while (specifiesCustomDelimiter(inputString)) {

            correctCustomDelimiterFormatOrThrow(inputString);

            char customDelimiter = inputString.charAt(CUSTOM_DELIMITER_INDEX);

            delimiters.addCustomDelimiter(customDelimiter);

            inputString = inputString.substring(CUSTOM_DELIMITER_FORMAT_LENGTH);

        }
        return inputString;
    }

    private boolean specifiesCustomDelimiter(String inputString) {
        return !inputString.isBlank() && !Character.isDigit(inputString.charAt(0));
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
        return inputString.startsWith(CUSTOM_DELIMITER_FIRST_FORMAT);
    }

    private boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 5);
        return lastFormat.equals(CUSTOM_DELIMITER_LAST_FORMAT);
    }
}
