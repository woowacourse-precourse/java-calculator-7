package calculator;

public enum OutputMessage {

    INPUT_ENCOURAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과"),

    ;

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
