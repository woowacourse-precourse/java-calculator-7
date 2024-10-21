package calculator.model;

import static calculator.Utils.DelimiterConstants.COLON;
import static calculator.Utils.DelimiterConstants.COMMA;
import static calculator.Utils.DelimiterConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.Utils.DelimiterConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.Utils.DelimiterConstants.DELIMITER_PATTERN_PREFIX;
import static calculator.Utils.DelimiterConstants.DELIMITER_PATTERN_SUFFIX;
import static calculator.Utils.DelimiterConstants.EMPTY;

import java.util.Arrays;


public class DelimiterProcessor {

    public String[] splitByDelimiter(String userInput, String delimiter) {

        if (delimiter.isEmpty()) {
            return new String[]{userInput};
        }

        userInput = deleteCustomDelimiter(userInput, delimiter);
        String[] split = userInput.split(DELIMITER_PATTERN_PREFIX + delimiter + DELIMITER_PATTERN_SUFFIX);

        split = Arrays.stream(split)
                .filter(s -> !s.trim().isEmpty())
                .toArray(String[]::new);

        return split;
    }

    public String deleteCustomDelimiter(String userInput, String delimiter) {
        if (hasCustomDelimiter(delimiter)) {
            userInput = userInput.replace(CUSTOM_DELIMITER_PREFIX, EMPTY);
            userInput = userInput.replace(CUSTOM_DELIMITER_SUFFIX, EMPTY);
        }
        return userInput;
    }


    public boolean hasCustomDelimiter(String delimiters) {
        for (char delimiter : delimiters.toCharArray()) {
            if (delimiter != COMMA && delimiter != COLON) {
                return true;
            }
        }
        return false;
    }
}
