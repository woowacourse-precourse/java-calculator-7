package calculator;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;

    public String extractCustomDelimiter(String userInput) {
        String customDelimiter = "";
        if (userInput.startsWith(CUSTOM_DELIMITER_PREFIX) && userInput.contains(CUSTOM_DELIMITER_SUFFIX)) {
            int delimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
            customDelimiter = userInput.substring(CUSTOM_DELIMITER_START_INDEX, delimiterEndIndex);
        }
        return customDelimiter;
    }
}
