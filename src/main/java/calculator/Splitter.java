package calculator;

import static calculator.Validator.hasCustomSplitter;
import static calculator.Validator.isEmptyString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Splitter {
    private String userInput;
    private String DELIMITER = ",|:";

    public Splitter(String userInput) {
        this.userInput = userInput;
    }

    public List<String> splitString() throws IllegalArgumentException {
        if (hasCustomSplitter(userInput)) {
            int delimiterIndex = userInput.indexOf("\\n");
            DELIMITER += ("|" + getCustomSplitter(delimiterIndex));
            userInput = userInput.substring(delimiterIndex + 2);
        }
        if (isEmptyString(userInput)) {
            return Collections.emptyList();
        }

        return Arrays.stream(userInput.split(DELIMITER)).toList();
    }

    private String getCustomSplitter(int delimiterIndex) {
        String customDelimiter = userInput.substring(2, delimiterIndex);
        return escapeSpecialRegexChars(customDelimiter);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\\\.\\^\\$\\*\\+\\?\\(\\)\\[\\]\\{\\}\\|])", "\\\\$1");
    }
}
