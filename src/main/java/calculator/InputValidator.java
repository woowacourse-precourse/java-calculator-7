package calculator;

public class InputValidator {
    private static final String DEFAULT_DELIMITER_PATTERN = "^(\\d+([,:]\\d+)*)?$";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.+)\\n\\d+([,:]\\d+|\\\\1\\d+)*$";

    public boolean isEmptyInput(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public void validateInputPattern(String input) {
        if (!input.matches(DEFAULT_DELIMITER_PATTERN) && !input.matches(CUSTOM_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }
}