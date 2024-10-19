package calculator.view;

public enum SystemMessage {
    INPUT_STRING("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
