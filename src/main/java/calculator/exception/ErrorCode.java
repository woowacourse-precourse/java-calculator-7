package calculator.exception;

public enum ErrorCode {
    EMPTY_INPUT("입력 값이 비어있습니다."),
    INVALID_CUSTOM_SEPARATOR("커스텀 구분자 형식이 잘못되었습니다."),
    INVALID_CUSTOM_SEPARATOR_LENGTH("커스텀 구분자는 한 글자만 가능합니다."),
    BLANK_CUSTOM_SEPARATOR("커스텀 구분자는 공백이 될 수 없습니다."),
    NUMERIC_CUSTOM_SEPARATOR("커스텀 구분자는 숫자가 될 수 없습니다."),
    NON_POSITIVE_NUMBER("숫자는 1 이상의 양수여야 합니다."),
    INVALID_NUMBER_FORMAT("문자열은 숫자와 구분자로만 이루어져야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
