package calculator.exception;

public enum ErrorCode {
    NOT_NUMBER("숫자가 아닌 값이 포함되었습니다: "),
    NOT_POSITIVE_NUMBER("양수가 아닌 값이 포함되었습니다: ");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
