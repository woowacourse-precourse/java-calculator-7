package calculator;

public record DelimiterValidator(String input) {

    private static final String FIRST_CUSTOM_DELIMITER = "//";
    private static final String LAST_CUSTOM_DELIMITER = "\\n";

    private boolean isContainsCustomDelimiters() {
        return input.contains(FIRST_CUSTOM_DELIMITER) && input.contains(LAST_CUSTOM_DELIMITER);
    }

    private boolean isRangeOfCustomDelimiter() {
        return input.startsWith(FIRST_CUSTOM_DELIMITER) &&
            (input.indexOf(FIRST_CUSTOM_DELIMITER) < input.indexOf(LAST_CUSTOM_DELIMITER));
    }

    private void validateCustomDelimiterPosition() {
        if (input.indexOf(LAST_CUSTOM_DELIMITER) == 2) {
            throw new IllegalArgumentException(
                ErrorMessage.NOT_FOUND_CUSTOM_DELIMITER.getMessage());
        }

        if (input.indexOf(LAST_CUSTOM_DELIMITER) > 3) {
            throw new IllegalArgumentException(
                ErrorMessage.OUT_OF_RANGE_CUSTOM_DELIMITER.getMessage());
        }
    }

    private void isCustomDelimiterNumber() {
        char customDelimiter = input.charAt(2);

        if (customDelimiter > '0' && customDelimiter < '9') {
            throw new IllegalArgumentException(
                ErrorMessage.CUSTOM_DELIMITER_FORMAT_ERROR.getMessage());
        }
    }

    public boolean validateCustomDelimiter() {
        if (isContainsCustomDelimiters() && isRangeOfCustomDelimiter()) {
            validateCustomDelimiterPosition();
            isCustomDelimiterNumber();

            return true;
        }

        return false;
    }
}
