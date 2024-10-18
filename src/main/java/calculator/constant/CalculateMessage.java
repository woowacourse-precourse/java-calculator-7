package calculator.constant;

public enum CalculateMessage {

    INPUT("덧셈할 문자열을 입력해 주세요."),
    RESULT_FORMAT("결과 : %d");

    private final String message;

    CalculateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormatMessage(Object... args) {
        return String.format(message, args);
    }
}
