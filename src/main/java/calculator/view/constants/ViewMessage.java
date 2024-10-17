package calculator.view.constants;

public enum ViewMessage {

    INPUT_VIEW_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_VIEW_MESSAGE("결과 : %d"),
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
