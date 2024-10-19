package calculator.global.message;

public enum ErrorMessage {
    NULL_INPUT_ERROR("null은 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}