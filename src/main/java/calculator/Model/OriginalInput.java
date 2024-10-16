package calculator.Model;

import static calculator.Constants.DelimiterConstants.BASIC_DELIMITER;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_START;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_INDICATOR_MESSAGE;

import calculator.Utils.StringSplitter;
import java.util.List;

public class OriginalInput {
    private final String originalInput;

    public OriginalInput(String originalInput) {
        this.originalInput = originalInput;
    }

    public String separateDelimiter() {
        if (hasValidCustomDelimiter(this.originalInput)) {
            validateCustomIndicator(this.originalInput);
            return StringSplitter.getCustomDelimiter(this.originalInput);
        }
        return BASIC_DELIMITER;
    }

    public List<String> separateNumbers(Delimiter delimiter) {
        String inputWithoutIndicator = StringSplitter.deleteIndicator(this.originalInput);
        return StringSplitter.splitByDelimiter(inputWithoutIndicator, delimiter);
    }

    private void validateCustomIndicator(String originalInput) {
        if (hasValidCustomDelimiter(originalInput)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_INDICATOR_MESSAGE.getErrorMessage());
        }
    }

    private boolean hasValidCustomDelimiter(String originalInput) {
        return isValidPrefix(originalInput) &&
                hasCustomDelimiter(originalInput) &&
                isRightCustomIndicatorOrder(originalInput);
    }
    
    private boolean hasCustomDelimiter(String originalInput) {
        return originalInput.contains(CUSTOM_DELIMITER_START) && originalInput.contains(CUSTOM_DELIMITER_END);
    }

    private boolean isRightCustomIndicatorOrder(String originalInput) {
        return originalInput.indexOf(CUSTOM_DELIMITER_END) > originalInput.indexOf(CUSTOM_DELIMITER_START);
    }

    private boolean isValidPrefix(String originalInput) {
        return originalInput.startsWith(CUSTOM_DELIMITER_START);
    }
}
