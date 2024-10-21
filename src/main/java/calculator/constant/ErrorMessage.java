package calculator.constant;

public enum ErrorMessage {
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 입력 양식이 유효하지 않습니다."),
    INVALID_CUSTOM_DELIMITER_VALUE("숫자와 소수점(.)은 구분자로 사용할 수 없습니다."),
    INPUT_NON_NUMERIC_CHARACTER("숫자 또는 구분자만 입력 가능합니다."),
    INPUT_NON_POSITIVE_NUMBER("양수만 입력 가능합니다."),
    INPUT_DOUBLE_OVERFLOW_NUMBER("입력값이 double 범위를 벗어났습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
