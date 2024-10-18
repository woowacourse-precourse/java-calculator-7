package calculator;

public record DelimiterValidator(String input) {

    private static final String FIRST_CUSTOM_DELIMITER = "//";
    private static final String LAST_CUSTOM_DELIMITER = "\\n";

    // 커스텀 구분자 조건
    private boolean isContainsCustomDelimiters() {
        return input.contains(FIRST_CUSTOM_DELIMITER) && input.contains(LAST_CUSTOM_DELIMITER);
    }

    // 커스텀 구분자가 올바른 범위에 있는지
    private boolean isRangeOfCustomDelimiter() {
        return input.startsWith(FIRST_CUSTOM_DELIMITER) &&
            (input.indexOf(FIRST_CUSTOM_DELIMITER) < input.indexOf(LAST_CUSTOM_DELIMITER));
    }

    // 커스텀 구분자가 입력된지 확인
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

    public boolean validateCustomDelimiter() {
        if (isContainsCustomDelimiters() && isRangeOfCustomDelimiter()) {
            validateCustomDelimiterPosition();

            return true;
        }

        return false;
    }
}
