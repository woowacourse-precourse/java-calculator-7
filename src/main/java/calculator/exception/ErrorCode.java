package calculator.exception;

public enum ErrorCode {
    // Invalid Argument Error
    INVALID_NUMBER("양수만 입력할 수 있습니다."),
    INVALID_VALUE("숫자가 아닌 값이 포함되었습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
