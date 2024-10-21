package calculator.view.constant;

public enum ViewMessage {

    START_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    END_MESSAGE("결과 : ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessageWithResult(int result) {
        return String.format("%s%d", message, result);
    }

    public String getMessage() {
        return message;
    }

}