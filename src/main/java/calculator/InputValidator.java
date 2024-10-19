package calculator;

public class InputValidator {
    private static final String DEFAULT_DELIMITER_PATTERN = "^(\\d+([,:]\\d+)*)?$";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.+)\\n\\d+([,:]\\d+|\\\\1\\d+)*$";

    public boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private void validateInputPattern(String input) {
        if (input.startsWith("//")) {
            validateCustomDelimiterPattern(input);
        } else {
            validateDefaultDelimiterPattern(input);
        }
    }

    private void validateCustomDelimiterPattern(String input) {
        if (!input.matches(CUSTOM_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private void validateDefaultDelimiterPattern(String input) {
        if (!input.matches(DEFAULT_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }
}