package calculator.domain.exception;

public enum ErrorMessage {
    INVALID_CUSTOM_DELIMITER_ERROR("커스텀 구분자 형식이 잘못되었습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
