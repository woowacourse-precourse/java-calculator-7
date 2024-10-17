package calculator.exception;

public enum ErrorMessage {
    INVALID_INPUT("// 또는 숫자로 시작하는 입력을 해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
