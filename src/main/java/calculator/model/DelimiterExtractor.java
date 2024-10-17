package calculator.model;

import static calculator.Utils.DelimiterConstants.*;

public class DelimiterExtractor {

    public String determineDelimiter(String userInput) {
        return extractBasicDelimiters(userInput) + extractCustomDelimiters(userInput);
    }

    private String extractBasicDelimiters(String userInput) {
        StringBuilder basicDelimiters = new StringBuilder();
        basicDelimiters.append(hasDelimiter(userInput, String.valueOf(COMMA)));
        basicDelimiters.append(hasDelimiter(userInput, String.valueOf(COLON)));
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

    private String hasDelimiter(String userInput, String delimiter) {
        if (userInput.contains(delimiter)) {
            return delimiter;
        } else {
            return "";
        }
    }

}
