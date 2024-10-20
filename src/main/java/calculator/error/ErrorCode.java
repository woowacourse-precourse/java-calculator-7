package calculator.error;

public enum ErrorCode {

    NOT_ALLOWED_NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 형식이 포함되어 있습니다."),
    EMPTY_INPUT("입력값이 비어 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
