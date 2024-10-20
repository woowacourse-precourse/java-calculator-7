package calculator.view;

public enum ViewMessages {

    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_MESSAGE("결과 : ");

    private final String message;

    ViewMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
