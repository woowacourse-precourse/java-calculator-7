package calculator.constant;

public enum OutputMessage {

    INPUT_GUIDE("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : ");

    private final String message;


    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
