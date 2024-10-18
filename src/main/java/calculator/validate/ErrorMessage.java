package calculator.validate;

public enum ErrorMessage {

    INVALID_NUMBER("올바른 양수를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
