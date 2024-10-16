package calculator.model;


public class DelimiterProcessor {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;
    private static final int CUSTOM_DELIMITER_SUFFIX_LENGTH = 1;

    public String determineDelimiter(String userInput) {
        return extractBasicDelimiters(userInput) + extractCustomDelimiters(userInput);
    }

    private String extractBasicDelimiters(String userInput) {
        StringBuilder basicDelimiters = new StringBuilder();

        if (userInput.contains(COMMA)) {
            basicDelimiters.append(COMMA);
        }

        if (userInput.contains(COLON)) {
            basicDelimiters.append(COLON);
        }

        return basicDelimiters.toString();
    }

    private String extractCustomDelimiters(String userInput) {
        StringBuilder customDelimiters = new StringBuilder();

        while (userInput.contains(CUSTOM_DELIMITER_PREFIX)) {
            int startIndex = userInput.indexOf(CUSTOM_DELIMITER_PREFIX) + CUSTOM_DELIMITER_PREFIX_LENGTH;
            int endIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);

            if (endIndex == -1) {
                break;
            }

            if (startIndex < endIndex) {
                customDelimiters.append(userInput, startIndex, endIndex);
            }
            userInput = userInput.substring(endIndex + CUSTOM_DELIMITER_SUFFIX_LENGTH);
        }

        return customDelimiters.toString();
    }

}
