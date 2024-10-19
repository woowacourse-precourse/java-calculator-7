package calculator;

public enum ErrorMessage {
    NULL_INPUT("입력값이 NULL입니다."),
    REGEX_NOT_MATCH_INPUT("압력값이 옳바른 형식이 아닙니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
