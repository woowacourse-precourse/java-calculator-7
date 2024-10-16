package calculator.validator.strategies;

import calculator.view.ErrorMessage;

// 입력값이 커스텀 구분자를 사용할 경우, 그 구분자가 올바르게 정의되었는지 검증하는 클래스
public class CustomDelimiterValidator implements ValidationStrategy {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE = "\n";

    @Override
    public void validate(String input) {
        if (isCustomDelimiter(input)) {
            String[] parts = splitInput(input);
            if (isInvalidDelimiterFormat(parts)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
            }
        }
    }

    // 커스텀 구분자가 있는지 확인
    private boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    // 입력을 커스텀 구분자와 숫자 목록으로 나누기
    private String[] splitInput(String input) {
        return input.split(NEWLINE, 2);
    }

    // 구분자 형식이 올바른지 확인
    private boolean isInvalidDelimiterFormat(String[] parts) {
        return parts.length < 2 || isMissingDelimiter(parts[0]) || isMissingNumbers(parts[1]);
    }

    // 커스텀 구분자가 올바른지 확인
    private boolean isMissingDelimiter(String delimiterPart) {
        return delimiterPart.length() < 3;
    }

    // 숫자가 없는지 확인
    private boolean isMissingNumbers(String numberPart) {
        return numberPart.trim().isEmpty();
    }
}