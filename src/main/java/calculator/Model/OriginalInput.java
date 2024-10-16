package calculator.Model;

import static calculator.Constants.DelimiterConstants.BASIC_DELIMITER;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_START;

import calculator.Utils.StringSplitter;

public class OriginalInput {
    private final String originalInput;

    public OriginalInput(String originalInput) {
        this.originalInput = originalInput;
    }

    public String classifyDelimiter() {
        if (isValidPrefix(this.originalInput) &&
                hasCustomDelimiter(this.originalInput) &&
                isRightCustomDelimiterOrder(this.originalInput)) {
            return StringSplitter.getCustomDelimiter(this.originalInput);
        }

        return BASIC_DELIMITER;
    }

    public String


    private static boolean hasCustomDelimiter(String originalInput) {
        return originalInput.contains(CUSTOM_DELIMITER_START) && originalInput.contains(CUSTOM_DELIMITER_END);
    }

    private static boolean isRightCustomDelimiterOrder(String originalInput) {
        return originalInput.indexOf(CUSTOM_DELIMITER_END) > originalInput.indexOf(CUSTOM_DELIMITER_START);
    }

    private static boolean isValidPrefix(String originalInput) {
        return originalInput.startsWith(CUSTOM_DELIMITER_START);
    }
}
