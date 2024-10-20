package calculator.validator;

import calculator.constant.CalculatorConstants;

public class InputValidator {
    public void validate(String input) {
        if (input.startsWith(CalculatorConstants.CUSTOM_DELIMITER_PREFIX)) {
            validateCustomSeparator(input);
        }
    }

    private void validateCustomSeparator(String input) {
        int newLineIndex = input.indexOf(CalculatorConstants.CUSTOM_DELIMITER_SUFFIX);
        if (newLineIndex == -1 || newLineIndex <= CalculatorConstants.CUSTOM_DELIMITER_PREFIX.length()) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
        String customSeparator = input.substring(CalculatorConstants.CUSTOM_DELIMITER_PREFIX.length(), newLineIndex);
        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
        // 구분자 뒤에 숫자가 있는지 확인
        String restOfInput = input.substring(newLineIndex + CalculatorConstants.CUSTOM_DELIMITER_SUFFIX.length());
        if (restOfInput.isEmpty()) {
            throw new IllegalArgumentException("구분자 뒤에 숫자를 입력해 주세요.");
        }
    }
}