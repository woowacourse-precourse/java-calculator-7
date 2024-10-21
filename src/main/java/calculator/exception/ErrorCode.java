package calculator.exception;

public enum ErrorCode {
    INVALID_INPUT_VALUE("[ERROR] 구분자를 포함하지 않거나, 잘못된 형식으로 입력했습니다."),
    NON_POSITIVE_VALUE("[ERROR] 양수만 입력해야 합니다."),
    MISSING_NUMBER("[ERROR] 양수를 포함하지 않았습니다."),
    INVALID_CUSTOM_DELIMITER("[ERROR] 잘못된 형식의 커스텀 구분자입니다."),
    INVALID_NUMBER("[ERROR] 정수로 변환할 수 있는 값이 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
