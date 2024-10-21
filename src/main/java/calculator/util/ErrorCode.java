package calculator.util;

public enum ErrorCode {
    NUMBER_ERROR("숫자는 양수여야됩니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
