package calculator;

import java.util.List;

public class InputValidator {
    private static final String DEFAULT_DELIMITER_PATTERN = "^(\\d+([,:]\\d+)*)?$";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.+)\\n\\d+([,:]\\d+|\\\\1\\d+)*$";

    private final DelimiterManager delimiterManager;

    public InputValidator(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    public boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    public void validateUnregisteredDelimiter(List<String> delimiters) {
        boolean hasInvalidDelimiter = delimiters.stream()
                .anyMatch(delimiter -> !delimiterManager.isValidDelimiter(delimiter));

        if (hasInvalidDelimiter) {
            throw new IllegalArgumentException("등록되지 않은 구분자가 포함되어 있습니다.");
        }
    }

    public void validateInput(String input) {
        validateInputPattern(input);
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