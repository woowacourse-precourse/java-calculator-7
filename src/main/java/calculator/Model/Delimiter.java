package calculator.Model;

import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_BLANK_MESSAGE;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_DIGIT_MESSAGE;
import static calculator.Constants.ErrorMessages.INVALID_CUSTOM_SEPARATOR_EMPTY_MESSAGE;

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
        isNull(delimiter);
        isDigit(delimiter);
        isBlank(delimiter);
    }

    private void isNull(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_EMPTY_MESSAGE.getErrorMessage());
        }
    }

    private void isBlank(String delimiter) {
        if (delimiter.isBlank()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_BLANK_MESSAGE.getErrorMessage());
        }
    }

    private void isDigit(String delimiter) {
        if (delimiter.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_DIGIT_MESSAGE.getErrorMessage());
        }
    }
}
