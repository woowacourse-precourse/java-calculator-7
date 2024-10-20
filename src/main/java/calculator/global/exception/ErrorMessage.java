package calculator.global.exception;

public enum ErrorMessage {

    CUSTOM_DELIMITER_CLOSING_CHAR_MISSING(1001, "커스텀 구분자를 닫는 문자가 없습니다."),
    NEGATIVE_NUMBER_NOT_ALLOWED(1003, "음수는 허용되지 않습니다: %d"),
    NON_NUMERIC_INPUT(1004, "숫자가 아닌 값입니다: %s");

    private final int code;
    private final String message;

    ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}