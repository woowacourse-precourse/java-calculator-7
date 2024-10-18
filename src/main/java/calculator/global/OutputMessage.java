package calculator.global;

public enum OutputMessage {
    RESULT_OUTPUT("결과 : "),
    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요.\n");


    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
