package calculator.common;

public enum OutputMessage {
    START_MESSEAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_MESSAGE("결과 : "),
    ;
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
