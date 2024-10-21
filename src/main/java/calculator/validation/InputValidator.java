package calculator.validation;

import calculator.constants.ExceptionMessage;

public class InputValidator {

    // 입력값 검증
    public void validateInput(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
        }
    }

    // 커스텀 구분자 검증
    public void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.matches("[0-9]+")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_DELIMITER_NUMBER);
        }
        if (customDelimiter.length() > 1) {
            throw new IllegalArgumentException(ExceptionMessage.MULTIPLE_CUSTOM_DELIMITERS);
        }
    }

    // 유효하지 않은 구분자 검증
    public void validateInvalidDelimiter(String text, String validDelimiters) {
        String invalidCharacters = text.replaceAll("[" + validDelimiters + "0-9\\s]", "");
        if (!invalidCharacters.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT);
        }
    }

    // 숫자값 검증
    public int validatePositiveNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num <= 0) {
                throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
