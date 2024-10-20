package calculator;

public enum ErrorMessage {
    NULL_INPUT("입력값이 NULL입니다."),
    REGEX_NOT_MATCH_INPUT("압력값이 옳바른 형식이 아닙니다"),
    INTEGER_OUT_OF_RANGE("양수만을 입력해야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}