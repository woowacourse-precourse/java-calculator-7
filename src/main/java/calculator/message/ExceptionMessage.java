package calculator.message;

public enum ExceptionMessage {
    INVALID_INPUT_FORMAT("[ERROR] 옳바른 형식을 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
