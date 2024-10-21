package calculator.exception;

public enum ErrorCode {
    INVALID_OPERATOR("올바른 구분자 형식이 아닙니다."),
    INVALID_INPUT("문자는 입력할 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
