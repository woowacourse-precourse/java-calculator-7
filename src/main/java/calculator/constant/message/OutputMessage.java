package calculator.constant.message;

public enum OutputMessage {
    INPUT_STRING("덧셈할 문자열을 입력해주세요"),
    RESULT("결과 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
