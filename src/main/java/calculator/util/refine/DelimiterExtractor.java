package calculator.util.refine;

import static calculator.util.refine.InputValidator.*;

public class DelimiterExtractor {
    private final String BASIC_DELIMITER = "[,:]";
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String NEW_LINE = "\\n";

    public String extractDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(NEW_LINE);
            validateDelimiterAfterNewLinePresence(delimiterIndex);
            String delimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
            validateSingleCharacterDelimiter(delimiter);

            return delimiter;
        }

        return BASIC_DELIMITER;
    }

    public String removeDelimiterDefinition(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(NEW_LINE);

            return input.substring(delimiterIndex + NEW_LINE.length());
        }
        return input;
    }
}
