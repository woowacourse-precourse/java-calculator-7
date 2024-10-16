package calculator.Model;

import static calculator.Constants.DelimiterConstants.BASIC_DELIMITER;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_START;

import calculator.Utils.StringSplitter;
import java.util.List;

public class OriginalInput {
    private final String originalInput;

    public OriginalInput(String originalInput) {
        this.originalInput = originalInput;
    }

    public String separateDelimiter() {
        if (hasValidCustomDelimiter(this.originalInput)) {
            return StringSplitter.getCustomDelimiter(this.originalInput);
        }
        return BASIC_DELIMITER;
    }

    public List<String> separateNumbers(Delimiter delimiter) {
        String inputWithoutIndicator = StringSplitter.deleteIndicator(this.originalInput);
        return StringSplitter.splitByDelimiter(inputWithoutIndicator, delimiter);
    }

    private static boolean hasValidCustomDelimiter(String originalInput) {
        return isValidPrefix(originalInput) &&
                hasCustomDelimiter(originalInput) &&
                isRightCustomDelimiterOrder(originalInput);
    }

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
