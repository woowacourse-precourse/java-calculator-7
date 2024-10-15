package calculator;

public enum Message {
    START("덧셈할 문자열을 입력해 주세요."),
    END("결과 : ");

    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
