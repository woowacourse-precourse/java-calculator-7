package calculator.model;

import static calculator.Utils.DelimiterConstants.COLON;
import static calculator.Utils.DelimiterConstants.COMMA;
import static calculator.Utils.DelimiterConstants.DELIMITER_PATTERN_PREFIX;
import static calculator.Utils.DelimiterConstants.DELIMITER_PATTERN_SUFFIX;

import java.util.Arrays;


public class DelimiterProcessor {

    public String[] splitByDelimiter(String userInput, String delimiter) {
        userInput = deleteCustomDelimiter(userInput, delimiter);
        String[] split = userInput.split(DELIMITER_PATTERN_PREFIX + delimiter + DELIMITER_PATTERN_SUFFIX);

        split = Arrays.stream(split)
                .filter(s -> !s.trim().isEmpty())
                .toArray(String[]::new);

        return split;
    }

    public String deleteCustomDelimiter(String userInput, String delimiter) {
        if (hasCustomDelimiter(delimiter)) {
            userInput = userInput.replace("//", "");
            userInput = userInput.replace("\n", "");
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
