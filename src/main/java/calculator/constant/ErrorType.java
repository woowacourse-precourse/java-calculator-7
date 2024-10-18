package calculator.constant;

public enum ErrorType {

    INVALID_INPUT_FORMAT("올바르지 않은 입력 형식 입니다."),
    OUT_OF_RANGE("숫자는 1이상 2,147,483,647이하여야 합니다.");

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
