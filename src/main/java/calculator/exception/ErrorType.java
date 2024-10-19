package calculator.exception;

public enum ErrorType {

    NOT_ALLOWED_NON_NUMERIC("연산식에는 숫자만 허용됩니다."),
    NOT_ALLOWED_NEGATIVE("연산식에는 양수만 허용됩니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
