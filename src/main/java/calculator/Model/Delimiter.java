package calculator.Model;

import static calculator.Constants.DelimiterConstants.DOT;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_BLANK_MESSAGE;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_DIGIT_MESSAGE;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_DOT_MESSAGE;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_EMPTY_MESSAGE;

import calculator.Utils.NumberUtils;
import java.util.Objects;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    private void validateDelimiter(String delimiter) {
        validateNull(delimiter);
        validateDigit(delimiter);
        validateBlank(delimiter);
        validateDot(delimiter);
    }

    private void validateNull(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_EMPTY_MESSAGE.getErrorMessage());
        }
    }

    private void validateBlank(String delimiter) {
        if (delimiter.isBlank()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_BLANK_MESSAGE.getErrorMessage());
        }
    }

    private void validateDot(String delimiter) {
        if (Objects.equals(delimiter, DOT)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_DOT_MESSAGE.getErrorMessage());
        }
    }

    private void validateDigit(String delimiter) {
        if (NumberUtils.isNumeric(delimiter)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_DIGIT_MESSAGE.getErrorMessage());
        }
    }
}
