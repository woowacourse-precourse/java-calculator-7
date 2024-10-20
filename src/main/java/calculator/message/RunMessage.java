package calculator.message;

public enum RunMessage {
    START("덧셈할 문자열을 입력해 주세요.\n"),
    RESULT("결과 : %d\n");

    private final String message;


    RunMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
